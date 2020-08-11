package ev.aykhan.hiltapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ev.aykhan.hiltapp.room.AppDatabase
import ev.aykhan.hiltapp.room.TodosDao
import ev.aykhan.hiltapp.room.getDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object LocalDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = getDatabase(context)

    @Singleton
    @Provides
    fun provideTodosDao(database: AppDatabase): TodosDao = database.todosDao

}