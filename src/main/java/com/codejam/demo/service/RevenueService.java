package com.codejam.demo.service;

import com.codejam.demo.entity.Revenue;
import com.codejam.demo.repository.RevenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RevenueService {

    private final RevenueRepository revenueRepository;

    public ResponseEntity<List<Revenue>> getAllRevenues() {
        return ResponseEntity.of(Optional.of(revenueRepository.findAll())) ;
    }

}
