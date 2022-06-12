package com.promineotech.jeep.entity;

import lombok.Data;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class OrderRequest {
    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String customer;

    @NotNull
    private JeepModel model;

    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String trim;

    @Positive
    @Max(4)
    @Min(2)
    private int doors;

    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String color;

    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String engine;

    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String tire;

    private List< @NotNull @Length(max = 30) @Pattern(regexp = "[\\w\\s]*")String> options;
}
