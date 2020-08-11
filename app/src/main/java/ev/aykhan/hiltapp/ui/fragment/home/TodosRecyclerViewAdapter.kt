package ev.aykhan.hiltapp.ui.fragment.home

import androidx.recyclerview.widget.DiffUtil
import ev.aykhan.hiltapp.R
import ev.aykhan.hiltapp.model.entity.Todo
import ev.aykhan.hiltapp.utils.DataBindingRecyclerAdapter
import javax.inject.Inject

object TodoDiffer : DiffUtil.ItemCallback<Todo>() {

    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }

}

class TodosRecyclerViewAdapter @Inject constructor() :
    DataBindingRecyclerAdapter<Todo>(TodoDiffer) {

    override fun getItemViewType(position: Int): Int = R.layout.item_layout_todo

}