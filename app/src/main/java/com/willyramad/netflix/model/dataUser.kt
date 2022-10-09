package com.willyramad.netflix.model

import java.io.Serializable

data class dataUser(
    val username : String,
    val Password : String,
    val emial : String,
    val nama : String
) : Serializable
