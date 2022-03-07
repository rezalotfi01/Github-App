@file:Suppress("DEPRECATION")

package com.reza.domain.usecase

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.whenever
import com.reza.domain.Repository
import com.reza.domain.model.ItemDomainModel
import com.reza.domain.model.UserSearchDomainModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@Suppress("EXPERIMENTAL_API_USAGE")
@RunWith(MockitoJUnitRunner::class)
class SearchUserUseCaseImplTest {
    private lateinit var useCase: SearchUserUseCase

    @Mock
    lateinit var repository: Repository


    @Before
    fun setUp() {
        useCase = SearchUserUseCaseImpl(repository)
    }

    @Test
    fun execute() {
        runBlocking {
            // Given
            val userSearchDomainModel = UserSearchDomainModel(
                false,
                listOf(
                    ItemDomainModel(
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
                    ItemDomainModel(
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

            val channel = ConflatedBroadcastChannel<UserSearchDomainModel>()
            channel.trySend(userSearchDomainModel).isSuccess

            val expected = UserSearchDomainModel(
                false,
                listOf(
                    ItemDomainModel(
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
                    ItemDomainModel(
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

            whenever(repository.searchUser("s",1)).thenReturn(channel.asFlow())

            // When
            val actualValue = useCase.execute("s",1).first()

            // Then
            verify(repository, times(1)).searchUser("s",1)
            assertEquals(expected.items[0], actualValue.items[0])
        }
    }

}