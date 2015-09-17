package com.project.controller

import com.project.domain.User
import com.project.domain.UserWebRequest
import com.project.exception.BadRequestException
import com.project.exception.NotFoundException
import com.project.service.UserService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.config.annotation.EnableWebMvc

import javax.validation.Valid

@Controller
@EnableWebMvc
@Slf4j
class UserController {

    @Autowired
    UserService userService

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    List<User> getAllUsers (){
       userService.getAllUsers()
    }

    @RequestMapping(value ='/getUser',method = RequestMethod.GET,produces = 'application/json')
    @ResponseBody
    User getUser(@RequestParam(value = 'id',required = true) Integer id){
        User user = userService.getUser(id)
        if(user){
           user

        }
        else {
            throw new NotFoundException("User is not found for the id ${id}")
        }
    }

    @RequestMapping(value = '/saveUser',method = RequestMethod.POST,consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    void saveUser(@RequestBody User user){
        userService.saveUser(user)
    }

    @RequestMapping(value = '/updateUser',method = RequestMethod.PUT,consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping(value = "/getString",method = RequestMethod.GET,produces = 'text/plain')
    @ResponseBody
    String getString(){
        'hi world'
    }
}
