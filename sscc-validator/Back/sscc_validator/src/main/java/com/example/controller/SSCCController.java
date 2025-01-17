package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SSCCRequest;
import com.example.service.SSCCService;

@RestController
@RequestMapping("/api/sscc")
@CrossOrigin(origins = "http://localhost:4200") // CORS support for frontend
public class SSCCController {

    @Autowired
    private SSCCService ssccService;

    @PostMapping("/validate")
    public SSCCRequest validateSSCC(@RequestBody String ssccNumber) {
        System.out.println("Request received: " + ssccNumber); 
        boolean isValid = ssccService.isValidSSCC(ssccNumber);
        return ssccService.saveRequest(ssccNumber, isValid);
    }
}