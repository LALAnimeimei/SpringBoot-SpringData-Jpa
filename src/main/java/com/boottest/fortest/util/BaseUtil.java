package com.boottest.fortest.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseUtil {
    public static void httpResponse(HttpServletResponse response,String str){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Cache-Control","no-store");

        try{
            response.getWriter().write(str);
            response.getWriter().close();
        }catch (IOException var2){
            var2.printStackTrace();
        }
    }
}
