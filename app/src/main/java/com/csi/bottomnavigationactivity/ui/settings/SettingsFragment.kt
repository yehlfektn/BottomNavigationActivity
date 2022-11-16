package com.csi.bottomnavigationactivity.ui.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.csi.bottomnavigationactivity.AddEditConfigActivity
import com.csi.bottomnavigationactivity.AddEditNoteActivity
import com.csi.bottomnavigationactivity.databinding.FragmentHomeBinding
import com.csi.bottomnavigationactivity.databinding.FragmentSettingsBinding
import com.csi.bottomnavigationactivity.db.Config
import com.csi.bottomnavigationactivity.db.Note
import com.csi.bottomnavigationactivity.utils.*
import timber.log.Timber


class SettingsFragment : Fragment(), ConfigClickInterface, ConfigClickDeleteInterface {

    private lateinit var settingsViewModel: SettingsViewModel
    private var _binding: FragmentSettingsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.e("onCreateView()")

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val configRVAdapter = ConfigRVAdapter(this, this)


        binding.configRV.adapter = configRVAdapter


        settingsViewModel.allCfg.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                configRVAdapter.updateList(it)
            }
        })

        binding.idFAB2.setOnClickListener {
            val intent = Intent(requireContext(), AddEditConfigActivity::class.java)
            startActivity(intent)
        }
    }

        override fun onConfigClick(config: Config) {
            val intent = Intent(requireContext(), AddEditConfigActivity::class.java)
            intent.putExtra("configType", "Edit")
            intent.putExtra("nameConfig", config.nameConfig)
            intent.putExtra("descriptionConfig", config.descriptionConfig)
            intent.putExtra("configId", config.id)
            startActivity(intent)
        }

        override fun onDeleteIconClick(config: Config) {
            settingsViewModel.deleteConfig(config)
            // displaying a toast message
            showToast("${config.nameConfig} Deleted")
        }
    }









