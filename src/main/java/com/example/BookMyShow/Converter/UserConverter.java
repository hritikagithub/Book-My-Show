package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Dto.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.Dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.Dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {


    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        //.builder() is a method

        //I need to create the User
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();


        //Second method for creating the object ??
        //Using the new keyword

    }

    public static UserResponseDto convertEntityToDto(UserEntity user){

        return UserResponseDto.builder().id(user.getId()).name(user.getName())
                .mobNo(user.getMobile()).build();

    }

}