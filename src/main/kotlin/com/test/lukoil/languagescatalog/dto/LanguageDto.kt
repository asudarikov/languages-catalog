package com.test.lukoil.languagescatalog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.Range

@JsonInclude(JsonInclude.Include.NON_NULL)
data class LanguageDto(

    @field:Pattern(
        regexp = "^(Java|JavaScript|C#|C\\+\\+|Python)$",
        message = "Invalid name, it must be one of Java, JavaScript, C#, C++ or Python"
    )
    val name: String,

    @field:Size(max = 100, message = "Invalid length of description, it must be less or equal 100 symbols")
    val description: String? = null,

    @field:Range(min = 0, max = 5, message = "Invalid rating, it must be in range [1-5]")
    val rating: Int
)
