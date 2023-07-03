package com.mjc.school;

import com.mjc.school.controller.NewsController;
import com.mjc.school.service.dto.NewsRequestDTO;
import com.mjc.school.service.dto.NewsResponseDTO;
import com.mjc.school.service.exceptions.ErrorCodes;
import com.mjc.school.service.exceptions.ValidatorException;

import java.util.Scanner;

public class Operations {
    private final NewsController controller = new NewsController();
    public void getAllNews(){
        controller.getAll().forEach(System.out::println);
    }

    public void getNewsById(){
        System.out.println("Enter news id:");
        Long id = readNumber("News Id");
        NewsResponseDTO dto = controller.getById(id);
        System.out.println(dto);
    }

    public void addNews(){
        NewsRequestDTO requestDTO = readValues(null);
        System.out.println(controller.addNew(requestDTO));
    }

    public void updateNews(){
        System.out.println("Enter news id:");
        Long id = readNumber("News Id");
        NewsRequestDTO requestDTO = readValues(id);
        System.out.println(controller.update(requestDTO));
    }

    public void deleteNewsById(){
        System.out.println("Enter news id:");
        Long id = readNumber("News Id");
        System.out.println(controller.deleteById(id));
    }

    private Long readNumber(String type){
        Scanner scr = new Scanner(System.in);
        try {
            return scr.nextLong();
        } catch (Exception e){
            throw new ValidatorException(String.format(ErrorCodes.CHECK_SHOULD_BE_NUMBER.getMessage(), type));
        }
    }
    private NewsRequestDTO readValues(Long id){
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter news title:");
        String title = scr.nextLine();
        System.out.println("Enter news content:");
        String content = scr.nextLine();
        System.out.println("Enter author id:");
        Long authorId = readNumber("Author Id");
        return new NewsRequestDTO(id, title, content, authorId);
    }
}
