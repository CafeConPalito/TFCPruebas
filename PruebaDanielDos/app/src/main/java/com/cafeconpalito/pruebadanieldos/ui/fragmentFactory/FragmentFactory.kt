package com.cafeconpalito.pruebadanieldos.ui.fragmentFactory

import androidx.fragment.app.Fragment
import com.cafeconpalito.pruebadanieldos.domain.usecase.GetLogin
import javax.inject.Inject
import androidx.fragment.app.FragmentFactory
import com.cafeconpalito.pruebadanieldos.ui.palmistry.PalmistryFragment

class FragmentFactory @Inject constructor(
private val getLogin: GetLogin
):FragmentFactory() {

    /*
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment = when(className) {

        PalmistryFragment::class.java.name -> PalmistryFragment(getLogin)
        else -> super.instantiate(classLoader, className)
    }

    */

}

