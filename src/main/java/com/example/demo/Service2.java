package com.example.demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

//1245710
//1245841
//1245846
public class Service2 {
    public static String get(String device,String cookie){
        try {
            Document doc = Jsoup.connect("http://c.zg666gps.com/Ajax/DevicesAjax.asmx/GetTracking")
                    .header("Content-Type", "application/json")
                    .cookie("ASP.NET_SessionId",cookie)
                    .requestBody("{DeviceID:"+device+",TimeZone:'China Standard Time'}")
                    .ignoreContentType(true)
                    .timeout(3000)
                    .method(Connection.Method.POST)
                    .post();
            return doc.body().text();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
