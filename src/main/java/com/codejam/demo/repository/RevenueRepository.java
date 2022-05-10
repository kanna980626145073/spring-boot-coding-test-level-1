package com.codejam.demo.repository;

import com.codejam.demo.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Integer> {

}
