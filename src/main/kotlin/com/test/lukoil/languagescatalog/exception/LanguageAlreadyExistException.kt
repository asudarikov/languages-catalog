package com.test.lukoil.languagescatalog.exception

import org.springframework.http.HttpStatus

class LanguageAlreadyExistException(name: String) : BaseException(
    HttpStatus.CONFLICT,
    ApiError(
        errorCode = "LANGUAGE_ALREADY_EXIST",
        errorMessage = "Language with name=$name already exist"
    )
)