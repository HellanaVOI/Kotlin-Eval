package be.technifuture.exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import be.technifuture.exo2.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var type: TypeItem = TypeItem.ALIMENTATION


        // Modification de la variable type au click dans le Radio Groupe
        binding.groupRadio.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.radioBoisson == checkedId)
                type = TypeItem.BOISSON
            if (R.id.radioHygiene == checkedId)
                type = TypeItem.HYGIENE
            if (R.id.radioMaison == checkedId)
                type = TypeItem.MAISON
            if (R.id.radioNourriture == checkedId)
                type = TypeItem.ALIMENTATION
        }


        //listener de Save
        binding.buttonSave.setOnClickListener {
            val item = Item(
                binding.editProduct.text.toString(),
                binding.editQuantity.text.toString().toInt(),
                type
            )
            val firstFragmentStateHandle = findNavController().previousBackStackEntry?.savedStateHandle
            firstFragmentStateHandle?.set(HomeFragment.LIVE_DATA_KEY, item)
            findNavController().popBackStack()
        }

        //Listener d'annuler
        binding.buttonCancel.setOnClickListener {
            findNavController().popBackStack()

        }
    }

}