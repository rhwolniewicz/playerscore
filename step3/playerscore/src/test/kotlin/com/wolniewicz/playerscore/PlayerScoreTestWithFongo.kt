package com.wolniewicz.playerscore

import com.github.fakemongo.junit.FongoRule
import com.wolniewicz.playerscore.model.Player
import com.wolniewicz.playerscore.repository.PlayerRepository
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
abstract class PlayerScoreTestWithFongo(val initializeTestData: Boolean = true) {
  @get:Rule
  val fongoRule = FongoRule()

  @Autowired
  lateinit var playerRepository: PlayerRepository

  @Before
  fun setupTestDatabase() {
    if (initializeTestData) {
      playerRepository.save(TEST_PLAYER_1)
      playerRepository.save(TEST_PLAYER_2)
      playerRepository.save(TEST_PLAYER_3)
      playerRepository.save(TEST_PLAYER_4)
      playerRepository.save(TEST_PLAYER_5)
    }
  }

  companion object {
    val TEST_PLAYER_1 = Player("alice", 20)
    val TEST_PLAYER_2 = Player("bob", 15)
    val TEST_PLAYER_3 = Player("charlie", 25)
    val TEST_PLAYER_4 = Player("dawn", 30)
    val TEST_PLAYER_5 = Player("ed", 10)
  }
}
