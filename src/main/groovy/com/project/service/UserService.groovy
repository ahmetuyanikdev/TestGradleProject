package com.project.service


import com.project.domain.User
import com.project.domain.UserWebRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.validation.Valid

@Service
@Transactional
class UserService {

    org.springframework.orm.hibernate4.HibernateTemplate hibernateTemplate

    void saveUser(User user){
        hibernateTemplate.setCheckWriteOperations(false)
        hibernateTemplate.save(user)
    }

    void updateUser(User user){
        hibernateTemplate.update(user);
    }

    User getUser(Integer userId){
        hibernateTemplate.get(User,userId)
    }

    List<User> getAllUsers(){
        (List<User>)hibernateTemplate.find("select id,fullName,age from User")
    }
}
