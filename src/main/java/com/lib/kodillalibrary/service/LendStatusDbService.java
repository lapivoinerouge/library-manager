package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.LendStatus;
import com.lib.kodillalibrary.repository.LendStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LendStatusDbService {

    private LendStatusRepository repository;

    public List<LendStatus> getAllStatus() {
        return repository.findAll();
    }

    public Optional<LendStatus> getStatus(final Long id) {
        return repository.findById(id);
    }

    public LendStatus saveStatus(final LendStatus status) {
        return repository.save(status);
    }

    public void deleteStatus(final Long id) {
        repository.deleteById(id);
    }


}
