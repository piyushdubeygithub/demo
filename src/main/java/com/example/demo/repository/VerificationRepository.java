package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Verification;

public interface VerificationRepository extends JpaRepository<Verification, Serializable>{

}
