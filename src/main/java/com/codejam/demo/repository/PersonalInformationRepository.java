package com.codejam.demo.repository;

import com.codejam.demo.entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Integer> {

}
