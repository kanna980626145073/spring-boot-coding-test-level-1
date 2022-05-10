package com.codejam.demo.controller;

import com.codejam.demo.entity.PersonalInformation;
import com.codejam.demo.entity.Revenue;
import com.codejam.demo.entity.Schedule;
import com.codejam.demo.service.PersonalInformationService;
import com.codejam.demo.service.RevenueService;
import com.codejam.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {

    private final PersonalInformationService personalInformationService;
    private final RevenueService revenueService;
    private final ScheduleService scheduleService;

    @GetMapping(path = "/unit-test")
    ResponseEntity<Integer> getUnitTestResult() throws Exception{
        return null;
    }

    @GetMapping(path = "/persons")
    ResponseEntity<List<PersonalInformation>> getAllPersons() throws Exception {
        return personalInformationService.getAllPersons();
    }

    @GetMapping(path = "/random-person")
    ResponseEntity<Optional<PersonalInformation>> getRandomPerson() throws Exception {
        return personalInformationService.findRandomPerson();
    }

    @GetMapping("/revenues")
    ResponseEntity<List<Revenue>> getAllRevenues() throws Exception {
        return revenueService.getAllRevenues();
    }

    @GetMapping("/schedules")
    ResponseEntity<List<Schedule>> getAllSchedules() throws Exception {
        return scheduleService.getAllSchedules();
    }




}
