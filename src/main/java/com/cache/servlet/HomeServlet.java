package com.cache.servlet;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * Created by ROLO on 19.08.2016.
 */
public class HomeServlet extends HttpServlet {

    Logger logger = LogManager.getLogger(HomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet");
        try {
            Element e = getCache().get("test");
            String result = "qwqw";
            if (e != null) {
                result = (String) e.getObjectValue();
            } else {
                // Write code to create the object you need to cache, then store it in the cache.
                Element resultCacheElement = new Element("test", result);
                getCache().put(resultCacheElement);

            }

            System.out.println("from cache = " + result);
        }catch (Exception e){
            System.out.println(e);
        }
//        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doPosts");
//        super.doPost(req, resp);
    }

    public Cache getCache(){
        return  (Cache) this.getServletContext().getAttribute("sampleCache");
    }
}
