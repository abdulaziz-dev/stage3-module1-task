package com.mjc.school.repository.implementation;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.data.NewsDataSource;
import com.mjc.school.repository.entity.NewsModel;

import java.util.List;

public class NewsRepository implements Repository<NewsModel> {

    private List<NewsModel> newsData;

    public NewsRepository(){
        this.newsData = NewsDataSource.getInstance().getNewsList();
    }
    @Override
    public List<NewsModel> readAll() {
        return newsData;
    }

    @Override
    public NewsModel readById(Long id) {
        return newsData.stream().filter(x -> x.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public NewsModel create(NewsModel model) {
        long maxId = newsData.stream().mapToLong(NewsModel::getId).max().orElse(0);
        model.setId(maxId + 1);
        newsData.add(model);
        return model;
    }

    @Override
    public NewsModel update(NewsModel model) {
        NewsModel newsModel = readById(model.getId());
        newsModel.setTitle(model.getTitle());
        newsModel.setContent(model.getContent());
        newsModel.setLastUpdateDate(model.getLastUpdateDate());
        newsModel.setAuthorId(model.getAuthorId());
        return newsModel;
    }

    @Override
    public Boolean exist(Long id) {
        return newsData.stream().anyMatch(x -> x.getId().equals(id));
    }

    @Override
    public Boolean deleteById(Long id) {
        return newsData.removeIf(x -> x.getId().equals(id));
    }

}
