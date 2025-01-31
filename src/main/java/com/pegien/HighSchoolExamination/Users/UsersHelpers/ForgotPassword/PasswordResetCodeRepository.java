package com.pegien.HighSchoolExamination.Users.UsersHelpers.ForgotPassword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PasswordResetCodeRepository extends JpaRepository<PasswordResetCode,Long> {

    @Query("select c from PasswordResetCode c where c.userId=?1 and c.passwordResetCode=?2")
    Optional<PasswordResetCode> findResetCode(Long userId,String resetCode);
}
