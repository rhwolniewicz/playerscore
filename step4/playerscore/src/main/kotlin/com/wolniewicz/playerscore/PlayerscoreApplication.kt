package com.wolniewicz.playerscore

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PlayerscoreApplication

fun main(args: Array<String>) {
    SpringApplication.run(PlayerscoreApplication::class.java, *args)
}
