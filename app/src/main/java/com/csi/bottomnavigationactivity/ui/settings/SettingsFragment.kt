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

    // This property is only valid between onCreateView and
    // onDestroyView.
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
        //CallMovies as an Example

        // on below line we are initializing our adapter class.
        val configRVAdapter = ConfigRVAdapter(this, this)

        // on below line we are setting
        // adapter to our recycler view.
        binding.configRV.adapter = configRVAdapter

        // on below line we are calling all notes method
        // from our view modal class to observer the changes on list.
        settingsViewModel.allCfg.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                configRVAdapter.updateList(it)
            }
        })

        binding.idFAB.setOnClickListener {
            // adding a click listener for fab button
            // and opening a new intent to add a new note.
            val intent = Intent(requireContext(), AddEditConfigActivity::class.java)
            startActivity(intent)
        }
    }
        override fun onConfigClick(config: Config) {
            // opening a new intent and passing a data to it.
            val intent = Intent(requireContext(), AddEditConfigActivity::class.java)
            intent.putExtra("configType", "Edit")
            intent.putExtra("nameConfig", config.nameConfig)
            intent.putExtra("descriptionConfig", config.descriptionConfig)
            intent.putExtra("configId", config.id)
            startActivity(intent)
        }

        override fun onDeleteIconClick(config: Config) {
            // in on note click method we are calling delete
            // method from our view modal to delete our not.
            settingsViewModel.deleteConfig(config)
            // displaying a toast message
            showToast("${config.nameConfig} Deleted")
        }
    }









