package com.example.addressbookapp.service;
import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.model.AddressBookApp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *@author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 *
 * */
@Service
public class AddressBookAppService implements IAddressBookAppService {

    @Override
    public List<AddressBookApp>getAllContacts() {
        List<AddressBookApp> addressBookList = new ArrayList<>();
        addressBookList.add(new AddressBookApp(1,new AddressBookAppDto("ram","Solapur","413002")));
        return addressBookList;
    }

    @Override
    public AddressBookApp getContactById(int contactId) {
        AddressBookApp addressBook = null;
        addressBook = new AddressBookApp(1,new AddressBookAppDto("ram","Solapur","413002"));
        return addressBook;
    }

    @Override
    public AddressBookApp addContact(AddressBookAppDto addressBookAppDto){
        AddressBookApp addressBookApp = null;
        addressBookApp = new AddressBookApp(1,addressBookAppDto);
        return addressBookApp;
    }

    @Override
    public AddressBookApp updateContact(int contactId,AddressBookAppDto addressBookAppDto){
        AddressBookApp addressBookApp = null;
        addressBookApp = new AddressBookApp(contactId,addressBookAppDto);
        return addressBookApp;
    }

    @Override
    public void deleteContact(int contactId){

}
    }


