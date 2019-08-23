package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.LendStatus;
import com.lib.kodillalibrary.domain.LendStatusDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LendStatusMapper {

    public LendStatus mapToLendStatus(final LendStatusDto lendStatusDto) {
        return new LendStatus(
                lendStatusDto.getId(),
                lendStatusDto.getBookId(),
                lendStatusDto.getReaderId(),
                lendStatusDto.getLendDate(),
                lendStatusDto.getReturnDate());
    }

    public LendStatusDto mapToLendStatusDto(final LendStatus lendStatus) {
        return new LendStatusDto(
                lendStatus.getId(),
                lendStatus.getBookId(),
                lendStatus.getReaderId(),
                lendStatus.getLendDate(),
                lendStatus.getReturnDate());
    }

    public List<LendStatusDto> mapToLendStatusDtoList(final List<LendStatus> lendStatusList) {
        return lendStatusList.stream()
                .map(l -> new LendStatusDto(l.getId(),l.getBookId(),l.getReaderId(),l.getLendDate(),l.getReturnDate()))
                .collect(Collectors.toList());
    }

    public List<LendStatus> mapToLendStatusList(final List<LendStatusDto> lendStatusDtos) {
        return lendStatusDtos.stream()
                .map(l -> new LendStatus(l.getId(), l.getBookId(), l.getReaderId(), l.getLendDate(), l.getReturnDate()))
                .collect(Collectors.toList());
    }

}
