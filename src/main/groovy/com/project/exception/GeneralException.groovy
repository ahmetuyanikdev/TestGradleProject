package com.project.exception


class GeneralException extends RuntimeException{

    int httpStatus;

    GeneralException(String message){super(message) }
}
