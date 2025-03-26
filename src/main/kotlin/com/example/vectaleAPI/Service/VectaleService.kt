package com.example.vectaleAPI.Service

import com.example.vectaleAPI.Entity.Pack
import com.example.vectaleAPI.Entity.Card
import com.example.vectaleAPI.Entity.PackMonths
import com.example.vectaleAPI.Entity.Users
import com.example.vectaleAPI.Repository.CardRepository
import com.example.vectaleAPI.Repository.PackMonthsRepository
import com.example.vectaleAPI.Repository.PackRepository
import com.example.vectaleAPI.Repository.UsersRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*


@Service
class VectaleService(
    private val usersRepository: UsersRepository ,
    private val cardRepository: CardRepository ,
    private val packRepository: PackRepository ,
    private val packMonthsRepository: PackMonthsRepository
) {
    //User
    fun getUserById(id: Long): Users {

        return usersRepository.findById(id).get()
    }

    fun logIn(email: String, password: String): Long {
        val usr =  usersRepository.findByUserEmailAndUserPassword(email, password)
        return if (usr is Users){
            usr.id
        }else{
            -1
        }
    }
    fun signUpService(users: Users): Users = usersRepository.save(users)
    //Pack
    fun getPackById(id:Long): Optional<Pack> = packRepository.findById(id)
    fun getPackByIdUser(idUsers : Long): Pack = packRepository.findByIdUser(idUsers)
    @Transactional
    fun createPack(pack: Pack): Pack {
        val savedPack = packRepository.save(pack)
        val card = createCardService(pack)
        return savedPack
    }
    //Card
    fun getCardByIdUser(idUsers: Long): List<Card> {
        val pack = packRepository.findByIdUser(idUsers)
        return cardRepository.findByPack(pack)
    }

    private fun createCardService(pack: Pack):Card = cardRepository.save(Card( pack = pack , disponible = false))

    //PackMonths

    fun getPackMonthsById(id : Long): Optional<PackMonths> = packMonthsRepository.findById(id)
    fun getPackMonthsByIdUser(idUsers: Long): PackMonths? {
        val pack = packRepository.findByIdUser(idUsers)
        return packMonthsRepository.getPackMonthsRepositoryByPack(pack)
    }
    fun createPackMonth(packMonths: PackMonths):PackMonths = packMonthsRepository.save(packMonths)
}
