package com.example.amdocsapp.network

import com.squareup.moshi.Json

data class MarsPhoto(
  val  id:String,

  @Json(name = "img_src")
  var imgSrc:String
)