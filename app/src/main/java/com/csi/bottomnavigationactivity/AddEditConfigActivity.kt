package com.csi.bottomnavigationactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.csi.bottomnavigationactivity.db.Config
import com.csi.bottomnavigationactivity.ui.settings.SettingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class AddEditConfigActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for our UI components.
    lateinit var configTitleEdt: EditText
    lateinit var configEdt: EditText
    lateinit var saveBtn: Button

    // on below line we are creating variable for
    // viewmodal and and integer for our note id.
    private val settingsViewModel by viewModel<SettingsViewModel>()
    var configID = -1

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        // on below line we are initializing all our variables.
        configTitleEdt = findViewById(R.id.idEdtNoteName)
        configEdt = findViewById(R.id.idEdtNoteDesc)
        saveBtn = findViewById(R.id.idBtn)

        // on below line we are getting data passed via an intent.
        val configType = intent.getStringExtra("configType")
        if (configType.equals("Edit")) {
            // on below line we are setting data to edit text.
            val nameConfig = intent.getStringExtra("nameConfig")
            val descriptionConfig = intent.getStringExtra("descriptionConfig")
            configID = intent.getIntExtra("configId", -1)
            saveBtn.text = "Update Config"
            configTitleEdt.setText(nameConfig)
            configEdt.setText(descriptionConfig)
        } else {
            saveBtn.text = "Save Config"
        }

        // on below line we are adding
        // click listener to our save button.
        saveBtn.setOnClickListener {
            // on below line we are getting
            // title and desc from edit text.
            val nameConfig = configTitleEdt.text.toString()
            val descriptionConfig = configEdt.text.toString()
            // on below line we are checking the type
            // and then saving or updating the data.
            if (configType.equals("Edit")) {
                if (nameConfig.isNotEmpty() && descriptionConfig.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    val updatedConfig = Config(nameConfig, descriptionConfig, currentDateAndTime)
                    updatedConfig.id = configID
                    settingsViewModel.updateConfig(updatedConfig)
                    Toast.makeText(this, "Config Updated..", Toast.LENGTH_LONG).show()
                }
            } else {
                if (nameConfig.isNotEmpty() && descriptionConfig.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    // if the string is not empty we are calling a
                    // add note method to add data to our room database.
                    settingsViewModel.addConfig(Config(nameConfig, descriptionConfig, currentDateAndTime))
                    Toast.makeText(this, "$nameConfig Added", Toast.LENGTH_LONG).show()
                }
            }
            finish()
        }
    }
}