package pl.edu.pk.mobile.tourtool

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.edu.pk.mobile.tourtool.di.DaggerApplicationComponent

class TourToolApplication : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

    return DaggerApplicationComponent.factory().create(applicationContext)
  }
}
