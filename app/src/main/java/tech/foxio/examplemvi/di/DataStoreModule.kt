package tech.foxio.examplemvi.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.foxio.examplemvi.util.AppConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun provideDataStoreModule(@ApplicationContext context: Context): DataStore<Preferences> =
        context.dataStore
}

val Context.dataStore by preferencesDataStore(name = AppConfig.DATA_STORE_NAME)