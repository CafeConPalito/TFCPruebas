package com.cafeconpalito.pruebadanieldos.domain.usecase

import com.cafeconpalito.pruebadanieldos.domain.Repository
import javax.inject.Inject

class GetChicksUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() = repository.getChiksTop()

}