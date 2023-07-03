package com.mjc.school.service;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsRequestDTO;
import com.mjc.school.service.dto.NewsResponseDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-01T11:18:18+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public NewsResponseDTO modelToDto(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;
        Long authorId = null;

        id = newsModel.getId();
        title = newsModel.getTitle();
        content = newsModel.getContent();
        createDate = newsModel.getCreateDate();
        lastUpdateDate = newsModel.getLastUpdateDate();
        authorId = newsModel.getAuthorId();

        NewsResponseDTO newsResponseDTO = new NewsResponseDTO( id, title, content, createDate, lastUpdateDate, authorId );

        return newsResponseDTO;
    }

    @Override
    public List<NewsResponseDTO> modelListToDtoList(List<NewsModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<NewsResponseDTO> list = new ArrayList<NewsResponseDTO>( modelList.size() );
        for ( NewsModel news : modelList ) {
            list.add( modelToDto( news ) );
        }

        return list;
    }

    @Override
    public NewsModel DtoToModel(NewsRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        Long authorId = null;

        id = requestDTO.id();
        title = requestDTO.title();
        content = requestDTO.content();
        authorId = requestDTO.authorId();

        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;

        NewsModel news = new NewsModel( id, title, content, createDate, lastUpdateDate, authorId );

        return news;
    }
}
