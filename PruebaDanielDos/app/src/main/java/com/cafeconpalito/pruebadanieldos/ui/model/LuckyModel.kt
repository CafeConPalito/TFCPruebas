package com.cafeconpalito.pruebadanieldos.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Las dos anotacioens DrawableRes y StringRes le obliga a pasar del tipo correcto
 */
data class LuckyModel(

    @DrawableRes val image:Int,
    @StringRes val text:Int,
)
