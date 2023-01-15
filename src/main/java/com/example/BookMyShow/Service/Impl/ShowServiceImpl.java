package com.example.BookMyShow.Service.Impl;

import com.example.BookMyShow.Converter.MovieConverter;
import com.example.BookMyShow.Converter.ShowConverter;
import com.example.BookMyShow.Converter.TheaterConverter;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.ShowService;

import com.example.BookMyShow.Dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.Dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Dto.ResponseDto.TheaterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j //Helps
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        //MovieEntity
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();


        showEntity.setMovie(movieEntity); //Why are we setting these variables
        showEntity.setTheater(theaterEntity);

        showEntity = showRepository.save(showEntity);

        //We need to pass the list of the theater seats
        List<ShowSeatsEntity> l=generateShowEntitySeats(theaterEntity.getSeats(),showEntity);

        showSeatsRepository.saveAll(l);

        //We need to create Response Show Dto.
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);

        return showResponseDto;
    }

    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        //log.info(String.valueOf(theaterSeatsEntityList));
//        log.info("The list of theaterEntity Seats");
//        for(TheaterSeatsEntity tse: theaterSeatsEntityList){
//            log.info(tse.toString());
//        }

        for(TheaterSeatsEntity tse : theaterSeatsEntityList){
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType()).rate(tse.getRate()).build();

            showSeatsEntityList.add(showSeatsEntity);
        }

        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);

        return showSeatsEntityList;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity=showRepository.findById(id).get();
        MovieEntity movieEntity=movieRepository.findById(showEntity.getMovie().getId()).get();
        TheaterEntity theaterEntity=theaterRepository.findById(showEntity.getTheater().getId()).get();
        MovieResponseDto movieResponseDto= MovieConverter.convertEntityToDto(movieEntity);
        TheaterResponseDto theaterResponseDto= TheaterConverter.convertEntityToDto(theaterEntity);
        ShowEntryDto showEntryDto=ShowEntryDto.builder().showDate(showEntity.getShowDate()).showTime(showEntity.getShowTime())
                .movieResponseDto(movieResponseDto).theaterResponseDto(theaterResponseDto).build();
        return ShowConverter.convertEntityToDto(showEntity, showEntryDto);
    }

}