package com.example.addressbookapp.configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author - Ramkrishna Sheral
 * @version - 0.0.1
 * @since - 13/10/2021
 */
@Configuration
public class AddressBookConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
