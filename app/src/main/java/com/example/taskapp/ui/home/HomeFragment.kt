package com.example.taskapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.ui.home.adapter.TaskAdapter
import com.example.taskapp.ui.model.Task
import com.example.taskapp.ui.task.TaskFragment


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TaskAdapter
    private val task = Task()

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()

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
            setFragmentResultListener(TaskFragment.RESULT_TASK) { key, bundle ->
                // Здесь можно передать любой тип, поддерживаемый Bundle-ом
                val result = bundle.getSerializable("task") as Task
                adapter.addTask(result)
                Log.e("ololo", "onViewCreated: " + result)
            }
            binding.recyclerView.adapter = adapter
            binding.fab.setOnClickListener {
                findNavController().navigate(R.id.taskFragment)
            }
        }
    }

