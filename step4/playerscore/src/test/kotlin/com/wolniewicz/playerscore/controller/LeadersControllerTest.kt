package com.wolniewicz.playerscore.controller

import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class LeadersControllerTest : PlayerScoreTestWithFongoAndMockMvc() {
  @Test
  fun getLeadersTest() {
    logger.info("Begin getLeadersTest")

    val expectedJson = """
        |["${TEST_PLAYER_4.handle}",
        |"${TEST_PLAYER_3.handle}",
        |"${TEST_PLAYER_1.handle}"]
        """.trimMargin()

    mvc.perform(MockMvcRequestBuilders.get("/leaders"))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().json(expectedJson))

    logger.info("End getLeadersTest")
  }

  companion object {
    val logger: Logger = LoggerFactory.getLogger(LeadersControllerTest::class.java)
  }
}
