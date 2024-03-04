package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ClaimDetails {

    @Id
    @Column(nullable = false)
    private int Claim_id;
    @OneToOne
    @JoinColumn(name = "Policy_number", referencedColumnName = "Policy_number")
    private PolicyDetails policyDetails;

    @Temporal(TemporalType.DATE)
    private Date Claim_date;

    private String Claim_description;
    @Column(nullable = false)
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getClaim_id() {
        return Claim_id;
    }

    public void setClaim_id(int claim_id) {
        Claim_id = claim_id;
    }

    public PolicyDetails getPolicyDetails() {
        return policyDetails;
    }

    public void setPolicyDetails(PolicyDetails policyDetails) {
        this.policyDetails = policyDetails;
    }

    public Date getClaim_date() {
        return Claim_date;
    }

    public void setClaim_date(Date claim_date) {
        Claim_date = claim_date;
    }

    public String getClaim_description() {
        return Claim_description;
    }

    public void setClaim_description(String claim_description) {
        Claim_description = claim_description;
    }


}
