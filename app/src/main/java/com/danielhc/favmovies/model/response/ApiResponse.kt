package com.danielhc.favmovies.model.response

data class ApiResponse<T: Any>(
    var resultCount: Int,
    var results: List<T>
)