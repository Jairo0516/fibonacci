package com.fibonacci.controller;

import com.fibonacci.controller.dto.request.FibonacciRequestDTO;
import com.fibonacci.controller.dto.response.ResponseDTO;
import com.fibonacci.domain.service.FibonacciService;
import com.fibonacci.controller.dto.response.ResponseCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/fibonacci")
@CrossOrigin(origins= "*" , allowedHeaders = "*")
@RestController
@Validated
@Api(value = "Store Products", tags = "Products")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;


    @ApiOperation(value = "Generate Fibonacci")
    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public ResponseEntity<ResponseCreateDTO> generate() throws Exception {
        return fibonacciService.create();

    }

    @ApiOperation(value = "Generate Fibonacci Post", response = ResponseDTO.class)
    @RequestMapping(value = "/generate/filter", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> generateFilter(@RequestBody @Valid FibonacciRequestDTO fibonacciRequestDTO) throws Exception {
        return fibonacciService.CreateFilter(fibonacciRequestDTO);
    }


}
