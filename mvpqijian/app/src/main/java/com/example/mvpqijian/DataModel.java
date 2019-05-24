package com.example.mvpqijian;

public class DataModel {
    public static BaseModel request(Class clazz){

        // 声明一个空的BaseModel
        BaseModel model = null;
        // 判断class对象是不是BaseModel的实例
            try {
                if ((BaseModel) clazz.newInstance() instanceof BaseModel) {
                    //利用反射机制获得对应Model对象的引用
                    model = (BaseModel) clazz.newInstance();
                }
            } catch (ClassFormatError e ) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        return model;
    }
}
