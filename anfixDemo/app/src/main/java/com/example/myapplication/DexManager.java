package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Enumeration;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;

public class DexManager {
    private Context context;

    public DexManager(Context context) {
        this.context = context;
    }

    public void loadDex(File dexFilePath) {
        File optFile = new File(context.getCacheDir(), dexFilePath.getName());
        if (optFile.exists()) {
            optFile.delete();
        }
        try {
            DexFile dexFile = DexFile.loadDex(dexFilePath.getAbsolutePath(),
                    optFile.getAbsolutePath(), Context.MODE_PRIVATE);
            //遍历dex file
            Enumeration<String> entry = dexFile.entries();
            while (entry.hasMoreElements()) {
                String className = entry.nextElement();
                Class realClass = dexFile.loadClass(className, context.getClassLoader());
                Log.i("limin", "Find class" + className);

                fix(realClass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void fix(Class realClass)  {
        Method[] methods = realClass.getDeclaredMethods();
        for (Method method : methods) {
            Replace replace = method.getAnnotation(Replace.class);
            if (replace == null) {
                continue;
            }

            String wrongClassName = replace.clazz();
            String wrongMethodName = replace.method();

            try {
                Class wrongClass = Class.forName(wrongClassName);
                try {
                    Method  wrongMethod = wrongClass.getMethod(wrongMethodName,
                            method.getParameterTypes());

                    replace(wrongMethod, method);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private native void replace(Method wrongMethod, Method rightMethod);

}
