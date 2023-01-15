package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.Dto.ResponseDto.TicketResponseDto;

public class TicketConverter {

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllottedSeats())
                .build();

    }
}