package com.example.sscc_validator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sscc_validator.model.SSCCRequest;
import com.example.sscc_validator.repository.SSCCRequestRepository;

@Service
public class SSCCService {

    @Autowired
    private SSCCRequestRepository repository;

    // Modulo 10 algorithm number check
    public boolean isValidSSCC(String ssccNumber) {
        if (ssccNumber == null || ssccNumber.length() != 18) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < ssccNumber.length(); i++) {
            int digit = Character.getNumericValue(ssccNumber.charAt(i));
            sum += (i % 2 == 0) ? digit * 3 : digit;
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit == Character.getNumericValue(ssccNumber.charAt(17));
    }

    // Save SSCC request to the database
    public SSCCRequest saveRequest(String ssccNumber, boolean isValid) {
        SSCCRequest request = new SSCCRequest(ssccNumber, isValid);
        return repository.save(request);
    }
}