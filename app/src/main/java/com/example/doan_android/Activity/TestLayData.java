package com.example.doan_android.Activity;

import com.example.doan_android.Model.SSLHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TestLayData {
    public static void main(String[] args) throws Exception {


        String url = "https://www.etrip4u.com/tim-ve-may-bay/SGN-HAN-20220105-100";


        Document document = SSLHelper.getConnection(url).get();

        String question = document.select("h2").text();
        System.out.println("Tên tài khoản: " + question);





        Elements elem = document.getElementsByClass("flightJson");
        System.out.println(elem.attr("value"));

        Elements r = document.select("input[type=hidden] ");



        for (int i=0;i< r.size();i++){
            System.out.println(i+". " + r.get(i).attr("value")+ "\t\n");
        }


    }
}
