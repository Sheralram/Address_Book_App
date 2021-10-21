package com.example.addressbookapp.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 *
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 *
* * creates and maintains AddressBook as object (DTO)
 */
@Data
@AllArgsConstructor
public class AddressBookAppDto {
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "name should contains atleast 2 characters...first letter should be caps")
    private String name;
    @NotBlank(message = "city should not be Blank")
    private String city;
    @NotNull
    @Pattern(regexp = "^[0-9]{6}$", message = "pincode should cpntains 6 digits")
    private String pincode;
}
