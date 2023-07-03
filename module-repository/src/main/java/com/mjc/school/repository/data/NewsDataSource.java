package com.mjc.school.repository.data;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsDataSource {

    private static final NewsDataSource INSTANCE = new NewsDataSource();
    private final List<NewsModel> newsList;
    private final List<AuthorModel> authorList = AuthorDataSource.getInstance().getAuthorList();
    private final String TITLES_FILE = "news.txt";
    private final String CONTENT_FILE = "content.txt";
    private NewsDataSource(){
        this.newsList = loadNews(authorList);
    }

    private List<NewsModel> loadNews(List<AuthorModel> authorList) {
        List<NewsModel> news = new ArrayList<>();
        List<String> titles = Utils.readFile(TITLES_FILE);
        List<String> contents = Utils.readFile(CONTENT_FILE);
        int title_size = titles.size();
        for (int i=0; i<contents.size(); i++){
            long random_number = new Random().nextLong(20);
            news.add(new NewsModel((long) i,
                    titles.get(i % title_size),
                    contents.get(i),
                    LocalDateTime.now().minusDays(random_number).withNano(0),
                    LocalDateTime.now().minusDays(random_number).withNano(0),
                    authorList.get((int) random_number).getId()
                    )
            );
        }

        return news;
    }

    public static NewsDataSource getInstance(){
        return INSTANCE;
    }

    public List<NewsModel> getNewsList() {
        return newsList;
    }
}
