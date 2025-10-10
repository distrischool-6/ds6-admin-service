package com.ds6.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SaveTeacherDTO(
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,

    @NotBlank(message = "Discipline cannot be blank")
    @Size(max = 100, message = "Discipline must be up to 100 characters")
    String discipline,

    @NotBlank(message = "Phone cannot be blank")
    @Size(max = 100, message = "Phone must be up to 100 characters")
    String phone
) {}
