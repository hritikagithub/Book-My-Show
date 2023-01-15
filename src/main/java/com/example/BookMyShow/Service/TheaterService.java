package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShow.Dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {


    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);

}