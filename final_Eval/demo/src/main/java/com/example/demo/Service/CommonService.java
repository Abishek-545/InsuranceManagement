package com.example.demo.Service;

//import com.example.demo.Controller.Policy_Controller;
import com.example.demo.Model.ClaimDetails;
import com.example.demo.Model.CustomerDetails;
import com.example.demo.Model.Fine;
import com.example.demo.Model.PolicyDetails;
import com.example.demo.ProjectionModel.ClaimHistory;
import com.example.demo.ProjectionModel.PremiumReport;
import com.example.demo.Repository.ClaimRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommonService {
    @Autowired
    PolicyRepository policyRepository;


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ClaimRepository claimRepository;


    //create Customer
    public List<CustomerDetails> Create_Customer(List<CustomerDetails> c){
       return customerRepository.saveAll(c);
    }

    //read customer
    public List<CustomerDetails> get_Customer(){
            return customerRepository.findAll();
        }
 //Upadte Customer
    public CustomerDetails update_Customer(int id, CustomerDetails p){
        CustomerDetails oldata = null;
        if (customerRepository.findById(id).isPresent()) {
            oldata = customerRepository.findById(id).get();
            oldata.setCustomer_name(p.getCustomer_name());
            oldata.setCustomer_age(p.getCustomer_age());
            oldata.setCustomer_address(p.getCustomer_address());
            oldata.setCustomer_gender(p.getCustomer_gender());
            oldata.setCustomer_martialstatus(p.getCustomer_martialstatus());
            oldata.setCustomer_occupation(p.getCustomer_occupation());
        }
        return customerRepository.save(oldata);
    }

    //delete customer
    public String delete_Customer(int id){
        customerRepository.deleteById(id);
        return "Succesfully customer deleted";
    }















    //create policy
    public void Create_Policy(List<PolicyDetails> p){
        policyRepository.saveAll(p);
    }



    //read policy
    public List<PolicyDetails> get_Policy(){
            return policyRepository.findAll();
    }

    //update policy
    public PolicyDetails update_Policy(int id, PolicyDetails p) {
        PolicyDetails oldata = null;
        if (policyRepository.findById(id).isPresent()) {
            oldata = policyRepository.findById(id).get();
            oldata.setPolicy_name(p.getPolicy_name());
//            oldata.setPolicy_number(p.getPolicy_number());
            oldata.setPolicy_premium(p.getPolicy_premium());
//            oldata.setPolicy_status(p.getPolicy_status());
            oldata.setPolicy_type(p.getPolicy_type());
            oldata.setPolicy_start_date(p.getPolicy_start_date());
//            oldata.setPolicy_end_date(p.getPolicy_end_date());
        }
        return policyRepository.save(oldata);
    }
    //delete policy
    public String delete_Policy(int id){
        policyRepository.deleteById(id);
        return "Succesfully policy deleted";
    }


    public List<ClaimDetails> Create_Claim(List<ClaimDetails> c) {
        return claimRepository.saveAll(c);
    }
    public ClaimDetails get_Claim(int id) {
            return claimRepository.findById(id).orElse(null);
    }
    public ClaimDetails update_Claim(int id, ClaimDetails p) {
       ClaimDetails oldata = null;
        if (claimRepository.findById(id).isPresent()) {
            oldata = claimRepository.findById(id).get();
            oldata.setClaim_date(p.getClaim_date());
            oldata.setClaim_description(p.getClaim_description());
            oldata.setAmount(p.getAmount());
        }
        return claimRepository.save(oldata);
    }

    public String delete_Claim(int id) {
        claimRepository.deleteById(id);
        return "Succesfully claim deleted";
    }


    public PolicyDetails search_Name(String name) {
        List<CustomerDetails> customerDetails = customerRepository.findAll();
        List<PolicyDetails> policyDetails = policyRepository.findAll();
        int id;
            for (CustomerDetails customerDetail : customerDetails) {
                if (customerDetail.getCustomer_name().equalsIgnoreCase(name)) {
                    id = customerDetail.getCustomer_id();
                    for(PolicyDetails policyDetail : policyDetails) {
                        if(policyDetail.getCustomer().getCustomer_id() == id) {
                            return  policyDetail;
                        }
                    }
                }
            }
            return  null;
        }


    public PolicyDetails search_Type(String type) {
        List<PolicyDetails> policyDetails = policyRepository.findAll();
        for(PolicyDetails policyDetail : policyDetails) {
            if(policyDetail.getPolicy_type() .equalsIgnoreCase(type)) {
                return  policyDetail;
            }
        }
        return null;
    }

    public PolicyDetails search_Number(int number) {
        List<PolicyDetails> policyDetails = policyRepository.findAll();
        for(PolicyDetails policyDetail : policyDetails) {
            if(policyDetail.getPolicy_number() == number) {
                return  policyDetail;
            }
        }
        return null;
    }

    public  List<PolicyDetails> policy_status_report() {
        List<PolicyDetails> p1 = new ArrayList<>();
       List<PolicyDetails> policyDetails = policyRepository.findAll();
       for(PolicyDetails policyDetails1 : policyDetails){
           PolicyDetails p =  policyDetails1;
           Date date1 = p.getPolicy_end_date();
           Date date2 = new Date();
           long millisecondsDifference = date1.getTime() - date2.getTime();
           long years = millisecondsDifference / (1000L * 60 * 60 * 24 * 365);
           if(years > 0)
               p.setPolicy_status("Active");
           else if (years < 0)
               p.setPolicy_status("Expired");
           else
               p.setPolicy_status("Pending");
           p1.add(p);
       }
        return  p1 ;

    }

    public List<PremiumReport> policy_premium_report() {
       return  policyRepository.premiumReprt();
    }

    public List<ClaimDetails> claimHistory() {
            return claimRepository.claimhistory();
        }

    public List<Fine> fineamt() {
        return claimRepository.details();
    }
}
