/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.addressapi.demo.dao;

import com.example.addressapi.demo.model.AddressBookModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * This is Dao interface which extends JpaRepository for performing database operations and writing custom queries 
 * @author Yash
 */
public interface AddressDao extends JpaRepository<AddressBookModel, Integer>{

  @Query(value = "SELECT username FROM ADDRESS_BOOK_MODEL WHERE password=?1", nativeQuery = true)
   String selectUser(String password);
   
   @Query(value = "SELECT * FROM ADDRESS_BOOK_MODEL WHERE username=?1", nativeQuery = true)
   List<AddressBookModel> getDetailsByUser(String firstname);
   
   @Query(value = "SELECT * FROM ADDRESS_BOOK_MODEL WHERE username=?1", nativeQuery = true)
   Optional<AddressBookModel> getDetailsOptional(String username);
   
//   @Query(value = "DELETE FROM ADDRESS_BOOK_MODEL WHERE username=?1", nativeQuery = true)
//   void deleteByUserDetail(String username);
   
   
   
   
}

