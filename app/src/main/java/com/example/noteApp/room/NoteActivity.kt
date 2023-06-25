package com.example.noteApp.room


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteApp.databinding.ActivityNoteBinding
import com.example.noteApp.room.db.NoteModel
import com.example.noteApp.room.repository.DbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteBinding

    @Inject
    lateinit var repository: DbRepository

    @Inject
    lateinit var notesAdapter: NotesAdapter

    @Inject
    lateinit var entity: NoteModel
    private var userID = 0
    private var userTITLE = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        notesAdapter.differ.submitList(repository.getAllNotes())
        setContentView(binding.root)
        binding.apply {
            //Save
            btnSave.setOnClickListener {
                entity.id = 0
                entity.title = titleEdt.text.toString()
                repository.saveNote(entity)
                //با این کار بعد از سیو کردن نوشته فیلد رو خالی میکنه
                titleEdt.setText("")
                //  اینو اگه اینجا بنویسی درجا اپدیت میشه لیستت هم یعنی با اضافه کردن یه متن اونو توو لیستت هم نمایش میده اما اگر در * اضافه کنی باید دوباره باز و بسته کنی برنامه رو بعد نشون میده لیستتو و اپدیت میکنه لیستتو
                notesAdapter.differ.submitList(repository.getAllNotes())
                Toast.makeText(
                    this@NoteActivity,
                    "برنامه مورد نظر با موفقیت اضافه شد",
                    Toast.LENGTH_SHORT
                ).show()
            }
                //GetData
                //*
                noteList.apply {
                    layoutManager = LinearLayoutManager(this@NoteActivity)
                    adapter = notesAdapter
                }
            }


            notesAdapter.itemClickListener = {

                    position, name ->

                val builder = AlertDialog.Builder(this)
                builder.setMessage("آیا برنامه مورد نظر حدف شود؟")
                    .setCancelable(false)
                    .setPositiveButton(
                        "بله"
                    ) { dialog, id ->
                        repository.deleteNotes(name.id)
                        Toast.makeText(
                            this@NoteActivity,
                            "حذف با موفقیت انجام شد",
                            Toast.LENGTH_SHORT
                        ).show()
                        notesAdapter.differ.submitList(repository.getAllNotes())
                    }
                    .setNegativeButton(
                        "خیر"
                    ) { dialog, id ->  dialog.cancel()}
                val alert = builder.create()
                alert.show()
            }

        notesAdapter.donBtnCalLback={
           don, noteModel ->
            repository.updatedoneStatus(don,noteModel.id)
            notesAdapter.differ.submitList(repository.getAllNotes())






        }

        }
}


