package com.example.proffera.data.remote.model

import com.example.proffera.R

data class Procurement(
    val pictureProject: Int,
    val instansiName: String,
    val projectName: String,
    val costEstimate: String,
    val description: String,
    val status: String,
    val deadlineEstimate: String,
)

val dummyProcurement = listOf(
    Procurement(
        pictureProject = R.drawable.dikti,
        instansiName = "Kemristekdikti",
        projectName = "Pembangunan Technopark",
        costEstimate = "Rp.500 Juta",
        description = "Pembangunan Sekolah di daerah Kabupaten Bogor",
        status = "Dalam Proses",
        deadlineEstimate = "6 Bulan",
    ),
)
