package com.erickresend.aulao_017

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erickresend.aulao_017.databinding.FragmentFirstBinding
import com.erickresend.aulao_017.models.User

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.text_id).setOnClickListener {

            val action  = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                user = User(
                    "Erick Resende",
                    30
                )
            )

            findNavController().navigate(action)
        }
    }
}