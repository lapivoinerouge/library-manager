package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.domain.ReaderDto;
import com.lib.kodillalibrary.mapper.ReaderMapper;
import com.lib.kodillalibrary.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/library/readers")
public class ReaderController {

    @Autowired
    ReaderDbService readerDbService;
    @Autowired
    ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(readerDbService.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(Long readerId) {
        return new ReaderDto(1L, "name", "lastname", LocalDate.of(1999, 12,01));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReader")
    public void deleteReader(Long readerId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "editReader")
    public ReaderDto editReader(ReaderDto readerDto) {
        return new ReaderDto(1L, "name2", "lastname2", LocalDate.of(1999, 02, 02));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addReader")
    public void addReader(ReaderDto readerDto) {

    }
}
