package com.example.randomweather

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.randomweather.databinding.FragmentLoginBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.randomweather.databinding.SignupBottomSheetContentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {
    private lateinit var loginBottomSheet: BottomSheetDialogFragment
    private lateinit var signUpBottomSheet: BottomSheetDialogFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        loginBottomSheet = LoginModalBottomSheet()
        signUpBottomSheet = SignupModalBottomSheet()

        binding.btnLoginAsGuest.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.btnRegister.setOnClickListener {
            signUpBottomSheet.show(parentFragmentManager, SignupModalBottomSheet.TAG)
        }

        binding.btnLogin.setOnClickListener {
            loginBottomSheet.show(parentFragmentManager, LoginModalBottomSheet.TAG)
        }

        return binding.root
    }


    override fun onDetach() {

        super.onDetach()
    }
}

class LoginModalBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.login_bottom_sheet_content, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}

class SignupModalBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SignupBottomSheetContentBinding = DataBindingUtil.inflate(
            inflater, R.layout.signup_bottom_sheet_content, container, false)
        val loginBottomSheet = LoginModalBottomSheet()


        val userName = binding.txtInputUserName.text
        val userEmail = binding.txtInputUserEmail.text
        val userPassword = binding.txtInputUserPass.text
        val userConfirmPass = binding.txtInputUserConfirmPass.text

        binding.btnConfirmSignUp.setOnClickListener{
            Toast.makeText(context, "$userName's email is $userEmail and password is $userPassword", Toast.LENGTH_LONG).show()
        }

        binding.btnLoginInstead.setOnClickListener{
            dismiss()
            loginBottomSheet.show(parentFragmentManager, LoginModalBottomSheet.TAG)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDismiss(dialog: DialogInterface) {

        super.onDismiss(dialog)
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}