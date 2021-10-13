package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressBookAppDto;
import lombok.Data;

/**
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@Data
public class AddressBookApp {
    private int id;
    private String name;
    private String city;
    private String pincode;

    public AddressBookApp(int id, AddressBookAppDto addressBookAppDto) {
        this.id = id;
        this.name = addressBookAppDto.getName();
        this.city = addressBookAppDto.getCity();
        this.pincode = addressBookAppDto.getPincode();
    }
}
