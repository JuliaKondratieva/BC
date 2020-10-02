package com.julieandco.bookservice.repo;

import com.julieandco.bookservice.entities.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoxRepository extends JpaRepository<Box, UUID> {
}
