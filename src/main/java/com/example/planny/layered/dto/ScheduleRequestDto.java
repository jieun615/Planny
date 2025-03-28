package com.example.planny.layered.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    @NotBlank
    private String task;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
