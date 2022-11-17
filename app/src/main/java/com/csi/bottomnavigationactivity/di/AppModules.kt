package com.csi.bottomnavigationactivity.di

import android.app.Application
import androidx.room.Room
import com.csi.bottomnavigationactivity.BuildConfig
import com.csi.bottomnavigationactivity.db.CardsDao
import com.csi.bottomnavigationactivity.db.NoteDatabase
import com.csi.bottomnavigationactivity.db.NotesDao
import com.csi.bottomnavigationactivity.network.ApiService
import com.csi.bottomnavigationactivity.network.BBService
import com.csi.bottomnavigationactivity.network.UrlProvider
import com.csi.bottomnavigationactivity.repository.BBRepository
import com.csi.bottomnavigationactivity.repository.CardRepository
import com.csi.bottomnavigationactivity.repository.IMDBRepository
import com.csi.bottomnavigationactivity.repository.NoteRepository
import com.csi.bottomnavigationactivity.ui.cards.CardsViewModel
import com.csi.bottomnavigationactivity.ui.dashboard.DashboardViewModel
import com.csi.bottomnavigationactivity.ui.home.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {
    single { NoteRepository(get()) }
    single { CardRepository(get()) }
    single { IMDBRepository(get()) }
    single { BBRepository(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { CardsViewModel(get()) }
    viewModel { DashboardViewModel(get()) }
}

val databaseModule = module {
    fun provideDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(application, NoteDatabase::class.java, "note_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideNotesDao(database: NoteDatabase): NotesDao {
        return database.notesDao
    }

    fun provideCardsDao(database: NoteDatabase): CardsDao {
        return database.cardsDao
    }

    single { provideDatabase(get()) }
    single { provideNotesDao(get()) }
    single { provideCardsDao(get()) }
}

val networkModule = module {
    single {
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        clientBuilder.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(UrlProvider.mainUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    single {
        Retrofit.Builder()
            .baseUrl(UrlProvider.base_url)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(BBService::class.java)
    }
}