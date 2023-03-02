/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.addressapi.demo.test;

import com.example.addressapi.demo.controller.AddressBookController;
import com.example.addressapi.demo.model.AddressBookModel;
import com.example.addressapi.demo.services.AddressBookInterface;
import jakarta.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Yash
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AddressAPITests {
    
    
    @Mock
    AddressBookInterface addressbook;
    
    @InjectMocks
    AddressBookController controller;
    
    
    /**
     * @brief This function is testing whether user is getting added in database with a Success response
     * @return void
     */
    
    @Test
    public void storeUserTestSuccess()
    {
        LinkedHashMap l=new LinkedHashMap();
        
        l.put("fname", "Yash");
        l.put("lname", "Gadgil");
        
        l.put("mobile", "041241234");
        l.put("address", "Pune");
        l.put("password", "abcd");
        l.put("username", "Investor");
        
        Mockito.when(addressbook.storeUser(any(), any(), any(), 
                any(), any(), any())
       
        ).thenReturn("Success");
        
        Assertions.assertEquals("Success", controller.storeUser(l));
        
    }
    
    /**
     * @brief This function is testing for failure response from address implemented methods
     * @return void
     */
    @Test
    public void storeUserTestFailure()
    {
        LinkedHashMap l=new LinkedHashMap();
        
        l.put("fname", "Yash");
        l.put("lname", "Gadgil");
        
        l.put("mobile", "041241234");
        l.put("address", "Pune");
        l.put("password", "abcd");
        l.put("username", "Investor");
        
        Mockito.when(addressbook.storeUser(any(), any(), any(), 
                any(), any(), any())
       
        ).thenReturn("Failure");
        
        Assertions.assertEquals("Failure", controller.storeUser(l));
        
    }
    
    /**
     * @brief This function is testing whether user is authenticated with valid credentials and with a Success response
     * @return void
     */
    
     @Test
     public void authUserTestSuccess()
     {
        LinkedHashMap l=new LinkedHashMap();
        
        l.put("username", "Investor");
        l.put("password", "abcd");
        
        
        Mockito.when(addressbook.checkUser(any(), any())
        
        ).thenReturn("Success");
        
        Assertions.assertEquals("Success", controller.authUser(l));
     }
     
     
     /**
     * @brief This function is testing whether user is authenticated with bad credentials and with a Failure response
     * @return void
     */
     
     @Test
     public void authUserTestFailureTest()
     {
        LinkedHashMap l=new LinkedHashMap();
        
        l.put("username", "Investor");
        l.put("password", "abcd");
        
        
        Mockito.when(addressbook.checkUser(any(), any())
        
        ).thenReturn("Failure");
        
        Assertions.assertEquals("Failure", controller.authUser(l));
     }
     
     
    /**
     * @brief This function is testing whether the details the implemented function is retrieving profile for user with given username
     * @return void
     */
     @Test
     public void getDetailsSuccessTest()
     {
         String username="Investor";
         List<AddressBookModel> l=new ArrayList<>();
         
         l.add(new AddressBookModel());
         Mockito.when(addressbook.showDetails(any())
        
        ).thenReturn(l);
        
        Assertions.assertEquals(1, controller.getDetails(username).size());
         
     }
     
     /**
     * @brief This function is testing whether the details the implemented function is able to update details in database with success response
     * @return void
     */
     @Test
     public void updateDetailsSuccessTest()
     {
         ArrayList l=new ArrayList();
         LinkedHashMap<String,String> m=new LinkedHashMap<>();
         m.put("fname", "Yash");
         m.put("lname", "Gadgil");
         m.put("mobile", "432423432");
         m.put("address", "Delhi");
         m.put("password", "abcd");
         l.add(m);
         l.add("Investor");
         
          Mockito.when(addressbook.updateDetails(any(),any(),any(),any(),
                  any(),any())
        
        ).thenReturn("Success");
        
        Assertions.assertEquals("Success", controller.updateDetails(l));
         
     }
     
     
     /**
     * @brief This function is testing whether the details the implemented function is not able to update details in database with null response because data is invalid
     * @return void
     */
     
     @Test
     public void noDataUpdateDetailsTest()
     {
         ArrayList l=new ArrayList();
         LinkedHashMap<String,String> m=new LinkedHashMap<>();
         m.put("fname", "Yash");
         m.put("lname", "Gadgil");
         m.put("mobile", "432423432");
         m.put("address", "Delhi");
         m.put("password", "abcd");
         l.add(m);
         l.add("Investor");
         
          Mockito.when(addressbook.updateDetails(any(),any(),any(),any(),
                  any(),any())
        
        ).thenReturn(null);
        
        Assertions.assertNull(controller.updateDetails(l));
         
     }
     
     /**
     * @brief This function is testing whether the details the implemented function is not able to delete details in database with Success response
     * @return void
     */
     
     @Test
     public void deleteDetailsTestSuccess()
     {
         String username="Investor";
         Mockito.when(addressbook.deleteDetails(any())
        
        ).thenReturn("Success");
        
        Assertions.assertEquals("Success", controller.deleteDetails(username));
         
     }
     
     
     /**
     * @brief This function is testing whether the details the implemented function is not able to delete details in database with Failed response because data is invalid
     * @return void
     */
     
     @Test
     public void deleteDetailsTestFailed()
     {
         String username="Investor";
         Mockito.when(addressbook.deleteDetails(any())
        
        ).thenReturn("Failed");
        
        Assertions.assertEquals("Failed", controller.deleteDetails(username));
         
     }
   
}
