package com.example.vectaleAPI.Repository

import com.example.vectaleAPI.Entity.Card
import com.example.vectaleAPI.Entity.Pack
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<Card, Long>
{
    fun findByPack(pack: Pack) : List<Card>
}