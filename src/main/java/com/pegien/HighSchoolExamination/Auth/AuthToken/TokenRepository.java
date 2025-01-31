package com.pegien.HighSchoolExamination.Auth.AuthToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    Optional<Token> findByValue(String value);

    List<Token> findByUserId(Long num);
}
