package com.lib.kodillalibrary.repository;

import com.lib.kodillalibrary.domain.LendStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LendStatusRepository extends CrudRepository<LendStatus, Long> {
    @Override
    List<LendStatus> findAll();

    @Override
    LendStatus save(LendStatus status);

    @Override
    Optional<LendStatus> findById(Long id);

    @Override
    void deleteById(Long id);
}
