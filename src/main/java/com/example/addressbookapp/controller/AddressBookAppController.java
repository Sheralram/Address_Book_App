package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.dto.ResponseDto;
import com.example.addressbookapp.model.AddressBookApp;
import com.example.addressbookapp.service.AddressBookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Performed Various https Request by GET,
 *
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookAppController {

    @Autowired
    AddressBookAppService adressBookService;


    @GetMapping(value = "/get")
        public ResponseEntity<ResponseDto> getAllContacts() {
            List<AddressBookApp> addressBook = null;
            addressBook = adressBookService.getAllContacts();
            ResponseDto responseDto = new ResponseDto("Get Call Success", addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @GetMapping(value = "/get/{contactId}")
        public ResponseEntity<ResponseDto> getContactById(@PathVariable(value = "contactId") int contactId) {
            AddressBookApp addressBook = null;
            addressBook = adressBookService.getContactById(contactId);
            ResponseDto responseDto = new ResponseDto("Get Call Success For Id", addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @PostMapping(value = "/addcontact")
        public ResponseEntity<ResponseDto> addContact(@RequestBody AddressBookAppDto addressBookDto) {
            AddressBookApp addressBook = null;
            addressBook = adressBookService.addContact(addressBookDto);
            ResponseDto responseDto = new ResponseDto("Added Address ", addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @PutMapping("/update/{contactId}")
        public ResponseEntity<ResponseDto> updateContact(@PathVariable(value = "contactId") int contactId, @RequestBody AddressBookAppDto addressBookDto) {
            AddressBookApp addressBook = null;
            addressBook = adressBookService.updateContact(contactId, addressBookDto);
            ResponseDto responseDto = new ResponseDto("updated Address " + contactId, addressBook);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{contactId}")
        public ResponseEntity<ResponseDto> deleteContact(@PathVariable(value = "contactId") int contactId) {
            adressBookService.deleteContact(contactId);
            ResponseDto responseDto = new ResponseDto("Deleted Successfully ", "deleted Address Id " + contactId);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }
    }
