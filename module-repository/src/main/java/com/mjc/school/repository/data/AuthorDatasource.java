package com.mjc.school.repository.data;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AuthorDatasource {
    private static final AuthorDatasource INSTANCE = new AuthorDatasource();

    private final List<Author> authorList;
    private final String AUTHORS_FILE = "author.txt";

    private AuthorDatasource(){
        this.authorList = loadAuthors();
    }

    private List<Author> loadAuthors() {
        List<Author> list = new ArrayList<>();
        List<String> strings = Utils.readFile(AUTHORS_FILE);
        for (int i=0; i<strings.size(); i++){
            list.add(new Author((long) i, strings.get(i)));
        }

        return list;
    }

    public static AuthorDatasource getInstance() {
        return INSTANCE;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }


}
