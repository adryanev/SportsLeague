package com.adryanev.sportsleague.bindings

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromRaw")
fun bindImageFromRaw(view: ImageView, name: String?){
    if(!name.isNullOrEmpty()){
        Glide.with(view.context).load(Uri.parse("android.resource://" + view.context.packageName + "/raw/" + name)).into(view)
    }

}
@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, name: String?){
    if(!name.isNullOrEmpty()){
        Glide.with(view.context).load(name).into(view)
    }
}
