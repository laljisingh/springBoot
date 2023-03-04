package com.example.hibernateMapping.service;

import com.example.hibernateMapping.model.Hostel;
import com.example.hibernateMapping.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostelService {
    @Autowired
    HostelRepository hostelRepository;
    public void addHostel(Hostel hostel) {
        hostelRepository.save(hostel);
    }
}
