package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.LendStatus;
import com.lib.kodillalibrary.domain.LendStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LendStatusMapper {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    ReaderMapper readerMapper;

    public LendStatus mapToLendStatus(final LendStatusDto lendStatusDto) {
        return new LendStatus(
                lendStatusDto.getId(),
                bookMapper.mapToBook(lendStatusDto.getBookId()),
                readerMapper.mapToReader(lendStatusDto.getReaderId()),
                lendStatusDto.getLendDate(),
                lendStatusDto.getReturnDate());
    }

    public LendStatusDto mapToLendStatusDto(final LendStatus lendStatus) {
        return new LendStatusDto(
                lendStatus.getId(),
                bookMapper.mapToBookDto(lendStatus.getBookId()),
                readerMapper.mapToReaderDto(lendStatus.getReaderId()),
                lendStatus.getLendDate(),
                lendStatus.getReturnDate());
    }

    public List<LendStatusDto> mapToLendStatusDtoList(final List<LendStatus> lendStatusList) {
        return lendStatusList.stream()
                .map(l -> new LendStatusDto(l.getId(), bookMapper.mapToBookDto(l.getBookId()), readerMapper.mapToReaderDto(l.getReaderId()),l.getLendDate(),l.getReturnDate()))
                .collect(Collectors.toList());
    }

    public List<LendStatus> mapToLendStatusList(final List<LendStatusDto> lendStatusDtos) {
        return lendStatusDtos.stream()
                .map(l -> new LendStatus(l.getId(), bookMapper.mapToBook(l.getBookId()), readerMapper.mapToReader(l.getReaderId()), l.getLendDate(), l.getReturnDate()))
                .collect(Collectors.toList());
    }

}
