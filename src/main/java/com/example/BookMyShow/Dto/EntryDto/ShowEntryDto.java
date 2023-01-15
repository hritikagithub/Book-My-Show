package com.example.BookMyShow.Dto.EntryDto;

import com.example.BookMyShow.Dto.ResponseDto.MovieResponseDto;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    com.example.BookMyShow.dto.ResponseDto.TheaterResponseDto theaterResponseDto;
}