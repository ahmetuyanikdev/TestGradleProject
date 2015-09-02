package com.project.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    void handleError(HttpServletResponse response , GeneralException gEx) throws IOException{
        response.sendError(gEx.httpStatus,gEx.message)
    }
}
