package com.codejam.demo.service;

import com.codejam.demo.entity.PersonalInformation;
import com.codejam.demo.repository.PersonalInformationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonalInformationServiceTest {

    @Mock
    private PersonalInformationRepository personalInformationRepository;

    @InjectMocks
    private PersonalInformationService personalInformationService;



    @Test
    void whenNoActivePerson_findRandomPerson_thenReturnEmptyResult() {
        List<PersonalInformation> personalInformationInactiveList = new ArrayList<>();
        PersonalInformation personalInformationInactive = new PersonalInformation(1,"name","idolName","address","INACTIVE");
        personalInformationInactiveList.add(personalInformationInactive);
        Mockito.when(personalInformationRepository.findAll()).thenReturn(personalInformationInactiveList);
        Mockito.when(personalInformationRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(personalInformationInactive));
        assertEquals(ResponseEntity.of(Optional.of(Optional.empty())),personalInformationService.findRandomPerson());
    }

    @Test
    void whenActivePersonPresent_findRandomPerson_thenReturnSuccessResult() {
         List<PersonalInformation> personalInformationActiveList = new ArrayList<>();
         PersonalInformation personalInformationActive = new PersonalInformation(1, "name", "idolName", "address", "ACTIVE");
        personalInformationActiveList.add(personalInformationActive);
        Optional<PersonalInformation> expectedPersonalInformation = Optional.of(personalInformationActive);
        Mockito.when(personalInformationRepository.findAll()).thenReturn(personalInformationActiveList);
        Mockito.when(personalInformationRepository.findById(Mockito.anyInt())).thenReturn( Optional.of(personalInformationActive));
        assertEquals(ResponseEntity.of(Optional.of(expectedPersonalInformation)),personalInformationService.findRandomPerson());
    }

}