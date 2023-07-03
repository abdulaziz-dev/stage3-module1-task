package com.mjc.school.service;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final NewsService newsService;

    private ServiceFactory(){
        this.newsService = new NewsService();
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public NewsService getNewsService(){
         return newsService;
    }

}
