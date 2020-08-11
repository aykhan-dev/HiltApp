@file:Suppress("UNCHECKED_CAST")

package ev.aykhan.hiltapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:recyclerViewAdapter")
fun <T> RecyclerView.setDataBindingAdapter(adapter: DataBindingRecyclerAdapter<T>) {
    this.adapter = adapter
}

@BindingAdapter("app:recyclerViewListData")
fun <T> RecyclerView.setData(data: List<T>?) {
    data?.let { (this.adapter as DataBindingRecyclerAdapter<T>).submitList(it) }
}