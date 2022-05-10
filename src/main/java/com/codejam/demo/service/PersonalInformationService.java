package com.codejam.demo.service;

import com.codejam.demo.entity.PersonalInformation;
import com.codejam.demo.repository.PersonalInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalInformationService {

    private final PersonalInformationRepository personalInformationRepository;

    public ResponseEntity<List<PersonalInformation>> getAllPersons() {
        return ResponseEntity.of(Optional.of(personalInformationRepository.findAll()));
    }

}
