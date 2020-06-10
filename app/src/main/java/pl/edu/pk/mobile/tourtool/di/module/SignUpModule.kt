package pl.edu.pk.mobile.tourtool.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import pl.edu.pk.mobile.tourtool.di.ViewModelBuilder
import pl.edu.pk.mobile.tourtool.di.ViewModelKey
import pl.edu.pk.mobile.tourtool.fragment.signup.SignUpFragment
import pl.edu.pk.mobile.tourtool.fragment.signup.SignUpViewModel

@Module
abstract class SignUpModule {
  @ContributesAndroidInjector(
    modules = [
      ViewModelBuilder::class
    ]
  )
  internal abstract fun signUpFragment(): SignUpFragment

  @Binds
  @IntoMap
  @ViewModelKey(SignUpViewModel::class)
  abstract fun bindViewModel(viewmodel: SignUpViewModel): ViewModel
}
