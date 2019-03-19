package com.tree.trjson.tool;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class TrJson<T> {
    private final int FIELD = 1;
    private final int OBJECT = 2;
    private final int ARRAY = 3;

    public TrJson() {

    }

    public T formJson(String json, T o) throws JSONException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        JSONObject jsonObject = new JSONObject(json);//总的JSONobject
        Class mClass = o.getClass();//总的Class
        Field fields[] = mClass.getDeclaredFields();
        o = (T)fieldsTransfer(o,fields,mClass,jsonObject);
        return o;
    }

    //遍历属性数组通过属性类型来调用函数
    private Object fieldsTransfer(Object mObject,Field fields[] , Class mClass, JSONObject jsonObject) throws JSONException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Field f : fields) {
            if (judge(f.getName(),jsonObject) == FIELD){
                mObject = handleField(mObject,f,mClass,jsonObject);
            }else if (judge(f.getName(),jsonObject) == OBJECT){
                mObject = handleObject(mObject,f,mClass,jsonObject);
            }else if (judge(f.getName(),jsonObject) == ARRAY){
                mObject = handleArray(mObject,f,mClass,jsonObject);
            }
        }
        return mObject;
    }

    //通过属性名判断是否为一个对象
    private int judge(String fieldName,JSONObject jsonObject) throws JSONException {
        char name[] = jsonObject.getString(fieldName).toCharArray();
        if (name.length>0){
            switch (name[0]) {
                case '{':
                    return OBJECT;
                case '[':
                    return ARRAY;
                default:
                    return FIELD;
            }
        }
        return FIELD;
    }

    int i = 0;

    //处理属性
    private Object handleField(Object mObject,Field mF,Class mClass,JSONObject jsonObject) throws NoSuchMethodException, JSONException, InvocationTargetException, IllegalAccessException {
        Method setMethod = mClass.getDeclaredMethod(findSetMethodName(mF.getName()),mF.getType());
        Class<?> parameterType = (setMethod.getParameterTypes())[0];
            if ("string".equalsIgnoreCase(mF.getType().getSimpleName())) {
                setMethod.invoke(mObject, jsonObject.get(mF.getName()));
            } else if ("int".equalsIgnoreCase(mF.getType().getSimpleName())
                    || "interger".equalsIgnoreCase(mF.getType().getSimpleName())) {
                setMethod.invoke(mObject, Integer.parseInt(jsonObject.get(mF.getName()).toString()));
            } else if ("double".equalsIgnoreCase(mF.getType().getSimpleName())) {
                setMethod.invoke(mObject, Double.parseDouble(jsonObject.get(mF.getName()).toString()));
            } else if ("boolean".equalsIgnoreCase(mF.getType().getSimpleName())) {
                setMethod.invoke(mObject, Boolean.parseBoolean(jsonObject.get(mF.getName()).toString()));
            }
            return mObject;
    }

    int j = 0;
    //处理对象
    private Object handleObject(Object mObject,Field mF,Class mClass,JSONObject mJsonObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, JSONException, InstantiationException {
        Method setMethod = mClass.getDeclaredMethod(findSetMethodName(mF.getName()), mF.getType());
        JSONObject jsonObject = mJsonObject.getJSONObject(mF.getName());//获得当前对象的JSONobject
        Object object = mF.getType().newInstance();//获得当前的对象
        Class nClass = object.getClass();//获得当前的对象的class对象
        Field fields[] = nClass.getDeclaredFields();//获得当前的类中的属性
        object = fieldsTransfer(object,fields,nClass,jsonObject);//进行处理
        setMethod.invoke(mObject,object);//设置当前对象至外部对象
        return mObject;
    }

    int k = 0;
    //处理数组
    private Object handleArray(Object mObject,Field mF,Class mClass,JSONObject mJsonObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, JSONException, InstantiationException {
        Method setMethod = mClass.getDeclaredMethod(findSetMethodName(mF.getName()), mF.getType());
        JSONArray jsonArray = mJsonObject.getJSONArray(mF.getName());//获取当前的JsonArray
        Type genericType = mF.getGenericType();
        Class<?> genericClazz = null;
        if(genericType instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) genericType;
            //得到泛型里的class类型对象
            genericClazz = (Class<?>)pt.getActualTypeArguments()[0];
        }
        List<Object> beans = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            Object object = genericClazz.newInstance();
            Field fields[] = genericClazz.getDeclaredFields();
            object = fieldsTransfer(object,fields,genericClazz,jsonObject);
            beans.add(object);
        }
        setMethod.invoke(mObject,beans);
        return mObject;
    }

    //通过属性名来找到设置方法名
    private String findSetMethodName(String fieldName) {
        return "set" + transform(fieldName);
    }

    //通过属性名来找到设置方法名
    private String findGetMethodName(String fieldName) {
        return "get" + transform(fieldName);
    }

    //首字母大写
    private String transform(String word){
        char abc[] = word.toCharArray();
        if (abc[0]>= 97 && abc[0]<= 122){
            abc[0] -= 32;
            return String.valueOf(abc);
        }
     return word;
    }

}
