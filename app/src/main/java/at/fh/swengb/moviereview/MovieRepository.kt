package at.fh.swengb.moviereview

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {

    fun moviesList(success: (moviesList: List<Movie>) -> Unit, error: (errorMessage: String) -> Unit) {
        MovieApi.retrofitService.movies().enqueue(object: Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                error("The call failed")
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }

        })
    }

    fun movieById(id : String, success: (movieDetail : MovieDetail) -> Unit, error: (errorMessage: String) -> Unit) {
        MovieApi.retrofitService.movieById(id).enqueue(object: Callback<MovieDetail> {
            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                error("The call failed")
            }

            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }

        })
    }
    fun rateMovie(id: String, rating: Review) {
        MovieApi.retrofitService.rateMovie(id,rating).enqueue(object : Callback<Unit>{
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                error("The call failed")
            }

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful){
                    Response.success(id)
                } else{
                    error("Something went wrong")
                }
            }
        })
    }
}