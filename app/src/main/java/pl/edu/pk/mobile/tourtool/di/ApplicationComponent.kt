package pl.edu.pk.mobile.tourtool.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import pl.edu.pk.mobile.tourtool.TourToolApplication

@Singleton
@Component(
  modules = [
    ApplicationModule::class,
    AndroidSupportInjectionModule::class,
    LoginModule::class
  ]
)
interface ApplicationComponent : AndroidInjector<TourToolApplication> {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance applicationContext: Context): ApplicationComponent
  }
}
