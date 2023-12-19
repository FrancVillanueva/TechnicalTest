package com.example.technicaltest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.technicaltest.R
import com.example.technicaltest.databinding.FragmentLoginBinding
import com.example.technicaltest.ui.viewmodel.GobMxViewModel

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private var email = ""
    private var password = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        _binding.btnLogin.isEnabled = false

        _binding.ifEmail.addTextChangedListener { text ->
            email = text.toString()
            validateFields()
        }

        _binding.ifPassword.addTextChangedListener { text ->
            password = text.toString()
            validateFields()
        }

        _binding.btnLogin.setOnClickListener {
            if (email == "123" && password == "123") {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }

    private fun validateFields() {
        _binding.btnLogin.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }
}