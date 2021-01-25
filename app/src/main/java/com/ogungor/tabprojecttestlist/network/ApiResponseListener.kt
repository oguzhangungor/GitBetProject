package com.ogungor.tabprojecttestlist.network

interface ApiResponseListener<T> {

    fun onSuccess(model: T)

    fun onFail()

}