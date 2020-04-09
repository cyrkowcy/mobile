package pl.edu.pk.mobile.tourtool.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.Dispatchers
import pl.edu.pk.mobile.tourtool.data.MockUserRepository
import pl.edu.pk.mobile.tourtool.repositories.UserRepository

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {
  @JvmStatic
  @Singleton
  @Provides
  fun provideIoDispatcher() = Dispatchers.IO

  @JvmStatic
  @Singleton
  @Provides
  fun provideUserRepository(): UserRepository =
    MockUserRepository
}

@Module
abstract class ApplicationModuleBinds
