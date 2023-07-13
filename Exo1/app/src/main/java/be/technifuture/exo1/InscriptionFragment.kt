package be.technifuture.exo1

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import be.technifuture.exo1.databinding.FragmentInscriptionBinding

class InscriptionFragment : Fragment() {

    lateinit var binding: FragmentInscriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInscriptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonInscription.setOnClickListener {

            if (!binding.textLogin.text.equals("@")) {
                setAlertDialog("Login incorrect")
            } else if (binding.textLogin.text.isNullOrEmpty()) {
                setAlertDialog("Login non rempli")
            } else if (binding.textPassword.text.equals(binding.textConfirmPassword.text)) {
                setAlertDialog("Les mots de passe ne corresponde pas")
            }else{
                val direction = InscriptionFragmentDirections.actionInscriptionFragmentToConfirmInscriptionFragment(binding.textLogin.text.toString())
                findNavController().navigate(direction)
            }
        }
    }

    fun setAlertDialog(text: String) {
        val builder = AlertDialog.Builder(context)
        builder
            .setTitle("Erreur")
            .setMessage(text)
            .setPositiveButton("Ok", null)
            .create()
            .show()
    }


}