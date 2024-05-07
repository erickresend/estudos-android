package com.erickresend.aulao_019.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erickresend.aulao_019.databinding.NotificationsFragmentBinding

class NotificationsFragment : Fragment() {

    private lateinit var _binding: NotificationsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NotificationsFragmentBinding.inflate(inflater)
        return _binding.root
    }
}