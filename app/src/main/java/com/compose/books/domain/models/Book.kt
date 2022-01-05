package com.compose.books.domain.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField

data class Book(
    val amazon_product_url: String?,
    val author: String?,
    val book_image: String?,
    val book_uri: String?,
    val contributor: String?,
    val contributor_note: String?,
    val description: String?,
    val price: String?,
    val publisher: String?,
    val title: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(amazon_product_url)
        parcel.writeString(author)
        parcel.writeString(book_image)
        parcel.writeString(book_uri)
        parcel.writeString(contributor)
        parcel.writeString(contributor_note)
        parcel.writeString(description)
        parcel.writeString(price)
        parcel.writeString(publisher)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}