package com.example.vectaleAPI.Controller

import com.example.vectaleAPI.Entity.Pack
import com.example.vectaleAPI.Entity.Users
import com.example.vectaleAPI.Service.VectaleService
import org.springframework.web.bind.annotation.*

@RestController

@RequestMapping("/api/vectale")
class VectaleController (
    private val  vectaleService: VectaleService
) {
    //USER
    @PostMapping("/user/login")
    fun logIn(@RequestParam("email") email: String, @RequestParam("password") password: String) : Long {
        return vectaleService.logIn(email, password)
    }
    @PostMapping("/user/signUp")
    fun signUp(@RequestBody user: Users): Users = vectaleService.signUpService(user)

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id : Long): Users = vectaleService.getUserById(id)
    //Pack
    @GetMapping("/pack/{id}")
    fun getPackById(@PathVariable id: Long) = vectaleService.getPackById(id)

    @GetMapping("pack/userId/{id}")
    fun getPackByIdUser(@PathVariable id : Long) = vectaleService.getPackByIdUser(id)

    @PostMapping("pack/Create")
    fun createPack(@RequestBody pack: Pack) = vectaleService.createPack(pack)

    //Card
    @GetMapping("Card/{id}")
    fun getCardByIdUser(@PathVariable id: Long) = vectaleService.getCardByIdUser(id)
}