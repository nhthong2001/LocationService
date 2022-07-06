package com.example.locationservice.repository;

import com.example.locationservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM Comment cm where cm.location_id = :location_id", nativeQuery = true)
    List<Comment> findAllByLocationId(@Param("location_id") String location_id);

    @Modifying
    @Query(value = "update Comment c set c.content = :content where c.location_id = :location_id and c.create_by = :create_by", nativeQuery = true)
    int updateComment(@Param(value = "location_id") String location_id, @Param(value = "create_by") String create_by, @Param(value = "content") String content);
   //  Executing an update/delete query; nested exception is javax.persistence.TransactionRequiredException: Executing an update/delete query] with root cause

}
