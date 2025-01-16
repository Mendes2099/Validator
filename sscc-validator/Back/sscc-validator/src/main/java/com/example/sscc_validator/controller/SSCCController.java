package com.example.sscc_validator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sscc_validator.model.SSCCRequest;
import com.example.sscc_validator.service.SSCCService;

@RestController
@RequestMapping("/api/sscc")
public class SSCCController {

    @Autowired
    private SSCCService ssccService;

    @PostMapping("/validate")
    public SSCCRequest validateSSCC(@RequestBody String ssccNumber) {
        boolean isValid = ssccService.isValidSSCC(ssccNumber);
        return ssccService.saveRequest(ssccNumber, isValid);
    }
}
