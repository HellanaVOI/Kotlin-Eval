package be.technifuture.exo2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Item(val name: String, val quantity: Int, val type: TypeItem): Parcelable