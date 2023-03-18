package com.test.lukoil.languagescatalog.controller

import com.test.lukoil.languagescatalog.dto.LanguageDto
import com.test.lukoil.languagescatalog.dto.StateDto
import com.test.lukoil.languagescatalog.service.LanguageService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/language")
class LanguageController(
    private val languageService: LanguageService
) {

    @GetMapping
    fun getAllLanguages(): List<LanguageDto> =
        languageService.getAll()

    @GetMapping("/{name}")
    fun getLanguageByName(@PathVariable("name") name: String): LanguageDto =
        languageService.getByName(name)

    @PostMapping
    fun createLanguage(@Validated @RequestBody dto: LanguageDto): StateDto =
        languageService.create(dto)

    @PutMapping("/{name}")
    fun updateLanguageByName(@PathVariable name: String, @Validated @RequestBody dto: LanguageDto): StateDto =
        languageService.update(name, dto)

    @DeleteMapping("/{name}")
    fun deleteLanguageByName(@PathVariable name: String): StateDto =
        languageService.delete(name)
}