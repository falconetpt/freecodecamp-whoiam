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
        val software = headers.getValuesAsList("user-agent").fold("") {
            acc, s -> "$acc, $s"
        }
        val language = headers.getValuesAsList("accept-language").fold("") {
            acc, s -> "$acc, $s"
        }
        val host = headers.getValuesAsList("x-forwarded-for").fold("") {
            acc, s -> "$acc, $s"
        }

        return ResponseEntity.ok(Reply(host, language, software))
    }
}
