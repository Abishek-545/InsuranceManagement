package com.example.demo.ProjectionModel;


public interface ClaimHistory {
    int  getCustomer_id();
    String getCustomer_name();
    int getCustomer_age();

    int getPolicy_number();

    String getPolicy_name();

    int getPolicy_premium();

    int getClaim_id();

    String getClaim_description();

    int getAmount();


}
