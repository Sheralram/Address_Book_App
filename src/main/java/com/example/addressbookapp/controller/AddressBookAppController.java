package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.model.AddressBookApp;
import com.example.addressbookapp.service.AddressBookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * Performed Various https by Get,
 *@author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookAppController {

    public class AddressBookController {

        @GetMapping(value = "/get")
        public ResponseEntity<String> getAllContacts() {
            return new ResponseEntity<>("get call success", HttpStatus.OK);
        }

        @GetMapping(value = "/get/{contactId}")
        public ResponseEntity<String> getContactById(@PathVariable(value = "contactId") int contactId) {
            return new ResponseEntity<>("get success call for id " + contactId, HttpStatus.OK);
        }

        @PostMapping(value = "/addcontact")
        public ResponseEntity<String> addContact(@RequestBody AddressBookAppDto addressBootDto) {
            return new ResponseEntity<>("Created contact Data For " + addressBootDto, HttpStatus.OK);
        }

        @PutMapping("/update/{contactId}")
        public ResponseEntity<String> updateContact(@PathVariable(value = "contactId") int contactId,@RequestBody AddressBookAppDto addressBootDto) {
            return new ResponseEntity<>("Update contact Data For id " +contactId+ " for " + addressBootDto, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{contactId}")
        public ResponseEntity<String> deleteContact(@PathVariable(value = "contactId") int contactId) {
            return new ResponseEntity<>("Delete Call Success For Id " + contactId, HttpStatus.OK);
        }

    }
