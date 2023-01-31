package com.example.taskapp.ui.task


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.databinding.FragmentTaskBinding
import com.example.taskapp.ui.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            App.db.taskDao().insert(
                Task(
                    tittle = binding.etTittle.text.toString(),
                    desc = binding.etDesc.text.toString()
                )
            )
            findNavController().navigateUp()
        }
    }


    companion object {
        const val RESULT_TASK = "result,task"
    }
}