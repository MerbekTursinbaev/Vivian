package com.example.instagram.retrofit.ui.order.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.data.ApiInterface
import com.example.instagram.data.json.catagory.Category
import com.example.instagram.data.resource.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class OrderCategoryViewModel(private val api: ApiInterface) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val getCategoryOrder: MutableLiveData<Resource<List<Category>>> = MutableLiveData()

    fun getCategory() {
        getCategoryOrder.value = Resource.loading()
        compositeDisposable.add(
            api.getCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getCategoryOrder.value = Resource.success(it.payload)
                },
                    {
                        getCategoryOrder.value = Resource.error(it.localizedMessage)
                    })
        )
    }

}