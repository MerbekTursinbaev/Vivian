package com.example.instagram.retrofit.ui.categories.catalog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.data.ApiInterface
import com.example.instagram.data.json.catagory.Category
import com.example.instagram.data.resource.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CategoryViewModel(private val api: ApiInterface) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val getCategory: MutableLiveData<Resource<List<Category>>> = MutableLiveData()

    fun getCategory() {
        getCategory.value = Resource.loading()
        compositeDisposable.add(
            api.getCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                          getCategory.value = Resource.success(it.payload)
                },
                    {
                        getCategory.value = Resource.error(it.localizedMessage)
                    })
        )
    }
}