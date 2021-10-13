package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.dto.ResponseDto;
import com.example.addressbookapp.model.AddressBookApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Performed Various https by Get,
 *
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookAppController {

        @GetMapping(value = "/get")
        public ResponseEntity<ResponseDto> getAllContacts() {
            AddressBookApp addressBook = null;
            addressBook = new AddressBookApp(1, new AddressBookAppDto("ram", "Solapur", "413002"));
            ResponseDto responseDto = new ResponseDto("Get Call Success", addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @GetMapping(value = "/get/{contactId}")
        public ResponseEntity<ResponseDto> getContactById(@PathVariable(value = "contactId") int contactId) {
            AddressBookApp addressBook = null;
            addressBook = new AddressBookApp(1, new AddressBookAppDto("ram", "Solapur", "413002"));
            ResponseDto responseDto = new ResponseDto("Get Call Success For Id", addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @PostMapping(value = "/addcontact")
        public ResponseEntity<ResponseDto> addContact(@RequestBody AddressBookAppDto addressBookDto) {
            AddressBookApp addressBook = null;
            addressBook = new AddressBookApp(1, addressBookDto);
            ResponseDto responseDto = new ResponseDto("Added Address ", addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @PutMapping("/update/{contactId}")
        public ResponseEntity<ResponseDto> updateContact(@PathVariable(value = "contactId") int contactId, @RequestBody AddressBookAppDto addressBookDto) {
            AddressBookApp addressBook = null;
            addressBook = new AddressBookApp(contactId, addressBookDto);
            ResponseDto responseDto = new ResponseDto("updated Address " + contactId, addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{contactId}")
        public ResponseEntity<ResponseDto> deleteContact(@PathVariable(value = "contactId") int contactId) {
            ResponseDto responseDto = new ResponseDto("Deleted Successfully ", "deleted Address Id " + contactId);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }
    }
