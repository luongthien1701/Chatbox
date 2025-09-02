package com.example.demo.repository;

import com.example.demo.Model.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcountRepository extends JpaRepository<Acount, Long> {
    Optional<Acount> findByUsernameAndPassword(String username, String password);
    Optional<Acount> findByUsername(String username);
    Optional<Acount> findByuserId(Integer userId);
    Optional<Acount>  findByDisplayName(String DisplayName);
}
