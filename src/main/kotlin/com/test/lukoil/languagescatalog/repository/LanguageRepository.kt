package com.test.lukoil.languagescatalog.repository

import com.test.lukoil.languagescatalog.entity.LanguageEntity
import org.springframework.data.repository.CrudRepository

interface LanguageRepository : CrudRepository<LanguageEntity, String>