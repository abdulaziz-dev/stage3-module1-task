package com.mjc.school.repository;

import com.mjc.school.repository.data.NewsDatasource;
import com.mjc.school.repository.entity.News;

import java.util.List;

public class NewsRepository implements Repository<News>{

    private List<News> newsData;

    public NewsRepository(){
        this.newsData = NewsDatasource.getInstance().getNewsList();
    }
    @Override
    public List<News> getAll() {
        return newsData;
    }

    @Override
    public News getById(Long id) {
        return newsData.stream().filter(x -> x.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public News addNew(News model) {
        long maxId = newsData.stream().mapToLong(News::getId).max().orElse(0);
        model.setId(maxId + 1);
        newsData.add(model);
        return model;
    }

    @Override
    public News update(News model) {
        News newsModel = getById(model.getId());
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
