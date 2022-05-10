package com.codejam.demo.service;

import com.codejam.demo.entity.Schedule;
import com.codejam.demo.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return ResponseEntity.of(Optional.of( scheduleRepository.findAll()));
    }
}
