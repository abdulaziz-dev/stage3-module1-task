package com.mjc.school.controller;

import com.mjc.school.service.Service;
import com.mjc.school.service.ServiceFactory;
import com.mjc.school.service.dto.NewsRequestDTO;
import com.mjc.school.service.dto.NewsResponseDTO;

import java.util.List;

public class NewsController implements Controller<NewsRequestDTO, NewsResponseDTO>{
    private final Service<NewsRequestDTO, NewsResponseDTO> service = ServiceFactory.getInstance().getNewsService();


    @Override
    public List<NewsResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public NewsResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public NewsResponseDTO addNew(NewsRequestDTO req) {
        return service.addNew(req);
    }

    @Override
    public NewsResponseDTO update(NewsRequestDTO req) {
        return service.update(req);
    }

    @Override
    public Boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
