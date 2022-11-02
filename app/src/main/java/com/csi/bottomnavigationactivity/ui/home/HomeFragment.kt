package com.csi.bottomnavigationactivity.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.csi.bottomnavigationactivity.databinding.FragmentHomeBinding
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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
        Timber.e("onCreateView()")
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("onViewCreated()")
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