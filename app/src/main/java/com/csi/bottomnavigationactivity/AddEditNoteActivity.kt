package com.csi.bottomnavigationactivity


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.csi.bottomnavigationactivity.db.Note
import com.csi.bottomnavigationactivity.ui.home.HomeViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for our UI components.
    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button

    // on below line we are creating variable for
    // viewmodal and and integer for our note id.
    lateinit var homeViewModel: HomeViewModel
    var noteID = -1;

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        // on below line we are initialing our view modal.
        homeViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[HomeViewModel::class.java]

        // on below line we are initializing all our variables.
        noteTitleEdt = findViewById(R.id.idEdtNoteName)
        noteEdt = findViewById(R.id.idEdtNoteDesc)
        saveBtn = findViewById(R.id.idBtn)

        // on below line we are getting data passed via an intent.
        val noteType = intent.getStringExtra("noteType")
        if (noteType.equals("Edit")) {
            // on below line we are setting data to edit text.
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDescription = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteId", -1)
            saveBtn.text = "Update Note"
            noteTitleEdt.setText(noteTitle)
            noteEdt.setText(noteDescription)
        } else {
            saveBtn.text = "Save Note"
        }

        // on below line we are adding
        // click listener to our save button.
        saveBtn.setOnClickListener {
            // on below line we are getting
            // title and desc from edit text.
            val noteTitle = noteTitleEdt.text.toString()
            val noteDescription = noteEdt.text.toString()
            // on below line we are checking the type
            // and then saving or updating the data.
            if (noteType.equals("Edit")) {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
                    updatedNote.id = noteID
                    homeViewModel.updateNote(updatedNote)
                    Toast.makeText(this, "Note Updated..", Toast.LENGTH_LONG).show()
                }
            } else {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    // if the string is not empty we are calling a
                    // add note method to add data to our room database.
                    homeViewModel.addNote(Note(noteTitle, noteDescription, currentDateAndTime))
                    Toast.makeText(this, "$noteTitle Added", Toast.LENGTH_LONG).show()
                }
            }
            finish()
        }
    }
}