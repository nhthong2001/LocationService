package com.example.locationservice.repository;

import com.example.locationservice.model.Comment;
import com.example.locationservice.model.Ratting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RattingRepository extends JpaRepository<Ratting, Long> {
    @Query(value = "SELECT * FROM Ratting r where r.location_id = :location_id", nativeQuery = true)
    List<Ratting> findAllByLocationID(@Param("location_id") String location_id);
    @Query(value = "SELECT * FROM Ratting r where r.location_id = :location_id and r.create_by = :create_by", nativeQuery = true)
    Optional<Ratting> findRatting(@Param("location_id") String location_id, @Param("create_by") String create_by);
}
