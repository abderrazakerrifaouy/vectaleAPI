package com.example.vectaleAPI.Entity

import jakarta.persistence.*

// PackMonths.kt
@Entity
data class PackMonths(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "PACK_CODE", referencedColumnName = "CODE", nullable = false)
    val pack: Pack,

    @Column(name = "MONTH_NUMBER", nullable = false)
    val monthNumber: Int,

    @Column(name = "YEAR_NUMBER", nullable = false)
    val yearNumber: Int,

    @Column(name = "IS_PAID", nullable = false)
    val isPaid: Boolean
)
