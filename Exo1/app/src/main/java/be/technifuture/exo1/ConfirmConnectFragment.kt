package be.technifuture.exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import be.technifuture.exo1.databinding.FragmentConfirmConnectBinding
import be.technifuture.exo1.databinding.FragmentConnectBinding

class ConfirmConnectFragment : Fragment() {

    private lateinit var binding: FragmentConfirmConnectBinding
    private val args: ConfirmConnectFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmConnectBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoConfirm.setImageResource(
            when(args.type){
                connectedBy.FACEBOOK -> R.drawable.facebook
                connectedBy.TWITTER -> R.drawable.twitter
            }
        )
    }

}