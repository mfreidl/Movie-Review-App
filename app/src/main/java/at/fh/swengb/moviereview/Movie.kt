package at.fh.swengb.moviereview

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class Movie(
    val id :String,
    val title : String,
    val release : String,
    val posterImagePath : String,
    val backdropImagePath :String,
    var reviews : MutableList<Review>
) {
    fun ratingAverage() : Double{
        var average = reviews.map { it.reviewValue }.average()

        if (average.isNaN()) {
            average = 0.0
        }
        return average
    }
}


