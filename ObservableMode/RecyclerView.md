> recyclerView中的观察者

### setAdapter

RecyclerView内部有一个RecyclerViewDataObserver 成员变量，用于监听adapter的数据变化。

在setAdapter的时候，会通过Adapter#registerAdapterDataObserver将RecyclerViewDataObserver 注册到adapter的AdapterDataObservable中。

### Adapter# notifyDataChange

该方法会调用 AdapterDataObservable#notifyChanged，通过notifyChanged方法来遍历观察者，调用其onChanged方法，完成消息的通知。

RecyclerViewDataObserver#onChanged 内部主要调用requestLayout 触发新的布局。


### Adapter#notifyItemChanged

Adapter#notifyItemRangeChanged与Adapter#notifyItemChanged 都是调用 AdapterDataObservable#notifyItemRangeChanged。
最终调用RecyclerViewDataObserver#onItemRangeChanged。
