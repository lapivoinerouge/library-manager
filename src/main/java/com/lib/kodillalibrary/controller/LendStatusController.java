package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.domain.LendStatusDto;
import com.lib.kodillalibrary.mapper.LendStatusMapper;
import com.lib.kodillalibrary.service.LendStatusDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/library/status")
public class LendStatusController {

    @Autowired
    LendStatusDbService lendStatusDbService;
    @Autowired
    LendStatusMapper lendStatusMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getStatusList")
    public List<LendStatusDto> getStatusList() {
        return lendStatusMapper.mapToLendStatusDtoList(lendStatusDbService.getAllStatus());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getStatus")
    public LendStatusDto getStatus(Long statusId) {
        return new LendStatusDto(1L, 2L, 3L, LocalDate.of(2019, 8, 05), LocalDate.of(2019, 9, 21));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteStatus")
    public void deleteStatus(Long statusId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "editStatus")
    public LendStatusDto editStatus(LendStatusDto statusDto) {
        return new LendStatusDto(1L, 2L, 3L, LocalDate.of(2019, 8, 05), LocalDate.of(2019, 9, 21));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addStatus")
    public void addStatus(LendStatusDto statusDto) {

    }

}
