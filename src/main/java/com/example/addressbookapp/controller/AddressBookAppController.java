package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.dto.ResponseDto;
import com.example.addressbookapp.model.AddressBookApp;
import com.example.addressbookapp.service.AddressBookAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Performed Various https Request by GET,
 *
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@Slf4j
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookAppController {

    @Autowired
    AddressBookAppService adressBookService;
    /**
     * Function to perform Http Various request
     *
     * @return List of contacts from addressbook
     */

    @GetMapping(value = "/get")
        public ResponseEntity<ResponseDto> getAllContacts() {
            List<AddressBookApp> addressBook = null;
            addressBook = adressBookService.getAllContacts();
            ResponseDto responseDto = new ResponseDto("Get Call Success", addressBook);
            log.info("Received all Contacts");
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }
    /**
     * Function to perform Http Get request
     *
     * @param contactId unique identifier to find contact
     * @return contact using unique identifier
     */
        @GetMapping(value = "/get/{contactId}")
        public ResponseEntity<ResponseDto> getContactById(@PathVariable(value = "contactId") int contactId) {
            AddressBookApp addressBook = null;
            addressBook = adressBookService.getContactById(contactId);
            ResponseDto responseDto = new ResponseDto("Get Call Success For Id", addressBook);
            log.info("got the contact by id");
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

    /**
     * Function to perform Http Post request
     *
     * @param addressBookDto contact info data in the form of Json
     * @return add the contact to addressbook
     */

        @PostMapping(value = "/addcontact")
        public ResponseEntity<ResponseDto> addContact(@Valid @RequestBody AddressBookAppDto addressBookDto) {
            AddressBookApp addressBook = null;
            addressBook = adressBookService.addContact(addressBookDto);
            ResponseDto responseDto = new ResponseDto("Added Address ", addressBook);
            log.info("Add Contact is successfully");
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

    /**
     * Function to perform Http Put request
     *
     * @param contactId      unique identifier of contact
     * @param addressBookDto contact data in addressbook
     * @return update contact data by using unique id
     */

        @PutMapping("/update/{contactId}")
        public ResponseEntity<ResponseDto> updateContact(@PathVariable(value = "contactId") int contactId,@Valid @RequestBody AddressBookAppDto addressBookDto) {
            AddressBookApp addressBook = null;
            addressBook = adressBookService.updateContact(contactId, addressBookDto);
            ResponseDto responseDto = new ResponseDto("updated Address " + contactId, addressBook);
            log.info("Update Contact is Successfully");
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }
    /**
     * Function to perform Http Delete request
     *
     * @param contactId unique identifier of contact
     * @return ResponseEntity with message
     */


        @DeleteMapping("/delete/{contactId}")
        public ResponseEntity<ResponseDto> deleteContact(@PathVariable(value = "contactId") int contactId) {
            adressBookService.deleteContact(contactId);
            ResponseDto responseDto = new ResponseDto("Deleted Successfully ", "deleted Address Id " + contactId);
            log.info("Delete Contact is Successully");
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

    }
