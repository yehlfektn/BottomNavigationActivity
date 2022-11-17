package com.csi.bottomnavigationactivity.ui.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csi.bottomnavigationactivity.db.Card
import com.csi.bottomnavigationactivity.repository.CardRepository
import kotlinx.coroutines.launch

class CardsViewModel(
    private val repository: CardRepository
) : ViewModel() {
    val allCards: LiveData<List<Card>> = repository.allCards

    fun addCard(card: Card) {
        viewModelScope.launch {
            repository.insert(card)
        }
    }

    fun deleteCard(card: Card) {
        viewModelScope.launch {
            repository.delete(card)
        }
    }

    fun updateCard(card: Card) {
        viewModelScope.launch {
            repository.update(card)
        }
    }
}