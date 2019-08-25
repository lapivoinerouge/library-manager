package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.Reader;
import com.lib.kodillalibrary.domain.ReaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    @Autowired
    LendStatusMapper mapper;

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getSignUpDate());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getSignUpDate());
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(r -> new ReaderDto(r.getId(), r.getFirstname(), r.getLastname(), r.getSignUpDate(), mapper.mapToLendStatusDtoList(r.getLendBooks())))
                .collect(Collectors.toList());
    }

}
