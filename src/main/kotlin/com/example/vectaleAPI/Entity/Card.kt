package com.example.vectaleAPI.Entity

import jakarta.persistence.*

/*
class card reoresents a table in the database
@param id the id card
 */
@Entity
@Table(name = "card")
data class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "ID_PACK", referencedColumnName = "ID", nullable = false)
    val pack: Pack,

    @Column(name = "DISPONIBLE", nullable = false)
    val disponible: Boolean
)
