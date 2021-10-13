package com.example.addressbookapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *@author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 *
 * */
@Data
@Entity
public class AddressBookApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int pincode;

}
