package com.example.vectaleAPI.Repository

import com.example.vectaleAPI.Entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<Users, Long> {
    fun findByUserEmailAndUserPassword(userEmail: String, userPassword: String): Users?
}

