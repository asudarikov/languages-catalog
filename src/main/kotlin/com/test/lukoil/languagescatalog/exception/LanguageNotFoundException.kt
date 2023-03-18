package com.test.lukoil.languagescatalog.exception

import org.springframework.http.HttpStatus

class LanguageNotFoundException(name: String) : BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = "LANGUAGE_NOT_FOUND",
        errorMessage = "Language with name=$name not found"
    )
)