package com.varun.demoapplication.repository

import com.apps.demo.apixuweather.repository.Repository
import com.varun.demoapplication.repository.webRepo.WebRepository
import javax.inject.Inject

data class RepositoryImpl @Inject constructor(override val webRepository: WebRepository) : Repository