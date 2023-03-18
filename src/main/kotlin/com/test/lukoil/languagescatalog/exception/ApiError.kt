package com.test.lukoil.languagescatalog.exception

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiError(
    var errorCode: String,
    var errorMessage: String? = null,
)
