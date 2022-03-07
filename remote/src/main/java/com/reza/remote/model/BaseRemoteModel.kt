package com.reza.remote.model

import com.google.gson.annotations.SerializedName

open class BaseRemoteModel(
    @SerializedName("message")
    val errorMessage: String? = null
)