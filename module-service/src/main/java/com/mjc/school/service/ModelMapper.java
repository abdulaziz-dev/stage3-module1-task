package com.mjc.school.service;

import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsRequestDTO;
import com.mjc.school.service.dto.NewsResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface ModelMapper {
    NewsResponseDTO modelToDto(News newsModel);
    List<NewsResponseDTO> modelListToDtoList(List<News> modelList);

    @Mappings(value = {@Mapping(target = "createDate", ignore = true),
                        @Mapping(target = "lastUpdateDate", ignore = true)})
    News DtoToModel(NewsRequestDTO requestDTO);

}
