package com.example.BookMyShow.Dto.ResponseDto;

import com.example.BookMyShow.Dto.TicketDto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;

    String name;

    String mobNo;

    //Optional
    List<TicketDto> tickets;
}