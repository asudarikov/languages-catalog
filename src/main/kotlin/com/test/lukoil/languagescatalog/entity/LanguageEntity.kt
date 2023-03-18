package com.test.lukoil.languagescatalog.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "language")
class LanguageEntity(
    @Id
    val name: String = "",
    var description: String? = null,
    var rating: Int = 0
)