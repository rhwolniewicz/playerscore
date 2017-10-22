package com.wolniewicz.playerscore.service

import com.wolniewicz.playerscore.PlayerScoreTestWithFongo
import com.wolniewicz.playerscore.model.Player
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals

class PlayerServiceTest : PlayerScoreTestWithFongo() {
  @Autowired
  lateinit var playerService: PlayerService

  @Test
  fun testLeaders() {
    logger.info("Begin testLeaders")

    // Verify that the leaders are as expected.
    val leaders = playerService.leaders()
    assertEquals(3, leaders.size, "There should be 3 leaders.")
    assertEquals(TEST_PLAYER_4, leaders[0], "The first leader should be dawn.")
    assertEquals(TEST_PLAYER_3, leaders[1], "The second leader should be charlie.")
    assertEquals(TEST_PLAYER_1, leaders[2], "The third leader should be alice.")

    logger.info("End testLeaders")
  }

  @Test
  fun testScore() {
    logger.info("Begin testScore")

    playerRepository.save(Player(TEST_PLAYER_HANDLE))

    // Score 10 points.
    playerService.score(TEST_PLAYER_HANDLE, 10)
    val player = playerRepository.findById(TEST_PLAYER_HANDLE).get()
    assertEquals(10, player.totalScore, "Total score should be 10 after the first scoring event.")
    assertEquals(1, player.history.size, "The history should have a single element.")
    assertEquals(10, player.history[0].points, "The recorded points should be 10.")

    // Score 5 more points.
    playerService.score(TEST_PLAYER_HANDLE, 5)
    val player2 = playerRepository.findById(TEST_PLAYER_HANDLE).get()
    assertEquals(15, player2.totalScore, "Total score should be 15 after the second scoring event.")
    assertEquals(2, player2.history.size, "The history should have a single element.")
    assertEquals(10, player2.history[0].points, "The first recorded points should be 10.")
    assertEquals(5, player2.history[1].points, "The second recorded points should be 5.")

    logger.info("End testScore")
  }

  companion object {
    val logger: Logger = LoggerFactory.getLogger(PlayerServiceTest::class.java)
    const val TEST_PLAYER_HANDLE = "testPlayer"
  }
}
