package com.example.planny.layered.service;

import com.example.planny.layered.dto.ScheduleRequestDto;
import com.example.planny.layered.entity.Schedule;
import com.example.planny.layered.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Schedule createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setTask(requestDto.getTask());
        schedule.setAuthor(requestDto.getAuthor());
        schedule.setPassword(requestDto.getPassword()); // 나중에 암호화 필요
        return scheduleRepository.save(schedule);
    }
}
