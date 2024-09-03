package com.fibonacci.domain.service.impl;


import com.fibonacci.controller.dto.FibonacciDTO;
import com.fibonacci.controller.dto.request.FibonacciRequestDTO;
import com.fibonacci.domain.entity.Fibonacci;
import com.fibonacci.domain.repository.FibonacciRepository;
import com.fibonacci.domain.service.FibonacciService;
import com.fibonacci.util.Constants;
import com.fibonacci.controller.dto.response.ResponseDTO;
import com.fibonacci.controller.dto.response.StatusDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;


    private StatusDTO statusDTO;

    /*
    * Calcula la serie de Fibonacci usando las semillas dadas y el número de elementos de acuerdo a la hora ctual
    * */
    @Override
    public ResponseEntity<ResponseDTO> create() {
        FibonacciDTO fibonacciDTO = new FibonacciDTO();
        try {

            /*
            * Logica de generación de Fibonacci
            * */
            LocalTime now = LocalTime.now();

            Integer minute = now.getMinute();
            String strMinute = minute.toString();


            Integer param1 = Integer.valueOf(strMinute.substring(0,1));
            Integer param2 = Integer.valueOf(strMinute.substring( 1));
            Integer total = now.getSecond();

            List<String> series = generateFibonacci(
                    param1,
                    param2,
                    total
            );

            fibonacciDTO.setSemillaX(param1);
            fibonacciDTO.setSemillaY(param2);
            fibonacciDTO.setTotal(total);


            /*
            * Se almacenan los datos
            * */
//            Fibonacci fibonacci = fibonacciRepository.save(
//                    Fibonacci.builder().fibonacci(series.toString()).id(1).build()
//            );
            fibonacciDTO.setSerieFibonacci(series.toString());

            statusDTO = new StatusDTO(Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        }catch (Exception e){
            statusDTO = new StatusDTO(Constants.ERROR_MESSAGE, Constants.ERROR_CODE);
        }


        return ResponseEntity.ok(ResponseDTO.builder()
                .status(statusDTO)
                .fibonacciDTO(fibonacciDTO)
                .build());
    }


    /*
     * Calcula la serie de Fibonacci usando las semillas dadas y el número de elementos de acuerdo a lo solciitado
     * */
    @Override
    public ResponseEntity<ResponseDTO> CreateFilter(FibonacciRequestDTO fibonacciRequestDTO) {

        FibonacciDTO fibonacciDTO = new FibonacciDTO();
        try {

            // Formateador de tiempo
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Convertir cadena a LocalTime
            LocalTime time = LocalTime.parse(fibonacciRequestDTO.getDateValue(), formatter);
            System.out.println("Hora convertida: " + time);

            /*
             * Logica de generación de Fibonacci
             * */

            Integer minute = time.getMinute();
            String strMinute = minute.toString();


            Integer param1 = Integer.valueOf(strMinute.substring(0,1));
            Integer param2 = Integer.valueOf(strMinute.substring( 1));
            Integer total = time.getSecond();


            List<String> series = generateFibonacci(
                    param1,
                    param2,
                    total
            );

            fibonacciDTO.setSemillaX(param1);
            fibonacciDTO.setSemillaY(param2);
            fibonacciDTO.setTotal(total);

            Fibonacci fibonacci = fibonacciRepository.save(
                    Fibonacci.builder().fibonacci(series.toString()).build()
            );

            fibonacciDTO.setSerieFibonacci(series.toString());
            statusDTO = new StatusDTO(Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        }catch (Exception e){
            statusDTO = new StatusDTO(Constants.ERROR_MESSAGE, Constants.ERROR_CODE);
        }


        return ResponseEntity.ok(ResponseDTO.builder()
                .status(statusDTO)
                .fibonacciDTO(fibonacciDTO)
                .build());
    }

    private List<String> generateFibonacci(Integer x, Integer y, Integer total){
        List<Integer> series = new ArrayList<>();
        series.add(x);
        series.add(y);

        while (series.size() < total + 2) {
            int nextValue = series.get(series.size() - 1) + series.get(series.size() - 2);
            series.add(nextValue);
        }

        // Ordenar en orden descendente
        Collections.sort(series, Collections.reverseOrder());

        List<String> newList = new ArrayList<String>(series.size());
        for (Integer serieInteger : series) {
            newList.add(serieInteger.toString());
        }
        return newList;
    }
}
