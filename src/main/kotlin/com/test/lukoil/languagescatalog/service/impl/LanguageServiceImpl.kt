package com.test.lukoil.languagescatalog.service.impl

import com.test.lukoil.languagescatalog.dto.LanguageDto
import com.test.lukoil.languagescatalog.dto.StateDto
import com.test.lukoil.languagescatalog.entity.LanguageEntity
import com.test.lukoil.languagescatalog.exception.LanguageAlreadyExistException
import com.test.lukoil.languagescatalog.exception.LanguageNameCannotBeChangedException
import com.test.lukoil.languagescatalog.exception.LanguageNotFoundException
import com.test.lukoil.languagescatalog.repository.LanguageRepository
import com.test.lukoil.languagescatalog.service.LanguageService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LanguageServiceImpl(
    private val languageRepository: LanguageRepository,
) : LanguageService {

    override fun getAll(): List<LanguageDto> {
        return languageRepository.findAll()
            .map {
                it.toDto()
            }
    }

    override fun getByName(name: String): LanguageDto {
        return languageRepository.findByIdOrNull(name)
            ?.toDto()
            ?: throw LanguageNotFoundException(name)
    }

    override fun create(dto: LanguageDto): StateDto {
        if (languageRepository.findByIdOrNull(dto.name) != null) {
            throw LanguageAlreadyExistException(dto.name)
        }
        languageRepository.save(dto.toEntity())
        return StateDto("ok", dto)
    }

    override fun update(name: String, dto: LanguageDto): StateDto {
        if (!name.equals(dto.name)) {
            throw LanguageNameCannotBeChangedException(
                nameInPath = name,
                nameInBody = dto.name
            )
        }
        val prevLanguage = languageRepository.findByIdOrNull(name)
            ?: throw LanguageNotFoundException(name)

        prevLanguage.description = dto.description;
        prevLanguage.rating = dto.rating;
        languageRepository.save(prevLanguage)

        return StateDto("ok", dto)
    }

    override fun delete(name: String): StateDto {
        languageRepository.findByIdOrNull(name)
            ?: throw LanguageNotFoundException(name)

        languageRepository.deleteById(name)
        return StateDto("ok")
    }

    private fun LanguageEntity.toDto(): LanguageDto =
        LanguageDto(
            name = this.name,
            description = this.description,
            rating = this.rating
        )

    private fun LanguageDto.toEntity(): LanguageEntity =
        LanguageEntity(
            name = this.name,
            description = this.description,
            rating = this.rating
        )

}