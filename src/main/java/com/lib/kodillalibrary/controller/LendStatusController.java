package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.controller.exceptions.NotFoundException;
import com.lib.kodillalibrary.domain.LendStatusDto;
import com.lib.kodillalibrary.mapper.LendStatusMapper;
import com.lib.kodillalibrary.service.BookDbService;
import com.lib.kodillalibrary.service.LendStatusDbService;
import com.lib.kodillalibrary.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library/status")
public class LendStatusController {

    @Autowired
    LendStatusDbService lendStatusDbService;
    @Autowired
    LendStatusMapper lendStatusMapper;

    @Autowired
    ReaderDbService readerDbService;
    @Autowired
    BookDbService bookDbService;

    @RequestMapping(method = RequestMethod.GET, value = "getStatusList")
    public List<LendStatusDto> getStatusList() {
        return lendStatusMapper.mapToLendStatusDtoList(lendStatusDbService.getAllStatus());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getStatus")
    public LendStatusDto getStatus(@RequestParam Long statusId) throws NotFoundException {
        return lendStatusMapper.mapToLendStatusDto(lendStatusDbService.getStatus(statusId).orElseThrow(()-> new NotFoundException(statusId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteStatus")
    public void deleteStatus(@RequestParam Long statusId) throws NotFoundException {
        try {
            lendStatusDbService.deleteStatus(statusId);
        } catch (Exception e) {
            throw new NotFoundException(statusId);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "editStatus")
    public void editStatus(@RequestBody LendStatusDto statusDto) throws NotFoundException {

        Long statusId = statusDto.getId();
        Long readerId = statusDto.getReaderId();
        Long bookId = statusDto.getBookId();

        boolean status = lendStatusDbService.getStatus(statusId).isPresent();
        boolean reader = readerDbService.getReader(readerId).isPresent();
        boolean book = bookDbService.getBook(bookId).isPresent();

        if (status && reader && book) {
            lendStatusMapper.mapToLendStatusDto(lendStatusDbService.saveStatus(lendStatusMapper.mapToLendStatus(statusDto)));
        } else {
            throw new NotFoundException(!status? statusId : !reader? readerId : bookId);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "addStatus")
    public void addStatus(@RequestBody LendStatusDto statusDto) {
        lendStatusDbService.saveStatus(lendStatusMapper.mapToLendStatus(statusDto));
    }
}
