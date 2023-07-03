package com.mjc.school.service;

import com.mjc.school.service.dto.NewsRequestDTO;
import com.mjc.school.service.exceptions.ErrorCodes;
import com.mjc.school.service.exceptions.NotExistException;
import com.mjc.school.service.exceptions.ValidatorException;

public class NewsValidator {
    private static final NewsValidator INSTANCE = new NewsValidator();
    private static final int TITLE_MAX_LENGTH = 30;
    private static final int TITLE_MIN_LENGTH = 5;
    private static final int CONTENT_MIN_LENGTH = 5;
    private static final int CONTENT_MAX_LENGTH = 255;
    private static final int MAX_AUTHOR_ID = 20;

    private NewsValidator(){}

    public static NewsValidator getInstance() {
        return INSTANCE;
    }

    public void checkDTO(NewsRequestDTO dto){
        int titleLength = dto.title().length();
        int contentLength = dto.content().length();
        long authorId = dto.authorId();
        if (titleLength < TITLE_MIN_LENGTH || titleLength > TITLE_MAX_LENGTH){
            throw new ValidatorException(String.format(ErrorCodes.CHECK_TITLE_LENGTH.getMessage(),TITLE_MIN_LENGTH,TITLE_MAX_LENGTH,dto.title()));
        }
        if (contentLength < CONTENT_MIN_LENGTH || contentLength > CONTENT_MAX_LENGTH){
            throw new ValidatorException(String.format(ErrorCodes.CHECK_CONTENT_LENGTH.getMessage(), CONTENT_MIN_LENGTH, CONTENT_MAX_LENGTH, dto.content()));
        }
        if (authorId > MAX_AUTHOR_ID || authorId < 0){
            throw new NotExistException(String.format(ErrorCodes.AUTHOR_NOT_EXIST.getMessage(),authorId));
        }
    }
}
