package be.technifuture.exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import be.technifuture.exo1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTwitter.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToConnecyFragment(connectedBy.TWITTER)
            findNavController().navigate(direction)
        }

        binding.buttonFacebook.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToConnecyFragment(connectedBy.FACEBOOK)
            findNavController().navigate(direction)
        }

        binding.buttonInscription.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToInscriptionFragment()
            findNavController().navigate(direction)
        }
    }

}

enum class connectedBy{
    FACEBOOK, TWITTER
}