package ev.aykhan.hiltapp.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import ev.aykhan.hiltapp.model.entity.Todo

@Dao
abstract class TodosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(items: List<Todo>)

    @Query("select * from todos")
    abstract fun getAll(): LiveData<List<Todo>>

    @Query("delete from todos")
    abstract suspend fun deleteAll()

    @Transaction
    open suspend fun cacheTodos(items: List<Todo>) {
        deleteAll()
        insert(items)
    }

}

@Database(
    entities = [Todo::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val todosDao: TodosDao
}

private const val DATABASE_NAME = "HiltApp.db"
private lateinit var INSTANCE: AppDatabase

fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}