package com.reza.remote.mapper

import com.reza.data.model.UserDetailsRepoModel
import com.reza.remote.model.UserDetailsResponse
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mapstruct.factory.Mappers
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailRemoteMapperImplTest() {

    private lateinit var mapperImpl: DetailRemoteMapper

    private lateinit var given: UserDetailsResponse
    private lateinit var expected: UserDetailsRepoModel


    @Before
    fun setUp() {
        mapperImpl = Mappers.getMapper(DetailRemoteMapper::class.java)
        given = UserDetailsResponse(
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

        expected = UserDetailsRepoModel(
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
    }

    @Test
    fun toDetailsRepositoryModels() {
        // When
        val actualValue = mapperImpl.toDetailsRepositoryModels(given)

        // Then
        assertEquals(expected, actualValue)
    }
}