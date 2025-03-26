package com.example.vectaleAPI.Repository

import com.example.vectaleAPI.Entity.Pack
import com.example.vectaleAPI.Entity.PackMonths
import org.springframework.data.jpa.repository.JpaRepository

interface PackMonthsRepository : JpaRepository<PackMonths, Long>
{
    fun getPackMonthsRepositoryByPack(pack: Pack) : PackMonths ?
}