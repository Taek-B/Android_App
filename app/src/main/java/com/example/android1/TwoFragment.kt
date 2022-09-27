package com.example.android1

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android1.databinding.FragmentTwoBinding


//class TwoFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val binding = FragmentTwoBinding.inflate(inflater, container, false)
//
//
//        binding.help.setOnClickListener {
//
//        }
//        return binding.root
//    }

class TwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTwoBinding.inflate(inflater, container, false)


        binding.help.setOnClickListener {
            
        }
        return binding.root
    }




}