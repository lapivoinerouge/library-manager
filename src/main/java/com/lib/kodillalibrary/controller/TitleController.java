package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.domain.BookTitleDto;
import com.lib.kodillalibrary.mapper.TitleMapper;
import com.lib.kodillalibrary.service.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/library/titles")
public class TitleController {

    @Autowired
    TitleDbService titleDbService;
    @Autowired
    TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<BookTitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(titleDbService.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public BookTitleDto getTitle(Long titleId) {
        return new BookTitleDto(1L, "Black Panther", "Jon Don", 1994L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(Long titleId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "editTitle")
    public BookTitleDto editTitle(BookTitleDto bookTitleDto) {
        return new BookTitleDto(1L, "Pink Panther", "Jon Jon", 2004L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addTitle")
    public void addTitle(BookTitleDto bookTitleDto) {

    }


}
