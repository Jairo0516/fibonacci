package com.fibonacci.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FibonacciDTO {

    @NotNull
    @ApiModelProperty(notes = "Serie Fibonacci")
    private String serieFibonacci;

    @ApiModelProperty(notes = "Semilla x")
    private Integer semillaX;

    @ApiModelProperty(notes = "Semilla y")
    private Integer semillaY;

    @ApiModelProperty(notes = "Total")
    private Integer total;
}
