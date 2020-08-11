package ev.aykhan.hiltapp.network

import ev.aykhan.hiltapp.model.pojo.TodoPOJO
import retrofit2.Response
import retrofit2.http.GET

interface TodosService {

    @GET("todos")
    suspend fun fetchTodos(): Response<List<TodoPOJO>>

}