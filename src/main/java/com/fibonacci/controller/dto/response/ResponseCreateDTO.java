package com.fibonacci.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fibonacci.controller.dto.FibonacciDTO;
import lombok.*;


@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ResponseCreateDTO {

    private StatusDTO status;

    private FibonacciDTO fibonacciDTO;
}
