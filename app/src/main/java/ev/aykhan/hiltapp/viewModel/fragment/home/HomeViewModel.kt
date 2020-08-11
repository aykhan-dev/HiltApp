package ev.aykhan.hiltapp.viewModel.fragment.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import ev.aykhan.hiltapp.repository.TodosRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(
    private val repository: TodosRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    val listOfTodos = repository.listOfTodos

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun fetchTodos() {
        viewModelScope.launch {
            repository.fetchTodos()
        }
    }

}