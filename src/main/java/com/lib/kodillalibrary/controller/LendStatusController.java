package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.controller.exceptions.NotFoundException;
import com.lib.kodillalibrary.domain.LendStatusDto;
import com.lib.kodillalibrary.mapper.LendStatusMapper;
import com.lib.kodillalibrary.service.LendStatusDbService;
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

    @RequestMapping(method = RequestMethod.GET, value = "getStatusList")
    public List<LendStatusDto> getStatusList() {
        return lendStatusMapper.mapToLendStatusDtoList(lendStatusDbService.getAllStatus());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getStatus")
    public LendStatusDto getStatus(@RequestParam Long statusId) throws NotFoundException {
        return lendStatusMapper.mapToLendStatusDto(lendStatusDbService.getStatus(statusId).orElseThrow(()-> new NotFoundException(statusId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteStatus")
    public void deleteStatus(@RequestParam Long statusId) {
        lendStatusDbService.deleteStatus(statusId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "editStatus")
    public LendStatusDto editStatus(@RequestBody LendStatusDto statusDto) {
        return lendStatusMapper.mapToLendStatusDto(lendStatusDbService.saveStatus(lendStatusMapper.mapToLendStatus(statusDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addStatus")
    public void addStatus(@RequestBody LendStatusDto statusDto) {
        lendStatusDbService.saveStatus(lendStatusMapper.mapToLendStatus(statusDto));
    }

}
