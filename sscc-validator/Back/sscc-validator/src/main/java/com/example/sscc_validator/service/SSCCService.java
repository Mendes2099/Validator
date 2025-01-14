package com.example.ssccvalidator.service;

import com.example.ssccvalidator.model.SSCCRequest;
import com.example.ssccvalidator.repository.SSCCRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SSCCService {

    @Autowired
    private SSCCRequestRepository repository;

    // Modulo 10 algorithm number check
    public boolean isValidSSCC(String ssccNumber) {
        //! Check if the input is a valid SSCC number
        if (ssccNumber == null || ssccNumber.length() != 18) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < ssccNumber.length(); i++) {
            int digit = Character.getNumericValue(ssccNumber.charAt(i));
            // Multiply odd positions by 3 and even by 1
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
