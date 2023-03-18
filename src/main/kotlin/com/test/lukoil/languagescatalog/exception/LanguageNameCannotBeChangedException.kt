package com.test.lukoil.languagescatalog.exception

import org.springframework.http.HttpStatus

class LanguageNameCannotBeChangedException(nameInPath: String, nameInBody: String) : BaseException(
    HttpStatus.CONFLICT,
    ApiError(
        errorCode = "LANGUAGE_NAME_CANNOT_BE_CHANGED",
        errorMessage = "Language name cannot be changed, " +
                "name in path ($nameInPath) must be equal to name in body ($nameInBody)"
    )
)