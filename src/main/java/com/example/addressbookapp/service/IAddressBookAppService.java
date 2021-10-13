package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.model.AddressBookApp;

import java.util.List;

public interface IAddressBookAppService {
    List<AddressBookApp>getAllContacts();

    AddressBookApp getContactById(int contactId);

    AddressBookApp addContact(AddressBookAppDto addressBookAppDto);

    AddressBookApp updateContact(int contactId, AddressBookAppDto addressBookAppDto);

    void deleteContact(int contactId);
}
