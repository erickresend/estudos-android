package com.erickresend.aulao_017

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.text_id).text = "${args.user.name} - ${args.user.age}"

        view.findViewById<TextView>(R.id.text_id).setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}