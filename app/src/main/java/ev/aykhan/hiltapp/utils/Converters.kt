package ev.aykhan.hiltapp.utils

import ev.aykhan.hiltapp.model.entity.Todo
import ev.aykhan.hiltapp.model.pojo.TodoPOJO

fun List<TodoPOJO>.asTodoEntityObject(): List<Todo> = map {
    Todo(it.id, it.userId, it.title, it.completed)
}