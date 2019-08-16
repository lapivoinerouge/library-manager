package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.LendStatus;
import com.lib.kodillalibrary.repository.LendStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendStatusDbService {

    private LendStatusRepository repository;

    public List<LendStatus> getAllStatus() {
        return repository.findAll();
    }
}
