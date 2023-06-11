package com.kareem.jobzellatask

import com.kareem.domain.models.PhotoVM
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.SearchUseCase
import com.kareem.domain.useCases.UseCase
import com.kareem.jobzellatask.ui.search_screen.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
internal class SearchViewModelTest {

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private val useCase = mock<UseCase<SearchUseCase.Params, MutableList<PhotoVM>?>>()
    private val viewModel = SearchViewModel(useCase)


    @Test
    fun `test onSearch() then validate state will change to loading`() {
        runTest {
            whenever(useCase.execute(SearchUseCase.Params("dog"))).thenReturn(
                Resource.Success(
                    mutableListOf(
                        PhotoVM(
                            "1",
                            "aaa"
                        )
                    )
                )
            )
            viewModel.onSearch("dog")
            assertTrue(viewModel.imagesLoading.value)
        }
    }

    @Test
    fun `test onSearch() with success results then validate result`() {
        runTest {
            whenever(useCase.execute(SearchUseCase.Params("dog"))).thenReturn(
                Resource.Success(
                    mutableListOf(
                        PhotoVM(
                            "1",
                            "aaa"
                        )
                    )
                )
            )

            viewModel.onSearch("dog")
            advanceUntilIdle()
            assert(viewModel.images.value.isNotEmpty())
        }
    }

    @Test
    fun `test onSearch() with error results then validate result`() {
        runTest {
            whenever(useCase.execute(SearchUseCase.Params(""))).thenReturn(
                Resource.Error("wrong response")
            )

            viewModel.onSearch("")
            advanceUntilIdle()
            assert(viewModel.images.value.isEmpty())
        }
    }

}