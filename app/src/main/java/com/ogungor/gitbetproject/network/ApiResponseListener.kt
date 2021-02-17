package com.ogungor.gitbetproject.network

interface ApiResponseListener<T> {

    fun onSuccess(model: T)

    fun onFail()

}