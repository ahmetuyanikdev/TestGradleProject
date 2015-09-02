package com.project.exception

import org.springframework.http.HttpStatus

class NotFoundException extends GeneralException {

    NotFoundException(String message){
        super(message)
        httpStatus = HttpStatus.NOT_FOUND.value()
    }
}
