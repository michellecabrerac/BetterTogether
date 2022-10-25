package com.bettertogether.model

data class Historic(
    val meetingPlace: String,
    val hour: String,
    val destination : String,
    val seats : String? = "")