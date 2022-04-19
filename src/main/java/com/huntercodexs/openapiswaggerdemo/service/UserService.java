package com.huntercodexs.openapiswaggerdemo.service;

import com.huntercodexs.openapiswaggerdemo.dto.request.UserRequestDto;
import com.huntercodexs.openapiswaggerdemo.dto.response.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public ResponseEntity<UserResponseDto> readOne(String userid) {
        return null;
    }

    public ResponseEntity<UserResponseDto> readAll() {
        return null;
    }

    public ResponseEntity<UserResponseDto> create(UserRequestDto user) {
        return null;
    }

    public ResponseEntity<UserResponseDto> delete(String userid) {
        return null;
    }

    public ResponseEntity<UserResponseDto> update(String userid, UserRequestDto user) {
        return null;
    }

    public ResponseEntity<UserResponseDto> patch(String userid, UserResponseDto user) {
        return null;
    }
}
