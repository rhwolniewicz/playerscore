package com.wolniewicz.playerscore.repository

import com.wolniewicz.playerscore.model.Player
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, String> {
  fun findTop3ByOrderByTotalScoreDesc() : List<Player>
}
