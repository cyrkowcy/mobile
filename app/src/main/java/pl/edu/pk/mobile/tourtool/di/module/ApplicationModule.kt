package pl.edu.pk.mobile.tourtool.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import pl.edu.pk.mobile.tourtool.service.data.MockUserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository

@Module(
  includes = [
    ApplicationModuleBinds::class
  ]
)
object ApplicationModule {
  @JvmStatic
  @Singleton
  @Provides
  fun provideIoDispatcher() = Dispatchers.IO

//  @JvmStatic
//  @Singleton
//  @Provides
//  fun provideUserRepository(userRepositoryImplementation: UserRepositoryImplementation): UserRepository =
//    userRepositoryImplementation

  @JvmStatic
  @Singleton
  @Provides
  fun provideUserRepository(mockUserRepository: MockUserRepository): UserRepository =
    mockUserRepository
}

@Module
abstract class ApplicationModuleBinds
