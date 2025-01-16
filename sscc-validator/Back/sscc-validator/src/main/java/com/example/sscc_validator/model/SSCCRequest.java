package com.example.sscc_validator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SSCCRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ssccNumber;
    private boolean isValid;

    public SSCCRequest() {}

    public SSCCRequest(String ssccNumber, boolean isValid) {
        this.ssccNumber = ssccNumber;
        this.isValid = isValid;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsccNumber() {
        return ssccNumber;
    }

    public void setSsccNumber(String ssccNumber) {
        this.ssccNumber = ssccNumber;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
}