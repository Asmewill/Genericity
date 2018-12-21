package com.example.administrator.genericitydemo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件工具类
 * Created by fanyu on 18/1/2.
 */
public class FileUtil {



    /**
     * 获取Asset里面的文件内容
     */
    public static String getFromAssets(String fileName, Context context)  {
        InputStreamReader inputReader=null;
        BufferedReader  bufReader=null;
        String line = "";
        StringBuilder result=new StringBuilder();
        try {
            inputReader = new InputStreamReader(context.getAssets().open(fileName));
             bufReader = new BufferedReader(inputReader);
            while ((line = bufReader.readLine()) != null){
                result.append(line);
            }
             return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputReader!=null){
                    inputReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(inputReader!=null){
                    bufReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}

