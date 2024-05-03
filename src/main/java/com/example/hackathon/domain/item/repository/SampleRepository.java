package com.example.hackathon.domain.item.repository;

import com.example.hackathon.domain.item.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}