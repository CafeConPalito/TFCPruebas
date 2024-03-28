package com.cafeconpalito.pruebadanieldos.data.providers

import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo.*
import javax.inject.Inject

/**
 * Provider
 * Clase que se encarga de dar la informacion necesaria
 */
class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}