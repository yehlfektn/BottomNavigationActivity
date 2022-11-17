package com.csi.bottomnavigationactivity.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.csi.bottomnavigationactivity.R
import com.csi.bottomnavigationactivity.databinding.FragmentDashboardBinding
import com.csi.bottomnavigationactivity.utils.CharRVAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private val dashboardViewModel by viewModel<DashboardViewModel>()
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        val adapter = CharRVAdapter()
        recyclerView.adapter = adapter
        dashboardViewModel.getChars()
        dashboardViewModel.charList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}