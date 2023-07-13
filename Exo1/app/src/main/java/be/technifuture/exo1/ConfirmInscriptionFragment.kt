package be.technifuture.exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import be.technifuture.exo1.databinding.FragmentConfirmConnectBinding
import be.technifuture.exo1.databinding.FragmentConfirmInscriptionBinding

class ConfirmInscriptionFragment : Fragment() {

    private lateinit var binding: FragmentConfirmInscriptionBinding
    private val args: ConfirmInscriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmInscriptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textConfirm.text = "Bienvenu ${args.login}"

    }

}