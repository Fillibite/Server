package com.example.hackathon.domain.item.service;

import com.example.hackathon.domain.item.entity.Sample;
import com.example.hackathon.domain.item.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    public List<Sample> findAllSamples() {
        return sampleRepository.findAll();
    }
}
