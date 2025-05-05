package com.android.reelmatch

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val title: String,
    val imageResId: Int,
    val rating: Float,
    val description: String,
    val yearReleased: String,
    val director: String,
    val cast: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: arrayListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(imageResId)
        parcel.writeFloat(rating)
        parcel.writeString(description)
        parcel.writeString(yearReleased)
        parcel.writeString(director)
        parcel.writeStringList(cast)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
