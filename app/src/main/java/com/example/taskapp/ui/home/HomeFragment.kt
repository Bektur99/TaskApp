package com.example.taskapp.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.ui.home.adapter.TaskAdapter
import com.example.taskapp.ui.model.Task


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TaskAdapter
    private val task = Task()

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onLongClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    fun setData() {
        val tasks = App.db.taskDao().getAll()
        adapter.addTask(tasks)
    }
    private fun onLongClick(task: Task){
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Do you want to delete?")
        alertDialog.setNegativeButton("NO",object :DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.cancel()
            }
        })
        alertDialog.setPositiveButton("Yes",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                App.db.taskDao().delete(task)
                setData()
            }
        })
        alertDialog.create().show()
    }

}

