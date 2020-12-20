package com.ogungor.tabprojecttest.network

interface ApiResponseListener<T> {

    fun onSuccess(model: T)

    fun onFail()

}