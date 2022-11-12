package com.csi.bottomnavigationactivity.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.csi.bottomnavigationactivity.R
import com.csi.bottomnavigationactivity.databinding.FragmentAddEditBinding
import com.csi.bottomnavigationactivity.db.Post

class AddEditFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    private var _binding: FragmentAddEditBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentAddEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addButton.setOnClickListener {
            addPost()
            findNavController().navigate(R.id.action_addEditFragment_to_navigation_profile)
        }
    }

    private fun addPost() {
        if(isValidEntry()) {
            profileViewModel.addPost(
                binding.titleEditText.text.toString(),
                binding.contentEditText.text.toString()
            )
        }
    }

    private fun isValidEntry() = profileViewModel.isValidEntry(
        binding.titleEditText.text.toString(),
        binding.contentEditText.text.toString()
    )
}