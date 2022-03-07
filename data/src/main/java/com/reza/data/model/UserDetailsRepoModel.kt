package com.reza.data.model

data class UserDetailsRepoModel(
    val avatar_url: String,
    val bio: String?,
    val blog: String?,
    val company: String?,
    val email: String?,
    val followers: Int,
    val following: Int,
    val id: Int,
    val location: String?,
    val login: String,
    val name: String?,
    val public_repos: Int
)