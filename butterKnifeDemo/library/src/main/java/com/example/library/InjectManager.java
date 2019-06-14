package com.example.library;

import android.app.Activity;
import android.view.View;

import com.example.library.annotation.ContentView;
import com.example.library.annotation.EvenetBase;
import com.example.library.annotation.InjectView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InjectManager {

    public static void inject(Activity activity) {
        //layout annotation
        injectLayout(activity);

        //control annotation
        injectViews(activity);

        //event annotation
        injectEvents(activity);
    }

    private static void injectEvents(Activity activity) {
        //get Class
        Class<? extends Activity> clazz = activity.getClass();
        //get all methods
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            //method has more annotation
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                //annotation over annotataion (zhujie shangde zhujie)
                Class<? extends  Annotation> annotationType = annotation.annotationType();
                if (null != annotationType) {
                    EvenetBase evenetBase = annotationType.getAnnotation(EvenetBase.class);
                    if (null != evenetBase) {
                        String listenerSetter = evenetBase.listenerSetter();
                        Class<?> linsterType = evenetBase.linsterType();
                        String callBackListener = evenetBase.callBackListener();

                        try {
                            Method valueMethod = annotationType.getDeclaredMethod("value");
                            int[] viewIds = (int[])valueMethod.invoke(annotation);

                            //pack after user proxy
                            linstenerHandler handler = new linstenerHandler(activity);
                            handler.addMethod(callBackListener, method);
                            Object linstener = Proxy.newProxyInstance(linsterType.getClassLoader(),
                                    new Class[]{linsterType}, handler);

                            for (int viewId : viewIds) {
                                //get view value
                                View viewById = activity.findViewById(viewId);
                                //get method
                                Method setter = viewById.getClass().getMethod(listenerSetter, linsterType);
                                //execute
                                setter.invoke(viewById, linstener);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    private static void injectViews(Activity activity) {
        //get Class
        Class<? extends Activity> clazz = activity.getClass();
        //get class all Field
        Field[] fields = clazz.getDeclaredFields();
        //loop
        for (Field field : fields) {
            //get every Filed
            InjectView injectView = field.getAnnotation(InjectView.class);
            //not everthing has annotation
            if (null != injectView) {
                int viewid = injectView.value();
                try {
                    Method method = clazz.getMethod("findViewById", int.class);
                    Object view = method.invoke(activity, viewid);
                    field.setAccessible(true); // private permission
                    field.set(activity, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static void injectLayout(Activity activity) {
        //get Class
        Class<? extends Activity> clazz = activity.getClass();
        //get annotation
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (null != contentView) {
            //get annotation value
            int layoutId = contentView.value();
            //execute method
            //one method
            //activity.setContentView(layoutId);
            //second method
            try {
                Method method = clazz.getMethod("setContentView", int.class);
                method.invoke(activity, layoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
