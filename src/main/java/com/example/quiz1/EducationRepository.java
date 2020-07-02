package com.example.quiz1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {
    Optional<Education> findById(Long id);
}
