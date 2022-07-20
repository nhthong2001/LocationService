package com.example.locationservice.repository;

import com.example.locationservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "SELECT * FROM location l where l.create_by = :username", nativeQuery = true)
    List<Location> findByUsername(@Param("username") String username);
}
