package com.fatdevs.jsonfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
JSON =>
[{"String" : "A"},
{"Name" : "B"},
{"Help" : "C"}]
{} => object
[] => array
 */
public class MainActivity extends AppCompatActivity {

    private void jsonSetter(JSONArray json, String key, Object replace) throws JSONException {
     for(int i=0;i<json.length();i++){
         JSONObject jsonObject = json.getJSONObject(i); // for every array element object is returned to jsonObject
         if(jsonObject.has(key)){
             jsonObject.putOpt(key,replace); // for replacing
         }
     }
    }
    private String get_Key(JSONArray jsonArray,String key) throws JSONException {
     String value = null;
        for(int i=0;i<jsonArray.length();i++){
            JSONObject ong = jsonArray.getJSONObject(i);
            if(ong.has(key)){
                value = (String) ong.get(key);
            }
        }
        return value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            array.put(jsonObject.put("Akshat","1400"));
            array.put(jsonObject.put("A","1340"));
            array.put(jsonObject.put("B","1030"));
            array.put(jsonObject.put("C","1020"));
            array.put(jsonObject.put("D","1040"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonSetter(array,"Akshat","E");
            String a = get_Key(array,"A");
            Log.i("Str:",a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    Resources res = getResources();





}
