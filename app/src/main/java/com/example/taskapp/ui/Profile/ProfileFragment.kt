package com.example.taskapp.ui.Profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.taskapp.data.Pref
import com.example.taskapp.databinding.FragmentProfileBinding
import com.example.taskapp.ui.utils.loadImage

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref

    private val launcher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null
        ) {
            val photoUri = result.data?.data
            pref.saveImage (photoUri.toString())
            binding.ivProfile.loadImage(photoUri.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        binding.etUserName.setText(pref.getName())
        binding.etUserAge.setText(pref.getAge())

        binding.save.setOnClickListener {
            pref.saveName(binding.etUserName.text.toString())
            pref.setAge(binding.etUserAge.text.toString())
            binding.ivProfile.loadImage(pref.getImage())



        }

        binding.ivProfile.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
    }
}