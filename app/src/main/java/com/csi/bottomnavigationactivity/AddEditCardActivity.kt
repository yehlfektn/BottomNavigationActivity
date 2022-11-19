package com.csi.bottomnavigationactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.csi.bottomnavigationactivity.db.Card
import com.csi.bottomnavigationactivity.ui.cards.CardsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddEditCardActivity : AppCompatActivity() {

    private lateinit var cardQuestionEdit: EditText
    private lateinit var cardAnswerEdit: EditText
    private lateinit var submitBtn: Button

    private val cardsViewModel by viewModel<CardsViewModel>()
    private var id = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_card)

        cardQuestionEdit = findViewById(R.id.cardQuestion)
        cardAnswerEdit = findViewById(R.id.cardAnswer)
        submitBtn = findViewById(R.id.submitBtn)

        val cardType = intent.getStringExtra("cardType")
        if  (cardType.equals("Edit")) {
            val cardQuestion = intent.getStringExtra("cardQuestion")
            val cardAnswer = intent.getStringExtra("cardAnswer")
            id = intent.getIntExtra("cardId", -1)
            submitBtn.text = "Update"
            cardQuestionEdit.setText(cardQuestion)
            cardAnswerEdit.setText(cardAnswer)
        } else {
            submitBtn.text = "Submit"
        }

        submitBtn.setOnClickListener {
            val cardQuestion = cardQuestionEdit.text.toString()
            val cardAnswer = cardQuestionEdit.text.toString()

            if (cardType.equals("Edit")) {
                if (cardQuestion.isNotEmpty() && cardAnswer.isNotEmpty()) {
                    val updatedCard = Card(cardQuestion, cardAnswer)
                    updatedCard.id = id
                    cardsViewModel.updateCard(updatedCard)
                    Toast.makeText(this, "Card Updated", Toast.LENGTH_SHORT).show()
                }
            } else {
                if (cardQuestion.isNotEmpty() && cardAnswer.isNotEmpty()) {
                    cardsViewModel.addCard(Card(cardQuestion, cardAnswer))
                    Toast.makeText(this, "Card Added", Toast.LENGTH_SHORT).show()
                }
            }
            finish()
        }
    }
}