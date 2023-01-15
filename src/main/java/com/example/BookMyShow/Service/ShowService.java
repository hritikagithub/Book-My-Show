package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.Dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    //Get show
    //Complete
    ShowResponseDto getShow(int id);
}