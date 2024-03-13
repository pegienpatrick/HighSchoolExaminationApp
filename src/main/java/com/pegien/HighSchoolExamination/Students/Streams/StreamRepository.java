package com.pegien.HighSchoolExamination.Students.Streams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface StreamRepository extends JpaRepository<Stream,Long> {

//    @Query("select ")
//    List<String> findAllGroupByName();

   default List<String> getStreams()
    {
        return Arrays.asList("A", "B", "C");
    }

}
