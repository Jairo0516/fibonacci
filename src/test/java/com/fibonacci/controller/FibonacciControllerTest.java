package com.fibonacci.controller;

import com.fibonacci.controller.dto.FibonacciDTO;
import com.fibonacci.controller.dto.response.ResponseCreateDTO;
import com.fibonacci.controller.dto.response.ResponseDTO;
import com.fibonacci.domain.service.FibonacciService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
class FibonacciControllerTest {



    @InjectMocks
    private FibonacciController fibonacciController;

    @Mock
    private FibonacciService productService;

    FibonacciDTO fibonacciDTO= new FibonacciDTO();

    ResponseEntity responseEntity = ResponseEntity.ok().build();

    @BeforeEach
    void setUp() {
        fibonacciDTO.setSerieFibonacci("Test description");
    }


    @Test
    public void create() throws Exception {
        Mockito.when(productService.create()).thenReturn(responseEntity);
        ResponseEntity<ResponseCreateDTO> responseCreate = fibonacciController.generate();
        Assert.assertEquals(responseCreate.getStatusCode().value(),200);
    }


}