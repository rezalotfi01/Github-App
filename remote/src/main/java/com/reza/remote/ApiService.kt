package com.reza.remote

import com.reza.remote.model.UserDetailsResponse
import com.reza.remote.model.UserSearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") query: String,
        @Query("page") page: Int
    ): UserSearchResponse

    @GET("/users/{username}")
    suspend fun getUserDetails(
        @Path("username") username: String
    ): UserDetailsResponse

}
