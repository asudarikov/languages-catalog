package com.test.lukoil.languagescatalog.service

import com.test.lukoil.languagescatalog.dto.LanguageDto
import com.test.lukoil.languagescatalog.dto.StateDto

interface LanguageService {

    fun getAll(): List<LanguageDto>

    fun getByName(name: String): LanguageDto

    fun create(dto: LanguageDto): StateDto

    fun update(name: String, dto: LanguageDto): StateDto

    fun delete(name: String): StateDto
}