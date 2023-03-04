package com.example.hibernateMapping.repository;

import com.example.hibernateMapping.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Integer> {
}
