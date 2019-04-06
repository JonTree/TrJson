package com.tree.trjson;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.google.gson.Gson;
import com.tree.trjson.tool.JsonTest;
import com.tree.trjson.tool.JsonTest1;
import com.tree.trjson.tool.JsonTest2;
import com.tree.trjson.tool.NewTest;
import com.tree.trjson.tool.TrJson;
import com.tree.trjson.tool.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    List<String> mySuperClass;
    String data = "{\n" +
            "\"employees\": [\n" +
            "{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },\n" +
            "{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },\n" +
            "{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }\n" +
            "]\n" +
            "}";
    @Test
    public void useAppContext() throws NoSuchMethodException, IllegalAccessException, JSONException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.tree.trjson", appContext.getPackageName());
        NewTest n = new NewTest();
//        TrJson.with().factoryBean(data, n);
        Log.d(TAG, "useAppContext: casccadscasdcasddcad"+ n.getEmployees().get(1).getFirstName());
//        Type type = new TypeToken<JsonTest<JsonTest2>>(){}.getType();
//        Class<? super JsonTest<JsonTest2>> a = type;
//        new T<JsonTest<JsonTest2>>(
//        ParameterizedType parameterizedType = j.getClass();
//        JsonTest2 jsonTest2 = j.getAddress();
//        Class c = (Class) jsonTest2.getClass();
//        JsonTest1 jsonTest = (JsonTest1) trJson.formJson(data,new JsonTest1());
        Log.e(TAG, "useAppContext:");
//        Log.e(TAG, "useAppContext: "+ jsonTest.getFeeds().get(0).getOid());
//        Class c = jsonTest.getClass();
//        Field field[] = c.getDeclaredFields();
//        for (Field field1 : field) {
//            Log.e(TAG, "useAppContext: "+field1.getName() );
//        }
//        Log.e(TAG, "useAppContext: "+c.getDeclaredMethod("setName") );
//        JsonTest jsonTest = trJson.formJson(data,new JsonTest());
//        Log.e(TAG, "useAppContext: "+jsonTest.getPage());
//        JSONObject jsonObject = new JSONObject(data);
//        Log.e(TAG, "useAppContext: "+jsonObject.getJSONObject("address"));
//        mySuperClass = new ArrayList<String>();
//        Field field = this.getClass().getDeclaredField("mySuperClass");
//        ParameterizedType type = (ParameterizedType) field.getGenericType();
//        Type[] targets = type.getActualTypeArguments();
//        for (int i = 0; i < targets.length; i++) {
//            System.out.println(targets[i] + "\n" + targets[i].getClass());
//        }
    }
}
