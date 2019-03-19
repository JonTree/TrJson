package com.tree.trjson;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.tree.trjson.tool.JsonTest;
import com.tree.trjson.tool.JsonTest2;
import com.tree.trjson.tool.TrJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    String data = "{\"result\":\"0\",\"res_info\":\"ok\",\"queryorder_info\":{\"order_num\":\"5\",\"orderdetail\":\"ok\"}}";
    @Test
    public void useAppContext() throws NoSuchMethodException, IllegalAccessException, JSONException, InvocationTargetException, InstantiationException {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.tree.trjson", appContext.getPackageName());
        TrJson trJson = new TrJson();
        JsonTest2 j = new JsonTest2();
        JsonTest2 jsonTest = (JsonTest2) trJson.formJson(data,j);
        Log.e(TAG, "useAppContext: "+ jsonTest.getRes_info());
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
    }
}
