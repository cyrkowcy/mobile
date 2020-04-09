package pl.edu.pk.mobile.tourtool.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import pl.edu.pk.mobile.tourtool.di.ViewModelBuilder
import pl.edu.pk.mobile.tourtool.di.ViewModelKey
import pl.edu.pk.mobile.tourtool.fragments.login.LoginFragment
import pl.edu.pk.mobile.tourtool.fragments.login.LoginViewModel

@Module
abstract class LoginModule {
  @ContributesAndroidInjector(
    modules = [
      ViewModelBuilder::class
    ]
  )
  internal abstract fun loginFragment(): LoginFragment

  @Binds
  @IntoMap
  @ViewModelKey(LoginViewModel::class)
  abstract fun bindViewModel(viewmodel: LoginViewModel): ViewModel
}
