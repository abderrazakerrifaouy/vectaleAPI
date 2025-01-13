package com.example.vectaleAPI.Repository

import com.example.vectaleAPI.Entity.Pack
import org.springframework.data.jpa.repository.JpaRepository

interface PackRepository : JpaRepository<Pack, Long>
{
    fun findByIdUser(idUser : Long) : Pack
}