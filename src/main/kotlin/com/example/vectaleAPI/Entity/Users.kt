package com.example.vectaleAPI.Entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "users")
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long = 0,

    @Column(name = "NOM", nullable = false)
    val nom: String,

    @Column(name = "PRENOM", nullable = false)
    val prenom: String,

    @Column(name = "TEL", nullable = false)
    val tel: String,

    @Column(name = "DATENAISSANCE", nullable = false)
    val dateNaissance: LocalDate,

    @Column(name = "ADRESSE", nullable = false)
    val adresse: String,

    @Column(name = "CNI", nullable = false, unique = true)
    val cni: String,

    @Column(name = "CNE", nullable = false, unique = true)
    val cne: String,

    @Column(name = "USEREMAIL", nullable = false, unique = true)
    val userEmail: String,

    @Column(name = "USERPASSWORD", nullable = false) //
    val userPassword: String,

    @Column(name = "USERIMG", nullable = false) // العمود USERIMG
    val userImg: String
)
