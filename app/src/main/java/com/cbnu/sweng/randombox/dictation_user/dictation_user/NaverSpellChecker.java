package com.cbnu.sweng.randombox.dictation_user.dictation_user;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by user on 2017-08-20.
 */

public class NaverSpellChecker extends AsyncTask<String, Void, String>{

    @Override
    protected String doInBackground(String... params) {
        String result = parser(params[0]);
        return result;
    }

    public String parser(String text){
        String result = null;

        try{
            String param = encodeURIComponent(text);
            String line;
            URL url = new URL("https://m.search.naver.com/p/csearch/dcontent/spellchecker.nhn?_callback="
                                + "window.__jindo2_callback._spellingCheck_0&q="
                                + param);

            BufferedReader bin = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            while ((line = bin.readLine()) != null){
                result += line;
            }
            bin.close();

        }
        catch (Exception e){
            e.printStackTrace();
            Log.d("Net", "NETWORK ERROR");
        }

        result = result.substring(result.indexOf("\"html\":")+8, result.length()-6);
        return result;
    }

    public static String encodeURIComponent(String s){
        String result = null;
        try{
            result = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!")
                                                    .replaceAll("\\%27", "'").replaceAll("\\%28", "(")
                                                    .replaceAll("\\%29", ")") .replaceAll("\\%7E", "~");
        }
        catch(UnsupportedEncodingException e){
            result = s;
        }

        return result;
    }

}
