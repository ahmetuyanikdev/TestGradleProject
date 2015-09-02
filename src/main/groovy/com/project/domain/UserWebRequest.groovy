package com.project.domain

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty

class UserWebRequest {
    Integer id

    String fullName

    Integer age
}
