package com.adryanev.sportsleague.data.models.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Liga(val id: Int, val name: String, val description: String, val image: String) :
    Parcelable