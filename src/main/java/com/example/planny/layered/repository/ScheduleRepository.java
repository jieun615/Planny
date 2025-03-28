package com.example.planny.layered.repository;

import com.example.planny.layered.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUsername(String username);

    Optional<Schedule> findByIdAndPassword(Long id, String password);

    @Modifying
    @Query("UPDATE Schedule s SET s.task = :task, s.username = :username, s.password = :password, s.updatedAt = CURRENT_TIMESTAMP WHERE s.id = :id")
    void updateSchedule(@Param("id") Long id, @Param("task") String task, @Param("username") String username, @Param("password") String password);

    @Modifying
    @Query("DELETE FROM Schedule s WHERE s.id = :id AND s.password = :password")
    int deleteByIdAndPassword(@Param("id") Long id, @Param("password") String password);
}
