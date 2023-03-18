package com.test.lukoil.languagescatalog.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class StateDto(
    val state: String,
    val body: LanguageDto? = null
)
