package com.reza.remote.mapper

import com.reza.data.model.ItemRepoModel
import com.reza.data.model.UserSearchRepoModel
import com.reza.remote.model.ItemResponse
import com.reza.remote.model.UserSearchResponse
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mapstruct.factory.Mappers
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchRemoteMapperImplTest() {

    private lateinit var mapperImpl: SearchRemoteMapper

    private lateinit var given: UserSearchResponse
    private lateinit var expected: UserSearchRepoModel

    @Before
    fun setUp() {
        mapperImpl = Mappers.getMapper(SearchRemoteMapper::class.java)

        given = UserSearchResponse(
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

        expected = UserSearchRepoModel(
            false,
            listOf(
                ItemRepoModel(
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
                ItemRepoModel(
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

    }

    @Test
    fun toSearchRepositoryModels() {
        // When
        val actualValue = mapperImpl.toSearchRepositoryModels(given)

        // Then
        assertEquals(expected, actualValue)
    }
}