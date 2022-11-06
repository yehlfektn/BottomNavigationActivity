package com.csi.bottomnavigationactivity.ui.dudos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.csi.bottomnavigationactivity.databinding.FragmentDashboardBinding
import com.csi.bottomnavigationactivity.databinding.FragmentDudosBinding
import com.csi.bottomnavigationactivity.databinding.FragmentHomeBinding
import com.csi.bottomnavigationactivity.ui.dashboard.DashboardViewModel
import com.csi.bottomnavigationactivity.ui.home.HomeViewModel
import timber.log.Timber

class DudosFragment : Fragment() {

    private lateinit var dudosViewModel: DudosViewModel
    private var _binding: FragmentDudosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.e("onCreateView()")
        dudosViewModel =
            ViewModelProvider(this).get(DudosViewModel::class.java)

        _binding = FragmentDudosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.e("onDestroyView()")
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        Timber.e("OnStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("OnResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.e("onPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.e("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("onDestroy()")
    }
}