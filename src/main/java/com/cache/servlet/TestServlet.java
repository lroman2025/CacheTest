package com.cache.servlet;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ROLO on 19.08.2016.
 */
public class TestServlet extends HttpServlet {

    Logger logger = LogManager.getLogger(HomeServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet test");
        super.doPost(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCache().put(new Element("test", "test 11wdsds"));
        logger.info("doGet test");
//        super.doGet(req, resp);
    }

    public Cache getCache(){
        return  (Cache) this.getServletContext().getAttribute("sampleCache");
    }
}
