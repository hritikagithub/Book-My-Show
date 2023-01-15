package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.Dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    //Add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);


}