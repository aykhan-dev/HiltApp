package ev.aykhan.hiltapp.model.pojo

import com.squareup.moshi.Json

data class TodoPOJO(
    @Json(name = "completed") val completed: Boolean,
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "userId") val userId: Int
)