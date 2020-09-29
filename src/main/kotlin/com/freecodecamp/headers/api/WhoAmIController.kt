package com.freecodecamp.headers.api

import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/whoami")
class WhoAmIController {
    @GetMapping
    fun get(@RequestHeader headers: HttpHeaders): ResponseEntity<Reply> {
        println(headers)

        val software = headers["user-agent"]!![0]
        val language = headers["accept-language"]!![0]
        val host = headers["x-forwarded-for"]!![0]

        return ResponseEntity.ok(Reply(host, language, software))
    }
}
