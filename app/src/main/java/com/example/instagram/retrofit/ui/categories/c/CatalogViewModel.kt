package com.example.instagram.retrofit.ui.categories.c

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.data.ApiInterface
import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.data.resource.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CatalogViewModel(private val api: ApiInterface) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val getCatalog: MutableLiveData<Resource<List<Catalog>>> = MutableLiveData()

    fun getCatalog(id: Int) {
        getCatalog.value = Resource.loading()
        compositeDisposable.add(
            api.getCatalog(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getCatalog.value = Resource.success(it.payload)
                },
                    {
                        getCatalog.value = Resource.error(it.localizedMessage)
                    })
        )
    }
}