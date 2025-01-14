package com.example.ssccvalidator.controller;

import com.example.ssccvalidator.service.SSCCService;
import com.example.ssccvalidator.model.SSCCRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
