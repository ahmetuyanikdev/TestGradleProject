package com.project.exception

import org.springframework.http.HttpStatus

class BadRequestException extends GeneralException {

    BadRequestException(String message){
        super(message)
        httpStatus = HttpStatus.BAD_REQUEST.value()
    }

}
