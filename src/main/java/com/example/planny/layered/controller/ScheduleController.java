package com.example.planny.layered.controller;

import com.example.planny.layered.dto.ScheduleRequestDto;
import com.example.planny.layered.entity.Schedule;
import com.example.planny.layered.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody @Validated ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleService.createSchedule(requestDto);
        return ResponseEntity.ok(schedule);
    }

    @GetMapping
    public ResponseEntity<?> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchedule(@PathVariable Long id, @RequestBody @Validated ScheduleRequestDto requestDto) {
        Schedule updatedSchedule = scheduleService.updateSchedule(id, requestDto);
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
        return ResponseEntity.ok("삭제 완료");
    }
}
