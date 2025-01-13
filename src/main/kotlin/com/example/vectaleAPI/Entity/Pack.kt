package com.example.vectaleAPI.Entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "PACK")
data class Pack(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long = 0,

    @Column(name = "CODE", nullable = false, unique = true)
    val code: String,

    @Column(name = "ID_USER", nullable = false)
    val idUser: Long,

    @Column(name = "PACK_TYPE", nullable = false)
    val packType: String,

    @Column(name = "CREATE_DATE", nullable = false)
    val createDate: LocalDate,

    @Column(name = "END_DATE", nullable = false)
    val endDate: LocalDate
)

