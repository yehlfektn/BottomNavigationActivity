package com.csi.bottomnavigationactivity.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.csi.bottomnavigationactivity.databinding.FragmentDashboardBinding
import timber.log.Timber

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("onCreateView()")
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView()")
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) =
        super.onCreate(savedInstanceState).also { Timber.i("onCreate()") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        super.onViewCreated(view, savedInstanceState).also { Timber.i("onViewCreated()") }

    override fun onViewStateRestored(savedInstanceState: Bundle?) =
        super.onViewStateRestored(savedInstanceState).also { Timber.i("onViewStateRestored()") }

    override fun onStart() = super.onStart().also { Timber.i("OnStart()") }

    override fun onResume() = super.onResume().also { Timber.i("OnResume()") }

    override fun onPause() = super.onPause().also { Timber.i("onPause()") }

    override fun onStop() = super.onStop().also { Timber.i("onStop()") }

    override fun onSaveInstanceState(outState: Bundle) =
        super.onSaveInstanceState(outState).also { Timber.i("onSaveInstanceState()") }

    override fun onDestroy() = super.onDestroy().also { Timber.i("onDestroy()") }

}