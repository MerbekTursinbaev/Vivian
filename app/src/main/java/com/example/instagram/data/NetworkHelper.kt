package com.example.instagram.data

class NetworkHelper(/*private val apiClient: Retrofit*/) {

  /*  fun getClient(
        user: ApiSignIn,
        onResponse: (MyResponse<LoginResponse>) -> Unit,
        onFailure: (msg: String?) -> Unit,
    ) {

        val call = apiClient.create(ApiInterface::class.java).getClient(user)

        call.enqueue(
            object : Callback<MyResponse<LoginResponse>> {
                override fun onResponse(
                    call: Call<MyResponse<LoginResponse>>?,
                    response: Response<MyResponse<LoginResponse>>?,
                ) {
                    response?.body()?.let {
                        onResponse.invoke(it)
                        Log.d("juwap", it.message)
                    }
                }

                override fun onFailure(call: Call<MyResponse<LoginResponse>>?, t: Throwable?) {
                    onFailure.invoke(t?.localizedMessage)
                }
            })
    }
*/

//    fun getCategory(
//        onSuccess: (MyResponse<List<Category>>) -> Unit,
//        onFailure: (msg: String?) -> Unit,
//    ) {
//        val call = apiClient.create(ApiInterface::class.java).getCategories()
//        call.enqueue(
//            object : Callback<MyResponse<List<Category>>> {
//
//                override fun onResponse(
//                    call: Call<MyResponse<List<Category>>>?,
//                    response: Response<MyResponse<List<Category>>>?,
//                ) {
//                    response?.let {
//                        it.body()?.let { it -> onSuccess.invoke(it) }
//                    }
//                }
//
//                override fun onFailure(call: Call<MyResponse<List<Category>>>?, t: Throwable?) {
//                    onFailure.invoke(t?.localizedMessage)
//                }
//            }
//        )
//    }

}