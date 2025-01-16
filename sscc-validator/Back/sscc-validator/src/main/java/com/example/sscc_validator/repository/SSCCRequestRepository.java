package com.example.sscc_validator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sscc_validator.model.SSCCRequest;

public interface SSCCRequestRepository extends JpaRepository<SSCCRequest, Long> {}
