package com.codejam.demo.service;

import com.codejam.demo.entity.PersonalInformation;
import com.codejam.demo.repository.PersonalInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PersonalInformationService {

    private final PersonalInformationRepository personalInformationRepository;

    public ResponseEntity<List<PersonalInformation>> getAllPersons() {
        return ResponseEntity.of(Optional.of(personalInformationRepository.findAll()));
    }

    public ResponseEntity<Optional<PersonalInformation>> findRandomPerson() {
        List<PersonalInformation> personalInformationList = personalInformationRepository.findAll();
        Optional<PersonalInformation> person = Optional.empty();
        Random random = new Random();
        int randomId = 0;

        if(getMaxId(personalInformationList  ) > 0) randomId = random.nextInt(getMaxId(personalInformationList)) + 1;
        Optional<PersonalInformation> result = personalInformationRepository.findById(randomId);
        if(result.isPresent() && result.get().getIdolStatus().equals("ACTIVE")) {
            person = result;
        }
        return ResponseEntity.of(Optional.of(person));
    }

    private int getMaxId(List<PersonalInformation> personalInformationList) {

        int max = Integer.MIN_VALUE;
        for (PersonalInformation personalInformationElement:
                personalInformationList ) {
            if(personalInformationElement.getId()> max) {
                max = personalInformationElement.getId();
            }
        }

        return max;
    }
}
