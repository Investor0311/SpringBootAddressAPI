/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.addressapi.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * This is a bean Class declared for AddressAPI and is imported with JPA. All attributes are linked directly to the database
 * @author Yash
 * 
 */
@Entity
public class AddressBookModel {
    
    @Id
    private String username; ///< This is primary key for database
    
    private String firstname;
    private String lastname;
    private String phones;
    private String addresses;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    

    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "AddressBookModel{" + "username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", phones=" + phones + ", addresses=" + addresses + ", password=" + password + '}';
    }

   
   
    
}
