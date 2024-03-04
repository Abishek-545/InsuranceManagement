package com.example.demo.Repository;

import com.example.demo.Model.ClaimDetails;
import com.example.demo.Model.Fine;
import com.example.demo.ProjectionModel.ClaimHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimDetails,Integer> {

    @Query("Select c from ClaimDetails c ")
    List<ClaimDetails> claimhistory();

    @Query("select s from Fine s")
    List<Fine> details();
}
