package be.technifuture.exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.exo2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var liveData: MutableLiveData<Item>? = null
    private lateinit var binding: FragmentHomeBinding
    private var listItem = mutableListOf<Item>()
    /*(
        Item("Potato", 5, TypeItem.BOISSON),
        Item("Potato", 5, TypeItem.ALIMENTATION),
        Item("Potato", 5, TypeItem.MAISON),
        Item("Potato", 5, TypeItem.HYGIENE),
        Item("Potato", 5, TypeItem.BOISSON),
        Item("Potato", 5, TypeItem.ALIMENTATION)
    )*/

    companion object {
        const val LIVE_DATA_KEY = "LIVE_DATA_KEY"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        isListEmpty()

        val stateHandle = findNavController().currentBackStackEntry?.savedStateHandle
        liveData = stateHandle?.getLiveData(LIVE_DATA_KEY)

        liveData?.observe(viewLifecycleOwner) { result ->
            listItem.add(result)
            setupRecyclerView()
            isListEmpty()
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.extRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = ItemListAdapter(listItem.toMutableList())
        }

    private fun isListEmpty(){
        if(listItem.isEmpty())
            binding.labelEmpty.visibility = View.VISIBLE
        else
            binding.labelEmpty.visibility = View.GONE
    }
}