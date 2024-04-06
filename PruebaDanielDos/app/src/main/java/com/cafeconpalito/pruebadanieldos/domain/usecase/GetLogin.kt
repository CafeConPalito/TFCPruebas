package com.cafeconpalito.pruebadanieldos.domain.usecase

import com.cafeconpalito.pruebadanieldos.domain.Repository
import javax.inject.Inject

class GetLogin @Inject constructor(private val repository: Repository) {


    /**
     * llama al login
     */
    suspend operator fun invoke(user:String , password:String) = repository.getLogin(user,password)

}