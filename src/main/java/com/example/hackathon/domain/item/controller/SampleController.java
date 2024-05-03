package com.example.hackathon.domain.item.controller;

import com.example.hackathon.domain.item.entity.Sample;
import com.example.hackathon.domain.item.service.SampleService;
import com.example.hackathon.global.common.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/samples")
public class SampleController {

    private final SampleService sampleService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Sample>>> getAllSamples() {
        try {
            List<Sample> samples = sampleService.findAllSamples();
            if (samples.isEmpty()) {
                return ResponseEntity.ok(ApiResponse.FAILURE(404, "No samples found"));
            }
            return ResponseEntity.ok(ApiResponse.SUCCESS(200, "Samples retrieved successfully", samples));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.ERROR(500, "Error retrieving samples"));
        }
    }
}

