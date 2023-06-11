package com.kareem.domain

import com.kareem.domain.repositories.SearchRepository
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.SearchUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class SearchUseCaseTest {

    private val repo = mock<SearchRepository>()
    private val useCaseTest by lazy { SearchUseCase(repo) }

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun search_success_test() {
        runTest {
            whenever(repo.searForKeyword("dog"))
                .thenReturn(mutableListOf())

            val result = useCaseTest.execute(SearchUseCase.Params("dog"))
            assert(result is Resource.Success)
        }
    }

    @Test
    fun search_error_test() {
        runTest {
            whenever(repo.searForKeyword(""))
                .thenReturn(null)

            val result = useCaseTest.execute(SearchUseCase.Params(""))
            assert(result is Resource.Error)
        }
    }


}