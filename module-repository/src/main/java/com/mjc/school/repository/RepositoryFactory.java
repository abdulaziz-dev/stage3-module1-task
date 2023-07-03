package com.mjc.school.repository;

import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.implementation.NewsRepository;

public class RepositoryFactory {
    private static final RepositoryFactory INSTANCE = new RepositoryFactory();
    private final Repository<News> newsRepository = new NewsRepository();

    private RepositoryFactory(){
    }

    public static RepositoryFactory getInstance() {
        return INSTANCE;
    }

    public Repository<News> getNewsRepository() {
        return newsRepository;
    }
}
