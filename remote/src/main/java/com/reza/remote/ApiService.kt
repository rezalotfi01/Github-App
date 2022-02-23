package com.reza.remote

import com.reza.remote.model.UserDetailsResponse
import com.reza.remote.model.UserSearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/search/users")
    fun searchUser(
        @Query("q") query: String,
        @Query("page") page: Int
    ): Flow<UserSearchResponse>

    @GET("/users/{username}")
    fun getUserDetails(
        @Path("username") username: String
    ): Flow<UserDetailsResponse>


}
