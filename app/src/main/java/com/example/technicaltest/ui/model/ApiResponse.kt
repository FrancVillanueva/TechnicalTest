package com.example.technicaltest.ui.model

data class ApiResponse(
    val pagination: Pagination,
    val results: List<Result>
)

data class Pagination(
    val pageSize: Int,
    val page: Int,
    val total: Int
)

data class Result(
    val _id: String,
    val date_insert: String,
    val slug: String,
    val columns: String,
    val fact: String,
    val organization: String,
    val resource: String,
    val url: String,
    val operations: String,
    val dataset: String,
    val created_at: Long
)