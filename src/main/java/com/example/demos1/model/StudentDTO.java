package com.example.demos1.model;
public class StudentDTO {
	  
    private String emailAddress;
    private String name;
    private String purchasedPackage;
  
    public StudentDTO() {}
    public StudentDTO(String name, String emailAddress, String purchasedPackage) {
	      this.name = name;
	      this.emailAddress = emailAddress;
	      this.purchasedPackage = purchasedPackage;
	   }
  
    public String getEmailAddress() {
        return emailAddress;
    }
  
    public String getName() {
        return name;
    }
  
    public String getPurchasedPackage() {
        return purchasedPackage;
    }
  
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public void setPurchasedPackage(String purchasedPackage) {
        this.purchasedPackage = purchasedPackage;
    }
}