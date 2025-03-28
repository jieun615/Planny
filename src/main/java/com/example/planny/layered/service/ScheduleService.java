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
        schedule.setUsername(requestDto.getUsername());
        schedule.setPassword(requestDto.getPassword()); // 나중에 암호화 필요
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public Schedule updateSchedule(Long id, ScheduleRequestDto requestDto) {
        scheduleRepository.updateSchedule(id, requestDto.getTask(), requestDto.getUsername(), requestDto.getPassword());
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("일정을 찾을 수 없습니다."));
    }

    @Transactional
    public void deleteSchedule(Long id, String password) {
        int deletedCount = scheduleRepository.deleteByIdAndPassword(id, password);
        if (deletedCount == 0) {
            throw new RuntimeException("비밀번호가 일치하지 않거나 일정이 존재하지 않습니다.");
        }
    }
}
