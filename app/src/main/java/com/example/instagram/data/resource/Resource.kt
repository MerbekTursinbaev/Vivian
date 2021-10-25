package com.example.instagram.data.resource

open class Resource<T> constructor(
    val status: ResourceState,
    var data: T?,
    val message: String?,
) {

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(ResourceState.SUCCESS, data, null)
        }

        fun <T> error(message: String?): Resource<T> {
            return Resource(ResourceState.ERROR, null, message)
        }

        fun <T> loading(): Resource<T> {
            return Resource(ResourceState.LOADING, null, null)
        }
    }
}

enum class ResourceState {
    LOADING, SUCCESS, ERROR
}