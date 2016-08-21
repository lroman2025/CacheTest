package com.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by ROLO on 21.08.2016.
 */
public class SampleListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        CacheManager singletonManager = CacheManager.create();
        Cache memoryOnlyCache = new Cache("sampleCache", 100, false, true, 86400,86400);
        singletonManager.addCache(memoryOnlyCache);
        Cache cache = singletonManager.getCache("sampleCache");
        ctx.setAttribute("sampleCache", cache );
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
