package com.example.auto.repository;

import com.example.auto.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository <Auto,Long> {
    List<Auto> findByColour(String colour);

    @Query("Select a from Auto a WHERE a.colour like CONCAT (:colour,'%')")
    List<Auto> findByColourName(@Param("colour")String colour);
}
