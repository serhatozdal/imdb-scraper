package com.serhatozdal.scraper.thread;

import java.util.concurrent.ThreadFactory;

/**
 * @author serhatozdal
 */
public class ScraperThreadFactory implements ThreadFactory {

    private Thread.UncaughtExceptionHandler exceptionHandler = null;

    public ScraperThreadFactory(Thread.UncaughtExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(exceptionHandler);
        return thread;
    }
}
