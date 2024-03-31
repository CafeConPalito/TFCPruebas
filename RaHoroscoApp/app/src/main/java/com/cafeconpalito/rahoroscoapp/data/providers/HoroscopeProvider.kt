package com.cafeconpalito.rahoroscoapp.data.providers

import com.cafeconpalito.rahoroscoapp.domain.model.model.HoroscopeInfo
import com.cafeconpalito.rahoroscoapp.domain.model.model.HoroscopeInfo.*
import javax.inject.Inject


class HoroscopeProvider @Inject constructor(){
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