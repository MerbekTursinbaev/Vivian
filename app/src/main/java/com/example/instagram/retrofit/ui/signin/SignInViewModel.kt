package com.example.instagram.retrofit.ui.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.data.ApiInterface
import com.example.instagram.data.ApiSignIn
import com.example.instagram.data.json.LoginResponse
import com.example.instagram.data.json.MyResponse
import com.example.instagram.data.resource.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class SignInViewModel(private val api: ApiInterface) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val getClient: MutableLiveData<Resource<MyResponse<LoginResponse>>> = MutableLiveData()

    fun signIn(user: ApiSignIn) {
        getClient.value = Resource.loading()
        compositeDisposable.add(
            api.getClient(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getClient.value = Resource.success(it)
                },
                    {
                        getClient.value = Resource.error(it.localizedMessage)
                    })
        )
    }

}