package pl.edu.pk.mobile.tourtool.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.Dispatchers

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {
@JvmStatic
@Singleton
@Provides
  fun provideIoDispatcher() = Dispatchers.IO
    }

@Module
abstract class ApplicationModuleBinds
