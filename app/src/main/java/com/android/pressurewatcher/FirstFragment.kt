package com.android.pressurewatcher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.pressurewatcher.databinding.FragmentFirstBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirstFragment : Fragment(R.layout.fragment_first) {
    private val binding: FragmentFirstBinding by viewBinding()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

    }


}