package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookAppDto;
import com.example.addressbookapp.model.AddressBookApp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@Service
public class AddressBookAppService implements IAddressBookAppService {

    private final List<AddressBookApp> addressBookList = new ArrayList<>();
    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<AddressBookApp> getAllContacts() {
        return addressBookList;
    }

    @Override
    public AddressBookApp getContactById(int contactId) {
        return addressBookList.get(contactId - 1);
    }

    @Override
    public AddressBookApp addContact(AddressBookAppDto addressBookAppDto) {
        AddressBookApp addressBookApp = null;
        addressBookApp = new AddressBookApp(addressBookList.size() + 1, addressBookAppDto);
        addressBookList.add(addressBookApp);
        return addressBookApp;
    }

    @Override
    public AddressBookApp updateContact(int contactId, AddressBookAppDto addressBookAppDto) {
        AddressBookApp addressBookApp = this.getContactById(contactId);
        modelMapper.map(addressBookAppDto, addressBookApp);
        addressBookList.set(contactId - 1, addressBookApp);
        return addressBookApp;
    }

    @Override
    public void deleteContact(int contactId) {
        addressBookList.remove(contactId - 1);
    }
}


