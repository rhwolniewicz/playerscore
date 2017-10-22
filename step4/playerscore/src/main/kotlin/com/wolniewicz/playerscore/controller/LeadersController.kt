package com.wolniewicz.playerscore.controller

import com.wolniewicz.playerscore.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.streams.toList

@RestController
class LeadersController {
  @Autowired
  lateinit var playerService: PlayerService

  @GetMapping("/leaders")
  fun getLeaders(): List<String> =
      playerService.leaders().stream().map { it.handle }.toList()
}
