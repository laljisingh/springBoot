package com.example.Doctor.service;

import com.example.Doctor.dao.PatientRepository;
import com.example.Doctor.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository repository;

    public void savePatient(Patient patient) {
        repository.save(patient);
    }
}
