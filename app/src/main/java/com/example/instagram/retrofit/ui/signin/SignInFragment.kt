package com.example.instagram.retrofit.ui.signin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.instagram.R
import com.example.instagram.data.ApiSignIn
import com.example.instagram.data.resource.ResourceState
import com.example.instagram.databinding.SignInBinding
import com.example.instagram.di.Settings
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment(R.layout.sign_in) {

    private lateinit var binding: SignInBinding
    private val viewModel: SignInViewModel by viewModel()
    private val settings: Settings by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (settings.isSign > 0) {
            findNavController().navigate(R.id.action_signIn_to_mainFragment)
            return
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SignInBinding.bind(view)

        binding.btnLogIn.setOnClickListener {
            val login = binding.editLogin.text.toString()
            val password = binding.editPassword.text.toString()

            if (login.isEmpty() && password.isEmpty()) {
                Toast.makeText(requireContext(), "Bos orinlardi toltirin", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.signIn(ApiSignIn( user_name = login, password = password))
            }
        }

        viewModel.getClient.observe(viewLifecycleOwner,{
            when(it.status) {
                ResourceState.LOADING -> binding.progressBar.isVisible = true
                ResourceState.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    settings.isSign = it.data!!.payload.id
                    findNavController().navigate(R.id.action_signIn_to_mainFragment)
                }
                ResourceState.ERROR -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}