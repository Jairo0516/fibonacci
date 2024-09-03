package com.fibonacci.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static com.fibonacci.util.Constants.VAL_DATE_FORMAT_VALUE;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FibonacciRequestDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = VAL_DATE_FORMAT_VALUE)
    @NotNull
    @ApiModelProperty(notes = "Hora de ingreso")
    private String dateValue;

}
