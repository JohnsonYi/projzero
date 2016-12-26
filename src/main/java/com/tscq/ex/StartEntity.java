package com.tscq.ex;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Created by johnson on 2016/12/10.
 */
public class StartEntity {
    public static void main(String[] args) {

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.setContextPath("/");
        context.addEventListener(new ContextLoaderListener());
        context.setInitParameter("contextConfigLocation", "classpath:applicationContext.xml");

        server.setHandler(context);

        ServletHolder sh = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        sh.setInitOrder(0);
        sh.setInitParameter("jersey.config.server.provider.classnames", "org.glassfish.jersey.jackson.JacksonFeature");
        sh.setInitParameter("jersey.config.server.provider.packages", "com.tscq.ex.rest");

        try {
            server.start();
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}