package com.victormotogna.favereads.injection

import com.victormotogna.favereads.dal.api.BooksApi
import com.victormotogna.favereads.dal.local.RealmManager
import com.victormotogna.favereads.viewmodels.BooksViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {

    private val realmModule: Module = applicationContext {
        bean { RealmManager() }
    }

    private val viewModelModule: Module = applicationContext {
        viewModel { BooksViewModel() }
    }

    private val retrofitModule: Module = applicationContext {
        bean {
            Retrofit.Builder()
                    .baseUrl("https://5b687512629e280014570d37.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(BooksApi::class.java)
        }

        bean { BooksApi::class }
    }

    val modules = listOf(retrofitModule, viewModelModule, realmModule)
}