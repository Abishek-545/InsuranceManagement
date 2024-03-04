package com.example.demo.Controller;

import com.example.demo.Model.ClaimDetails;
import com.example.demo.Model.CustomerDetails;
import com.example.demo.Model.Fine;
import com.example.demo.Model.PolicyDetails;
//import com.example.demo.Model.premiumRepor;
import com.example.demo.ProjectionModel.ClaimHistory;
import com.example.demo.ProjectionModel.PremiumReport;
import com.example.demo.Service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/policy")
public class CommonController {
    @Autowired
    CommonService policyService;


    //customer crud operation
    @PostMapping("/addCustomerList")
    public List<CustomerDetails> addCustomerDetails(@RequestBody List<CustomerDetails> c){
        return policyService.Create_Customer(c);
    }

    @PostMapping("/getAllCustomer")
    public List<CustomerDetails> getCustomerDetails(){
        return policyService.get_Customer();
    }

    @GetMapping("/updateCustomer/{id}")
    public CustomerDetails updatePolicyDetails(@PathVariable int id, @RequestBody CustomerDetails p){
        return policyService.update_Customer(id,p);
    }

    @PostMapping("/deletecustomer/{id}")
    public String deleteCustomerDetails(@PathVariable int id){
        return policyService.delete_Customer(id);
    }










    @PostMapping("/addpolicy")
    public String addPolicyDetails(@RequestBody List<PolicyDetails> p){
        policyService.Create_Policy(p);
        return "Successfuly Added";
    }



    @GetMapping("/getpolicy")
    public List<PolicyDetails> getPolicyDetails(){
        return policyService.get_Policy();
    }

    @GetMapping("/updatepolicy/{id}")
    public PolicyDetails updatePolicyDetails(@PathVariable int id, @RequestBody PolicyDetails p){
        return policyService.update_Policy(id,p);
    }

    @PostMapping("/deletepolicy/{id}")
    public String deletePolicydetails(@PathVariable int id){
        return policyService.delete_Policy(id);
    }







    @PostMapping("/addclaim")
    public List<ClaimDetails> addClaimDetails(@RequestBody List<ClaimDetails> c){
        return policyService.Create_Claim(c);
    }

    @PostMapping("/getclaim/{id}")
    public ClaimDetails getClaimDetails(@PathVariable int id ){
        return policyService.get_Claim(id);
    }

    @GetMapping("/updatecclaim/{id}")
    public ClaimDetails updateClaimDetails(@PathVariable int id, @RequestBody ClaimDetails p){
        return policyService.update_Claim(id,p);
    }

    @PostMapping("/deleteclaim/{id}")
    public String deleteClaimDetails(@PathVariable int id){
        return policyService.delete_Claim(id);
    }


    @PostMapping("/searchbyname/{name}")
    public PolicyDetails searcByName(@PathVariable String name){
        return policyService.search_Name(name);
    }

    @PostMapping("/searchbypolicytype/{type}")
    public PolicyDetails searcByType(@PathVariable String type){
        return policyService.search_Type(type);
    }

    @PostMapping("/searchbypolicytypenumber/{number}")
    public PolicyDetails searcByNumber(@PathVariable int number){
        return policyService.search_Number(number);
    }

//    @GetMapping("/policystatus")
//    public List<E> policyStatusReport(){
//        return policyService.policy_status_report();
//    }



@GetMapping("/policystatus")
public  List<PolicyDetails> policyStatusReport(){
    return policyService.policy_status_report();
}

    @GetMapping("/policypremium")
    public  List<PremiumReport> policyPremiumReport(){
        return policyService.policy_premium_report();
    }

    @GetMapping("/claimhistory")
    public  List<ClaimDetails> policyClaimReport(){
        return policyService.claimHistory();
    }


    @GetMapping("/fineamount")
    public  List<Fine> fine(){
        return policyService.fineamt();
    }

}
