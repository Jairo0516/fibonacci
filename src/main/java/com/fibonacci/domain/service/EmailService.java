package com.fibonacci.domain.service;


import com.fibonacci.controller.dto.request.FibonacciRequestDTO;
import org.springframework.http.ResponseEntity;

public interface EmailService {

    void sendMessage(String to, String subject, String text);
}
