package com.mjc.school.repository.data;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AuthorDataSource {
    private static final AuthorDataSource INSTANCE = new AuthorDataSource();

    private final List<AuthorModel> authorList;
    private final String AUTHORS_FILE = "author.txt";

    private AuthorDataSource(){
        this.authorList = loadAuthors();
    }

    private List<AuthorModel> loadAuthors() {
        List<AuthorModel> list = new ArrayList<>();
        List<String> strings = Utils.readFile(AUTHORS_FILE);
        for (int i=0; i<strings.size(); i++){
            list.add(new AuthorModel((long) i, strings.get(i)));
        }

        return list;
    }

    public static AuthorDataSource getInstance() {
        return INSTANCE;
    }

    public List<AuthorModel> getAuthorList() {
        return authorList;
    }


}
