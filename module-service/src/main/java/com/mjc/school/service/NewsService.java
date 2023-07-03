package com.mjc.school.service;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.RepositoryFactory;
import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsRequestDTO;
import com.mjc.school.service.dto.NewsResponseDTO;
import com.mjc.school.service.exceptions.ErrorCodes;
import com.mjc.school.service.exceptions.NotExistException;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

public class NewsService implements Service<NewsRequestDTO, NewsResponseDTO> {
    private final Repository<News> newsRepository;
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private final NewsValidator validator = NewsValidator.getInstance();

    public NewsService() {
        this.newsRepository = RepositoryFactory.getInstance().getNewsRepository();
    }

    @Override
    public List<NewsResponseDTO> getAll() {
        return mapper.modelListToDtoList(newsRepository.getAll());
    }

    @Override
    public NewsResponseDTO getById(Long id) {
        checkNewsExist(id);
        News news = newsRepository.getById(id);
        return mapper.modelToDto(news);
    }

    @Override
    public NewsResponseDTO addNew(NewsRequestDTO req) {
        validator.checkDTO(req);
        News news = mapper.DtoToModel(req);
        LocalDateTime now = LocalDateTime.now().withNano(0);
        news.setCreateDate(now);
        news.setLastUpdateDate(now);
        return mapper.modelToDto(newsRepository.addNew(news));
    }

    @Override
    public NewsResponseDTO update(NewsRequestDTO req) {
        validator.checkDTO(req);
        News news = mapper.DtoToModel(req);
        news.setLastUpdateDate(LocalDateTime.now().withNano(0));
        News updatedNews = newsRepository.update(news);
        return mapper.modelToDto(updatedNews);
    }

    @Override
    public Boolean deleteById(Long id) {
        checkNewsExist(id);
        return newsRepository.deleteById(id);
    }

    private void checkNewsExist(Long id){
        if (!newsRepository.exist(id)){
            throw new NotExistException(String.format(ErrorCodes.NEWS_NOT_EXIST.getMessage(),id));
        }
    }
}
