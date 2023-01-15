package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dto.BookTicketRequestDto;
import com.example.BookMyShow.Dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.Dto.TicketDto;

public interface TicketService {


    TicketResponseDto getTicket(int id); //H.W (Hint is same as you do in GetMovie)

    TicketResponseDto bookTicket(com.example.BookMyShow.dto.BookTicketRequestDto bookTicketRequestDto);

}
