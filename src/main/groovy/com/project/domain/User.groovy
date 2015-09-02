package com.project.domain

import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.stereotype.Component

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Component
@Entity
@Table(name = "user")
class User implements Serializable {
    @Id
    @GenericGenerator(name = "gen",strategy = "increment")
    @GeneratedValue(generator = "gen")
    Integer id

    @Column(name = "full_name")
    String fullName

    Integer age

    static User initializeUser(UserWebRequest userWebRequest){
        User user = new User()
        if(userWebRequest) {
            user.fullName = userWebRequest?.fullName
            user.age = userWebRequest?.age
            user.id = userWebRequest?.id
        }
        user
    }


}
