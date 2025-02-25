package com.victor.vilches.portfolio_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    /**
     * Hämta alla projekt som är byggda med Spring Boot.
     * @return Lista över Spring Boot-projekt.
     */
    @Query("SELECT p FROM Project p WHERE p.springBoot = true")
    List<Project> findAllSpringBootProjects();
}