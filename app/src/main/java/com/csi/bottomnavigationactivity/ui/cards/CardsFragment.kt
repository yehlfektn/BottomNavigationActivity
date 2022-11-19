package com.csi.bottomnavigationactivity.ui.cards

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csi.bottomnavigationactivity.AddEditCardActivity
import com.csi.bottomnavigationactivity.databinding.FragmentCardsBinding
import com.csi.bottomnavigationactivity.db.Card
import com.csi.bottomnavigationactivity.utils.CardClickInterface
import com.csi.bottomnavigationactivity.utils.CardRVAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardsFragment : Fragment(), CardClickInterface {

    private val cardsViewModel by viewModel<CardsViewModel>()

    private var _binding: FragmentCardsBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        val cardRVAdapter = CardRVAdapter(this)
        recyclerView.adapter = cardRVAdapter

        cardsViewModel.allCards.observe(viewLifecycleOwner) { list ->
            list?.let {
                cardRVAdapter.updateList(it)
            }
        }

        binding.idFAB.setOnClickListener {
            val intent = Intent(requireContext(), AddEditCardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCardClick(card: Card) {
        val intent = Intent(requireContext(), AddEditCardActivity::class.java)
        intent.putExtra("cardType", "Edit")
        intent.putExtra("cardQuestion",  card.question)
        intent.putExtra("cardAnswer", card.answer)
        intent.putExtra("cardId", card.id)
        startActivity(intent)
    }
}