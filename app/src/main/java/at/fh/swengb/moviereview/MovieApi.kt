package at.fh.swengb.moviereview

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

object MovieApi {
        const val accessToken = "99f7c8ed-7c27-443d-8740-aaa899bedb1e"
        val retrofit: Retrofit
        val retrofitService: MovieApiService
        init {
            val moshi = Moshi.Builder().build()
            retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl("https://movies.bloder.xyz")
                .build()
            retrofitService = retrofit.create(MovieApiService::class.java)
        }
    }
    interface MovieApiService {
        @GET("/${MovieApi.accessToken}/movies")
        fun movies(): Call<List<Movie>>

        @GET("/${MovieApi.accessToken}/movies/{id}")
        fun movieById(@Path("id") movieId: String) :Call<MovieDetail>

        @POST("/${MovieApi.accessToken}/movies/{id}/rate")
        fun rateMovie(@Path("id") movieId: String, @Body rating: Review): Call<Unit>
    }