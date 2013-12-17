package com.journaldev.servlet.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {

		// create the thread pool
		ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 50000L,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
		servletContextEvent.getServletContext().setAttribute("executor",
				executor);

	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) servletContextEvent
				.getServletContext().getAttribute("executor");
		executor.shutdown();
	}

}
