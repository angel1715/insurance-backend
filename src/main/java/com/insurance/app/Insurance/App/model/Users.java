package com.insurance.app.Insurance.App.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String fName;
    private String lName;
    private String phone;
    private String email;
    private String password;
    private String plan;
    private String device;
    private Integer claimAllowance;
    private Integer numberOfClaim;

    public Users(Long id, String fName, String lName, String phone, String email, String password, String plan, String device, Integer claimAllowance, Integer numberOfClaim) {
        Id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.plan = plan;
        this.device = device;
        this.claimAllowance = claimAllowance;
        this.numberOfClaim = numberOfClaim;
    }

    public Users() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getClaimAllowance() {
        return claimAllowance;
    }

    public void setClaimAllowance(Integer claimAllowance) {
        this.claimAllowance = claimAllowance;
    }

    public Integer getNumberOfClaim() {
        return numberOfClaim;
    }

    public void setNumberOfClaim(Integer numberOfClaim) {
        this.numberOfClaim = numberOfClaim;
    }
}
