package com.example.model

data class PanData(
    val name: String,
    val email: String,
    val phone: String,
    val gender: String,
    val pan: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val dateOfBirth: String,
    val maskedAadhaarNumber: String,
    val address: Address,
    val aadhaarLinked: Boolean
)