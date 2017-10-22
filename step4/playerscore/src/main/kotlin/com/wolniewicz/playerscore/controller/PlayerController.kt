package com.wolniewicz.playerscore.controller

import com.wolniewicz.playerscore.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController {
  @Autowired
  lateinit var playerService: PlayerService

  @PostMapping("/player/{handle}/score")
  fun postPlayerScore(@PathVariable handle: String,
                      @RequestBody points: String) : String {
    val score = playerService.score(handle, points.toInt())

    return "$handle now has a total score of $score."
  }
}
