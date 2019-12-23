package com.example.demo;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;

@Component
public class Service {
    @Scheduled(fixedRate = 1000 * 60 * 10)
    public void Login(){
        try {
            final WebClient webClient = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
            webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
            webClient.getOptions().setActiveXNative(false);
            webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
            webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
            webClient.getOptions().setUseInsecureSSL(true);
            HtmlPage page = null;
            HtmlPage page2 = null;
            page = webClient.getPage("http://www.zg666gps.com/Login.aspx");//尝试加载上面图片例子给出的网页
            HtmlInput formusername = page.getElementByName("txtUserName");
            HtmlPasswordInput password = page.getElementByName("txtAccountPassword");
            HtmlSubmitInput button = page.getElementByName("btnLoginAccount");
            formusername.setValueAttribute("超力班车");
            password.setValueAttribute("123456");
            page2 = button.click();
            Set c = webClient.getCookies(new URL("http://c.zg666gps.com"));
            String aa = "";
            for(Object o :c){
                aa = aa + o.toString();
            }
            Mydata.Cookie =  aa.substring(18,aa.indexOf(";"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
