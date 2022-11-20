package com.cyrus822.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cyrus822.springboot.models.Students;

public interface StudentsRepo extends JpaRepository<Students, Integer> {
    
}
