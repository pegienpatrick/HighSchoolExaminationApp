package com.pegien.HighSchoolExamination.Users.Repository;

import com.pegien.HighSchoolExamination.Users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

//    @Query("SELECT u FROM User u WHERE u.added = true AND u.username ILIKE :username")
//    Optional<User> findByUsernameIgnoreCase(@Param("username") String username);

   
    Optional<User> findByUsernameIgnoreCaseAndAddedTrue(String username);
}
