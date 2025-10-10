package com.ds6.dto;

import java.util.UUID;

public record TeacherDTO(
    UUID id,
    String name,
    String qualification,
    String contact
) {}
