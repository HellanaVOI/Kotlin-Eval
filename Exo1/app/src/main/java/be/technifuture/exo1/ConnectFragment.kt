package be.technifuture.exo1

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import be.technifuture.exo1.databinding.FragmentConnectBinding

class ConnectFragment : Fragment() {

    private lateinit var binding: FragmentConnectBinding
    private val args: ConnectFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConnectBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView2.setImageResource(
            when(args.type){
                connectedBy.FACEBOOK -> R.drawable.facebook
                connectedBy.TWITTER -> R.drawable.twitter
            }
        )

        binding.button.setOnClickListener {
            val verification = binding.textLogin.text.isNullOrEmpty() || binding.textPassword.text.isNullOrEmpty()

            if(verification){
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Error")
                    .setMessage("Login/Password incorrect")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }else {
                val direction = ConnectFragmentDirections.actionConnecyFragmentToConfirmConnectFragment(args.type)
                findNavController().navigate(direction)
            }
        }
    }


}