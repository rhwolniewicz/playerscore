package com.wolniewicz.playerscore.controller

import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class PlayerControllerTest : PlayerScoreTestWithFongoAndMockMvc() {
  @Test
  fun postPlayerScoreTest() {
    logger.info("Begin postPlayerScoreTest")

    val points = 5
    val expectedTotalScore = TEST_PLAYER_1.totalScore + points
    val expectedResult =
        "${TEST_PLAYER_1.handle} now has a total score of " +
        "$expectedTotalScore."

    // Add 5 points to TEST_PLAYER_1's score.
    mvc.perform(MockMvcRequestBuilders
        .post("/player/${TEST_PLAYER_1.handle}/score")
        .content(points.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().string(expectedResult))

    logger.info("End postPlayerScoreTest")
  }

  companion object {
    val logger: Logger = LoggerFactory.getLogger(PlayerControllerTest::class.java)
  }
}
