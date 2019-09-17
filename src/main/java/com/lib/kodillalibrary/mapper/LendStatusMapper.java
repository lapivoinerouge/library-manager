package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.Book;
import com.lib.kodillalibrary.domain.LendStatus;
import com.lib.kodillalibrary.domain.LendStatusDto;
import com.lib.kodillalibrary.domain.Reader;
import com.lib.kodillalibrary.service.BookDbService;
import com.lib.kodillalibrary.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LendStatusMapper {

    @Autowired
    BookDbService bookDbService;

    @Autowired
    ReaderDbService readerDbService;

    public LendStatus mapToLendStatus(final LendStatusDto lendStatusDto) {
        return new LendStatus(
                lendStatusDto.getId(),
                bookDbService.getBook(lendStatusDto.getBookId()).orElse(new Book()),
                readerDbService.getReader(lendStatusDto.getReaderId()).orElse(new Reader()),
                lendStatusDto.getLendDate(),
                lendStatusDto.getReturnDate());
    }

    public LendStatusDto mapToLendStatusDto(final LendStatus lendStatus) {
        return new LendStatusDto(
                lendStatus.getId(),
                lendStatus.getBookId().getId(),
                lendStatus.getReaderId().getId(),
                lendStatus.getLendDate(),
                lendStatus.getReturnDate());
    }

    public List<LendStatusDto> mapToLendStatusDtoList(final List<LendStatus> lendStatusList) {
        return lendStatusList.stream()
                .map(l -> new LendStatusDto(l.getId(), l.getBookId().getId(), l.getReaderId().getId(),l.getLendDate(),l.getReturnDate()))
                .collect(Collectors.toList());
    }

//    public List<LendStatus> mapToLendStatusList(final List<LendStatusDto> lendStatusDtos) {
//        return lendStatusDtos.stream()
//                .map(l -> new LendStatus(l.getId(), bookMapper.mapToBook(l.getBookId()), readerMapper.mapToReader(l.getReaderId()), l.getLendDate(), l.getReturnDate()))
//                .collect(Collectors.toList());
//    }

}
