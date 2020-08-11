package ev.aykhan.hiltapp.repository

import ev.aykhan.hiltapp.network.TodosService
import ev.aykhan.hiltapp.room.TodosDao
import ev.aykhan.hiltapp.utils.asTodoEntityObject
import javax.inject.Inject

class TodosRepository @Inject constructor(
    private val todosDao: TodosDao,
    private val service: TodosService
) {

    val listOfTodos = todosDao.getAll()

    suspend fun fetchTodos() {
        val response = service.fetchTodos()
        if (response.isSuccessful && response.code() == 200)
            response.body()?.let { todosDao.cacheTodos(it.asTodoEntityObject()) }
    }

}