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
    String data = "{\n" +
            "    \"feeds\": [\n" +
            "        {\n" +
            "            \"id\": 299080,\n" +
            "            \"oid\": 288342,\n" +
            "            \"category\": \"article\",\n" +
            "            \"data\": {\n" +
            "                \"subject\": \"视频直播：习近平马英九会面\",\n" +
            "                \"summary\": \"两岸领导人习近平、马英九在新加坡会面\",\n" +
            "                \"cover\": \"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG\",\n" +
            "                \"pic\": \"\",\n" +
            "                \"format\": \"video\",\n" +
            "                \"changed\": \"2015-11-07 14:35:22\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 299076,\n" +
            "            \"oid\": 288340,\n" +
            "            \"category\": \"article\",\n" +
            "            \"data\": {\n" +
            "                \"subject\": \"荔枝新闻3.0：不止是阅读\",\n" +
            "                \"summary\": \"江苏广电旗下资讯类手机应用“荔枝新闻”于近期推出全新升级换代的3.0版。\",\n" +
            "                \"cover\": \"/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG\",\n" +
            "                \"pic\": \"\",\n" +
            "                \"format\": \"txt\",\n" +
            "                \"changed\": \"2015-09-22 16:01:41\"\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"PageIndex\": 1,\n" +
            "    \"PageSize\": 20,\n" +
            "    \"TotalCount\": 53521,\n" +
            "    \"TotalPage\": 2677\n" +
            "}\n";
    @Test
    public void useAppContext() throws NoSuchMethodException, IllegalAccessException, JSONException, InvocationTargetException, InstantiationException {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.tree.trjson", appContext.getPackageName());
        TrJson trJson = new TrJson();
        JsonTest2 j = new JsonTest2();
        JsonTest2 jsonTest = (JsonTest2) trJson.formJson(data,j);
        Log.e(TAG, "useAppContext: "+ jsonTest.getFeeds().get(0).getOid());
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
