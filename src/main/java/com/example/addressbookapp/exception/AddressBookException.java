package com.example.addressbookapp.exception;

import com.example.addressbookapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AddressBookException {
@ExceptionHandler(MethodArgumentNotValidException.class)
public final ResponseEntity<ResponseDto> handleUserNotValidException(MethodArgumentNotValidException exception) {

    List<String> details = new ArrayList<>();
    for (ObjectError error : exception.getBindingResult().getAllErrors()) {
        details.add(error.getDefaultMessage());
    }
    ResponseDto responseDto = new ResponseDto("Validation Failed", details);
    return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
}
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDto> handleEmployeeException(CustomException exception){
        ResponseDto responseDto = new ResponseDto("id not found",exception.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }


}


