package com.example.vectaleAPI.Entity

import jakarta.persistence.*

// Card.kt
@Entity
data class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "ID_PACK", referencedColumnName = "ID", nullable = false)
    val pack: Pack,

    @Column(name = "DISPONIBLE", nullable = false)
    val disponible: Boolean
)
