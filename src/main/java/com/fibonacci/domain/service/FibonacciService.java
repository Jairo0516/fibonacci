package com.fibonacci.domain.service;


import com.fibonacci.controller.dto.request.FibonacciRequestDTO;
import org.springframework.http.ResponseEntity;

public interface FibonacciService {

    ResponseEntity create() throws Exception;

    ResponseEntity CreateFilter(FibonacciRequestDTO fibonacciRequestDTO) throws Exception;
}
