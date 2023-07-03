package com.mjc.school.repository.data;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsDatasource {

    private static final NewsDatasource INSTANCE = new NewsDatasource();
    private final List<News> newsList;
    private final List<Author> authorList = AuthorDatasource.getInstance().getAuthorList();
    private final String TITLES_FILE = "news.txt";
    private final String CONTENT_FILE = "content.txt";
    private NewsDatasource(){
        this.newsList = loadNews(authorList);
    }

    private List<News> loadNews(List<Author> authorList) {
        List<News> news = new ArrayList<>();
        List<String> titles = Utils.readFile(TITLES_FILE);
        List<String> contents = Utils.readFile(CONTENT_FILE);
        int title_size = titles.size();
        for (int i=0; i<contents.size(); i++){
            long random_number = new Random().nextLong(20);
            news.add(new News((long) i,
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

    public static NewsDatasource getInstance(){
        return INSTANCE;
    }

    public List<News> getNewsList() {
        return newsList;
    }
}
