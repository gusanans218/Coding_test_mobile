package com.example.coding_test_mobile.domain

data class Resource<out T>(val status: Status, val data: T? = null, val message: String? = null) {

    companion object {
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String): Resource<T> {
            return Resource(Status.ERROR, null, msg)
        }
    }

}

enum class Status {
    SUCCESS,
    ERROR
}
