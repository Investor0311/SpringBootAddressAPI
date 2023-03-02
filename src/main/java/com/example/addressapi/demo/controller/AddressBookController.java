/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.addressapi.demo.controller;

import com.example.addressapi.demo.model.AddressBookModel;
import com.example.addressapi.demo.services.AddressBookInterface;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yash
 */

@RestController
@CrossOrigin("*")
public class AddressBookController {
    
    @Autowired
    AddressBookInterface addressbook; ///< Injecting dependency of AddressBookInterface
    
    
    /**
     * @brief This API is taking input as a Object from React JS(Front-end) and passing required information to service for adding user to the database.Response is sent back to front-end
     * @param userdetails of type Object
     * @return String
     */
    
    @PostMapping("/register")
    public String storeUser(@RequestBody Object userdetails)
    {
        LinkedHashMap userdetailsmap=(LinkedHashMap) userdetails;
        String fname=(String) userdetailsmap.get("fname");
        String lname=(String) userdetailsmap.get("lname");
        String mobile=(String) userdetailsmap.get("mobile");
        String address=(String) userdetailsmap.get("address");
        String password=(String) userdetailsmap.get("password");
        String username=(String) userdetailsmap.get("username");
        return this.addressbook.storeUser(fname,lname,mobile,address,password,username);
    }
    
    
     /**
     * @brief This API is taking input as a Object from React JS(Front-end) and passing required information to service for authenticating user with database stored credentials.Response is sent back to front-end
     * @param userauth of type Object
     * @return String
     */
    @PostMapping("/auth")
    public String authUser(@RequestBody Object userauth)
    {
        LinkedHashMap userdetailsmap=(LinkedHashMap) userauth;
        String username=(String)userdetailsmap.get("username");
        String pass=(String) userdetailsmap.get("password");
        return this.addressbook.checkUser(username,pass);
    }
    
    
    /**
     * @brief This API is taking input as a Object from React JS(Front-end) and passing username to service for retrieving user profile in a List to show in front-end.
     * @param username of type String
     * @return List<AddressBookModel>
     */
    @PostMapping("/home")
    public List<AddressBookModel> getDetails(@RequestBody String username)
    {
       String user[]=username.split("=");
        return this.addressbook.showDetails(user[0]);
    }
    
    
    /**
     * @brief This API is taking input as a Object from React JS(Front-end) and passing updated information to service for updating user profile in a database
     * @param userdetails of type Object
     * @return String
     */
    @PostMapping("/update")
    public String updateDetails(@RequestBody Object userdetails)
    {
        ArrayList userdetailslist=(ArrayList) userdetails;
        LinkedHashMap<String,String> userdetailsmap=(LinkedHashMap<String,String>) userdetailslist.get(0);
        String fname=(String) userdetailsmap.get("fname");
        String lname=(String) userdetailsmap.get("lname");
        String mobile=(String) userdetailsmap.get("mobile");
        String address=(String) userdetailsmap.get("address");
        String password=(String) userdetailsmap.get("password");
        return this.addressbook.updateDetails(fname,lname,mobile,address,password, (String) userdetailslist.get(1));
    }
    
    
    /**
     * @brief This API is taking input as a Object from React JS(Front-end) and passing username to service for delete user profile from the database
     * @param username of type String
     * @return String
     */
    @PostMapping("/delete")
    public String deleteDetails(@RequestBody String username)
    {
       String user[]=username.split("=");
        return this.addressbook.deleteDetails(user[0]);
    }
    
    
      /**
     * @brief This API is responsible for authentication token check coming from front-end. If token is valid then it enters application return success 
     * @return String
     */
    
//    @GetMapping("/basicauth")
//    public String basicAuth()
//    {
//        return "Success";
//    }
    
    
}

