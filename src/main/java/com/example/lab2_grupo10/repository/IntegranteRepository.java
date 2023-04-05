package com.example.lab2_grupo10.repository;

import com.example.lab2_grupo10.Entity.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository
        extends JpaRepository<Integrante, Integer> {
}
