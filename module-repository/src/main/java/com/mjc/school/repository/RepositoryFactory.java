package com.mjc.school.repository;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.implementation.NewsRepository;

public class RepositoryFactory {
    private static final RepositoryFactory INSTANCE = new RepositoryFactory();
    private final Repository<NewsModel> newsRepository = new NewsRepository();

    private RepositoryFactory(){
    }

    public static RepositoryFactory getInstance() {
        return INSTANCE;
    }

    public Repository<NewsModel> getNewsRepository() {
        return newsRepository;
    }
}
