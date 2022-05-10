package com.codejam.demo.controller;

import com.codejam.demo.constants.PathConstants;
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
@RequestMapping(path = PathConstants.DEMO_PATH)
public class DemoController {

    private final PersonalInformationService personalInformationService;
    private final RevenueService revenueService;
    private final ScheduleService scheduleService;

    @GetMapping(path = PathConstants.UNIT_TEST_PATH)
    ResponseEntity<Integer> getUnitTestResult() {
        return null;
    }

    @GetMapping(path = PathConstants.PERSONS_PATH)
    ResponseEntity<List<PersonalInformation>> getAllPersons() {
        return personalInformationService.getAllPersons();
    }

    @GetMapping(path = PathConstants.RANDOM_PERSON_PATH)
    ResponseEntity<Optional<PersonalInformation>> getRandomPerson() {
        return personalInformationService.findRandomPerson();
    }

    @GetMapping(path = PathConstants.REVENUES_PATH)
    ResponseEntity<List<Revenue>> getAllRevenues() {
        return revenueService.getAllRevenues();
    }

    @GetMapping(path = PathConstants.SCHEDULES_PATH)
    ResponseEntity<List<Schedule>> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }




}
