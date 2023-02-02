package com.example.taskapp.ui.accept

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentAcceptBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class AcceptFragment : Fragment() {
    private lateinit var binnding: FragmentAcceptBinding
    private lateinit var args: AcceptFragmentArgs
    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binnding = FragmentAcceptBinding.inflate(inflater, container, false)
        return binnding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { AcceptFragmentArgs.fromBundle(it) }!!
        auth=FirebaseAuth.getInstance()
        binnding.btnSms.setOnClickListener {
            val credential =
                PhoneAuthProvider.getCredential(args.verId, binnding.etCode.text.toString())
            signInWithPhoneAuthCredential(credential)
        }
    }


    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.navigation_home)
                    val user = task.result?.user
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.e("ololo", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }
}



