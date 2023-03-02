/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.addressapi.demo.services;

import com.example.addressapi.demo.model.AddressBookModel;
import java.util.List;

/**
 * This is the interface which contains all the methods for implementation
 * @author Yash
 */
public interface AddressBookInterface {
    
    public String storeUser(String fname,String lname,String mobile,String address,String password,String username);
    public String checkUser(String user,String pass);
    public List<AddressBookModel> showDetails(String user);
    
    public String updateDetails(String fname,String lname,String mobile,String address,String password,String username);
    public String deleteDetails(String user);
}
