package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.BookTitle;
import com.lib.kodillalibrary.domain.BookTitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public BookTitle mapToTitle(final BookTitleDto titleDto) {
        return new BookTitle(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYear());
    }

    public BookTitleDto mapToTitleDto(final BookTitle title) {
        return new BookTitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYear());
    }

    public List<BookTitleDto> mapToTitleDtoList(final List<BookTitle> titleList) {
        return titleList.stream()
                .map(t -> new BookTitleDto(t.getId(), t.getTitle(), t.getAuthor(), t.getYear()))
                .collect(Collectors.toList());
    }
}
