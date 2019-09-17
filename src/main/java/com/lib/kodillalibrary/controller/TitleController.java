package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.controller.exceptions.NotFoundException;
import com.lib.kodillalibrary.domain.BookTitleDto;
import com.lib.kodillalibrary.mapper.TitleMapper;
import com.lib.kodillalibrary.service.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BookTitleDto getTitle(@RequestParam Long titleId) throws NotFoundException {
        return titleMapper.mapToTitleDto(titleDbService.getTitle(titleId).orElseThrow(()-> new NotFoundException(titleId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(@RequestParam Long titleId) {
        titleDbService.deleteTitle(titleId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "editTitle")
    public BookTitleDto editTitle(@RequestBody BookTitleDto bookTitleDto) {
        return titleMapper.mapToTitleDto(titleDbService.saveTitle(titleMapper.mapToTitle(bookTitleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addTitle")
    public void addTitle(@RequestBody BookTitleDto bookTitleDto) {
        titleDbService.saveTitle(titleMapper.mapToTitle(bookTitleDto));
    }


}
