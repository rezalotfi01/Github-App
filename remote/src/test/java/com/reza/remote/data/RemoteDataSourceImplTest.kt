package com.reza.remote.data

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.whenever
import com.reza.data.RemoteDataSource
import com.reza.remote.ApiService
import com.reza.remote.model.ItemResponse
import com.reza.remote.model.UserDetailsResponse
import com.reza.remote.model.UserSearchResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDataSourceImplTest {

    private lateinit var remoteSource: RemoteDataSource

    @Mock
    lateinit var apiService: ApiService

    @Before
    fun setUp() {
        remoteSource = RemoteDataSourceImpl(
            apiService
        )
    }

    @Test
    fun searchUser() {
        runBlocking {
            // When
            whenever(apiService.searchUser("s",1)).thenReturn(
                UserSearchResponse(
                    false,
                    listOf(
                        ItemResponse(
                            login = "saghul",
                            id= 317464,
                            node_id= "MDQ6VXNlcjMxNzQ2NA==",
                            avatar_url= "https://avatars.githubusercontent.com/u/317464?v=4",
                            gravatar_id= "",
                            url= "https://api.github.com/users/saghul",
                            html_url= "https://github.com/saghul",
                            followers_url= "https://api.github.com/users/saghul/followers",
                            following_url= "https://api.github.com/users/saghul/following{/other_user}",
                            gists_url= "https://api.github.com/users/saghul/gists{/gist_id}",
                            starred_url= "https://api.github.com/users/saghul/starred{/owner}{/repo}",
                            subscriptions_url= "https://api.github.com/users/saghul/subscriptions",
                            organizations_url= "https://api.github.com/users/saghul/orgs",
                            repos_url= "https://api.github.com/users/saghul/repos",
                            events_url= "https://api.github.com/users/saghul/events{/privacy}",
                            received_events_url= "https://api.github.com/users/saghul/received_events",
                            type= "User",
                            site_admin= false,
                            score= 1
                        ),
                        ItemResponse(
                            login= "s",
                            id= 1969638,
                            node_id= "MDQ6VXNlcjE5Njk2Mzg=",
                            avatar_url= "https://avatars.githubusercontent.com/u/1969638?v=4",
                            gravatar_id= "",
                            url= "https://api.github.com/users/s",
                            html_url= "https://github.com/s",
                            followers_url= "https://api.github.com/users/s/followers",
                            following_url= "https://api.github.com/users/s/following{/other_user}",
                            gists_url= "https://api.github.com/users/s/gists{/gist_id}",
                            starred_url= "https://api.github.com/users/s/starred{/owner}{/repo}",
                            subscriptions_url= "https://api.github.com/users/s/subscriptions",
                            organizations_url= "https://api.github.com/users/s/orgs",
                            repos_url= "https://api.github.com/users/s/repos",
                            events_url= "https://api.github.com/users/s/events{/privacy}",
                            received_events_url= "https://api.github.com/users/s/received_events",
                            type= "User",
                            site_admin= false,
                            score= 1
                        )
                    ),
                    182004
                )
            )

            remoteSource.searchUser("s",1)

            // Then
            verify(apiService, times(1)).searchUser("s",1)
        }
    }

    @Test
    fun getUserDetails() {

        runBlocking {
            // When
            whenever(apiService.getUserDetails("saghul")).thenReturn(
                UserDetailsResponse(
                    login = "saghul",
                    id = 317464,
                    avatar_url = "https://avatars.githubusercontent.com/u/317464?v=4",
                    name = "Saúl Ibarra Corretgé",
                    company = "@jitsi ",
                    blog = "https://bettercallsaghul.com",
                    location = "Amsterdam",
                    email = null,
                    bio = "Fellow Jitster",
                    public_repos = 148,
                    followers = 1289,
                    following = 85,
                )
            )

            remoteSource.getUserDetails("saghul")

            // Then
            verify(apiService, times(1)).getUserDetails("saghul")
        }
    }
}