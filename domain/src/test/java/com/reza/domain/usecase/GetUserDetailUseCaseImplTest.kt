@file:Suppress("DEPRECATION")
package com.reza.domain.usecase

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.whenever
import com.reza.domain.Repository
import com.reza.domain.model.UserDetailsDomainModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("EXPERIMENTAL_API_USAGE")
@RunWith(MockitoJUnitRunner::class)
class GetUserDetailUseCaseImplTest {
    private lateinit var useCase: GetUserDetailUseCase

    @Mock
    lateinit var repository: Repository
    
    @Before
    fun setUp() {
        useCase = GetUserDetailUseCaseImpl(repository)
    }

    @Test
    fun execute() {
        runBlocking {
            // Given
            val userDetailDomainModel = UserDetailsDomainModel(
                login= "saghul",
                id= 317464,
                avatar_url= "https://avatars.githubusercontent.com/u/317464?v=4",
                name= "Saúl Ibarra Corretgé",
                company= "@jitsi ",
                blog= "https://bettercallsaghul.com",
                location= "Amsterdam",
                email= null,
                bio= "Fellow Jitster",
                public_repos= 148,
                followers= 1289,
                following= 85,
            )
            val channel = ConflatedBroadcastChannel<UserDetailsDomainModel>()
            channel.trySend(userDetailDomainModel).isSuccess

            val expected = UserDetailsDomainModel(
                login= "saghul",
                id= 317464,
                avatar_url= "https://avatars.githubusercontent.com/u/317464?v=4",
                name= "Saúl Ibarra Corretgé",
                company= "@jitsi ",
                blog= "https://bettercallsaghul.com",
                location= "Amsterdam",
                email= null,
                bio= "Fellow Jitster",
                public_repos= 148,
                followers= 1289,
                following= 85,
            )

            whenever(repository.getUserDetails("saghul")).thenReturn(channel.asFlow())

            // When
            val actualValue = useCase.execute("saghul").first()

            // Then
            Mockito.verify(repository, times(1)).getUserDetails("saghul")
            assertEquals(expected, actualValue)
        }

    }
}