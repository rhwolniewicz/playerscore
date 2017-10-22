package com.wolniewicz.playerscore.controller

import com.wolniewicz.playerscore.PlayerScoreTestWithFongo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc

@AutoConfigureMockMvc
abstract class PlayerScoreTestWithFongoAndMockMvc(initializeTestData: Boolean = true) :
    PlayerScoreTestWithFongo(initializeTestData) {
  @Autowired
  lateinit var mvc: MockMvc
}
