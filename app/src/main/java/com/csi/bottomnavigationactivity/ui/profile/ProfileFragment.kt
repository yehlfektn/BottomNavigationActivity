package com.csi.bottomnavigationactivity.ui.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.csi.bottomnavigationactivity.R
import com.csi.bottomnavigationactivity.databinding.FragmentProfileBinding
import timber.log.Timber

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    private var _binding: FragmentProfileBinding? = null
    private val binding
        get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.e("onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("onViewCreated()")
        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textProfile.text = it
        })
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.e("onViewStateRestored()")
    }

    override fun onStart() {
        super.onStart()
        Timber.e("onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.e("onPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.e("onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.e("onDestroyView()")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.e("onDetach()")
    }
}