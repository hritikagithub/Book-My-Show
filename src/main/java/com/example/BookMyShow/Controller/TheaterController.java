package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Service.Impl.TheaterServiceImpl;
import com.example.BookMyShow.Dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShow.Dto.ResponseDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterServiceImpl theaterService;


    @PostMapping("/add")
    public TheaterResponseDto addTheater(@RequestBody() TheaterEntryDto theaterEntryDto){

        return theaterService.addTheater(theaterEntryDto);

    }

    @GetMapping("/getTheaterDetails/{id}")
    public TheaterResponseDto getTheaterDetails(@PathVariable("id") int theaterId){
        return theaterService.getTheater(theaterId);
    }

}