package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.model.AddressBookApp;
import com.example.addressbookapp.service.AddressBookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Performed Various https by Get,
 *@author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@RestController
public class AddressBookAppController {
@Autowired
    AddressBookAppService addressBookAppService;

    /**
     *
     *using GetMapping returning message
     *
     */
    @GetMapping(value = "/")
    public String test(@RequestBody String message){
    return "Message:" +message;
}

    /**
     *
     *using GetMapping returning message
     *
     */
@PostMapping(value="/post")
public String test1(@RequestBody String message){
    return "Message:" +message;
}
    /**
     *
     *using PutMapping returning message
     *
     */
    @PutMapping(value = "/")
    public String test3(@RequestBody String message){
        return "Message:" +message;
    }
    /**
     *
     *using GetMapping returning message
     *
     */
    @GetMapping(value="/delete")
    public String test4(@RequestBody String message){
        return "Message:" +message;
    }




}
