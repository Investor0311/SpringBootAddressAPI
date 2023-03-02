/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.addressapi.demo.services;

import com.example.addressapi.demo.dao.AddressDao;
import com.example.addressapi.demo.model.AddressBookModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is implementation class for AddressBook Interface and implements all methods which are inline with the controller
 * @author Yash
 */

@Service
public class AddressBookImplmentation implements AddressBookInterface{

    @Autowired
    AddressDao addressdao; ///< Injecting dependency of AddressDao
    
    AddressBookModel addressmodel=new AddressBookModel();
    
    
    /**
     * @brief This function is taking information from API and adding user details to the database
     * @param username of type String
     * @param fname of type String
     * @param lname of type String
     * @param mobile of type String
     * @param address of type String
     * @param password of type String
     * @return String
     */
    @Override
    public String storeUser(String fname,String lname,String mobile,String address,String password,String username) {
        
        addressmodel.setFirstname(fname);
        addressmodel.setLastname(lname);
        addressmodel.setPhones(mobile);
        addressmodel.setAddresses(address);
        addressmodel.setPassword(password);
        addressmodel.setUsername(username);
        addressdao.save(addressmodel);
        return "Success";
    }

     /**
     * @brief This function is taking information from API and authenticating user and returning Success message if credentials match
     * @param user of type String
     * @param pass of type String
     * @return String
     */
    @Override
    public String checkUser(String user, String pass) {
        
        String userfromdatabase=addressdao.selectUser(pass);
        
        
        if(userfromdatabase.equals(user))
        {
            return "Success";
        }
        
        else
        {
            return "Failed";
        }
    }

    /**
     * @brief This function is taking information from API and returning back the profile of user through the database
     * @param user of type String
     * @return List<AddressBookModel>
     */
    @Override
    public List<AddressBookModel> showDetails(String user) {
        
        List<AddressBookModel> userdetailslist=addressdao.getDetailsByUser(user);
        
        if(!userdetailslist.isEmpty())
        {
            return userdetailslist;
        }
        
        else
        {
            return null;
        }
    }

    
    /**
     * @brief This function is taking information from API and updating user details to the database
     * @param username of type String
     * @param fname of type String
     * @param lname of type String
     * @param mobile of type String
     * @param address of type String
     * @param password of type String
     * @return String
     */
    @Override
    public String updateDetails(String fname, String lname, String mobile, String address, String password,String username) {
        
        Optional<AddressBookModel> userprofilefromdatabase=addressdao.getDetailsOptional(username);
        
        if(userprofilefromdatabase.isPresent())
        {
            
            AddressBookModel addressmodel=userprofilefromdatabase.get();
            addressmodel.setFirstname(fname);
            addressmodel.setLastname(lname);
            addressmodel.setPhones(mobile);
            addressmodel.setAddresses(address);
            addressmodel.setPassword(password);
            addressmodel.setUsername(username);
            
            addressdao.save(addressmodel);
            
            return "Success";
        }
        
        return null;
    }

    /**
     * @brief This function is taking information from API and deleting user details from the database
     * @param username of type String
     * @return String
     */
    @Override
    public String deleteDetails(String user) {
        
        Optional<AddressBookModel> userprofilefromdatabase=addressdao.getDetailsOptional(user);
        
        if(userprofilefromdatabase.isPresent())
        {
            AddressBookModel addressmodel=userprofilefromdatabase.get();
            addressdao.delete(addressmodel);
            return"Success";
        }
        
        else
        {
            return "Failed";
        }
        
    }
    
    
}
