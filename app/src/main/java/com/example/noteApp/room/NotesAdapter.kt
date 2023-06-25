package com.example.noteApp.room


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kimziapplication.databinding.ItemNotesBinding
import com.example.noteApp.room.db.NoteModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NotesAdapter @Inject constructor( ) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    private lateinit var binding: ItemNotesBinding

    var itemClickListener: ((position: Int, name: NoteModel) -> Unit)? = null
    var donBtnCalLback: (( donStatuse:Boolean,noteModel: NoteModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ViewHolder {
        binding = ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: NotesAdapter.ViewHolder, position: Int) {

        holder.setData(differ.currentList[position])

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.N)
        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun setData(item: NoteModel) {
            binding.apply {

                if (item.doneStatus){
                    toDoBtn.setBackgroundColor(Color.GREEN)
                    //setBackgroundColor(Color.GREEN)
                    toDoBtn.text="انجام شده"
                }else{
                    toDoBtn.setBackgroundColor(Color.RED)
                    toDoBtn.text="انجام نشده"
                }
                titleTxt.text = " ${item.id}:${item.title}"
                deleteBtn.setOnClickListener { id ->
                    itemClickListener?.invoke(position, item)
                }

                toDoBtn.setOnClickListener {
                    if (item.doneStatus){
                            toDoBtn.setBackgroundColor(Color.GREEN)
                        toDoBtn.text="انجام شده"
                    }else{
                        toDoBtn.setBackgroundColor(Color.RED)
                        toDoBtn.text="انجام نشده"
                    }
                    donBtnCalLback!!.invoke(!item.doneStatus,item)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
}




