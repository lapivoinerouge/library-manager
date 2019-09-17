package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.controller.exceptions.NotFoundException;
import com.lib.kodillalibrary.domain.ReaderDto;
import com.lib.kodillalibrary.mapper.ReaderMapper;
import com.lib.kodillalibrary.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ReaderDto getReader(@RequestParam Long readerId) throws NotFoundException {
        return readerMapper.mapToReaderDto(readerDbService.getReader(readerId).orElseThrow(()-> new NotFoundException(readerId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId) {
        readerDbService.deleteReader(readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "editReader")
    public ReaderDto editReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(readerDbService.saveReader(readerMapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addReader")
    public void addReader(@RequestBody ReaderDto readerDto) {
        readerDbService.saveReader(readerMapper.mapToReader(readerDto));
    }
}
