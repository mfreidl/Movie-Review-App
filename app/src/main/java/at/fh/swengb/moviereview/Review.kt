package at.fh.swengb.moviereview

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class Review(
    var reviewValue : Double,
    var reviewText: String
)