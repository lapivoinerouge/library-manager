package com.lib.kodillalibrary.repository;

import com.lib.kodillalibrary.domain.LendStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LendStatusRepository extends CrudRepository<LendStatus, Long> {
    @Override
    List<LendStatus> findAll();
}
