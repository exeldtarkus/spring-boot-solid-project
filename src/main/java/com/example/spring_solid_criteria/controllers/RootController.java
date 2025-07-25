package com.example.spring_solid_criteria.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_solid_criteria.common.BaseApiResponse;
import com.example.spring_solid_criteria.dto.BaseApiResponseDto;

/**
 * RootController handles the root endpoint of the application.
 * It returns a success response with a message indicating the service name.
 */
@RestController
public class RootController {

    @GetMapping("/")
    public ResponseEntity<BaseApiResponseDto<Object>> index() {
        return BaseApiResponse.success(null, "ms-user");
    }
}
