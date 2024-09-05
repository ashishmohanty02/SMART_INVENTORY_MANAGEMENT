package com.example.pratice1.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private  String message;
    private  boolean status;
    private HttpStatus httpStatuscode;
}
