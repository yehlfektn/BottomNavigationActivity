package com.csi.bottomnavigationactivity.repository

import androidx.lifecycle.LiveData
import com.csi.bottomnavigationactivity.db.Card
import com.csi.bottomnavigationactivity.db.CardsDao

class CardRepository(private val cardsDao: CardsDao) {
    val allCards: LiveData<List<Card>> = cardsDao.getCards()

    suspend fun insert(card: Card) = cardsDao.insert(card)

    suspend fun delete(card: Card) = cardsDao.delete(card)

    suspend fun update(card: Card) = cardsDao.update(card)
}