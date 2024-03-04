package com.example.demo.Repository;

import com.example.demo.Model.PolicyDetails;
import com.example.demo.ProjectionModel.PremiumReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyDetails,Integer> {

    @Query("SELECT p.Policy_number AS policy_number, p.Policy_name AS policy_name, p.Policy_type AS policy_type, p.Policy_status AS policy_status, p.Policy_premium AS policy_premium FROM PolicyDetails p")
    List<PremiumReport> premiumReprt();



}

