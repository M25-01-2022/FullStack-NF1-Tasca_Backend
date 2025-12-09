package com.example.tasca_avaluacio.repository;

import com.example.tasca_avaluacio.model.Conflict;
import com.example.tasca_avaluacio.model.Conflict.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConflictRepository extends JpaRepository<Conflict, Long> {
    List<Conflict> findByStatus(Status status);
}
