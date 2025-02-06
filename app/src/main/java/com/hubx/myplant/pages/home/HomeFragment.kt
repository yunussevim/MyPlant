package com.hubx.myplant.pages.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hubx.myplant.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWeather("Izmir").observe(viewLifecycleOwner) { weather ->
            binding.tvTemperature.text = String.format("${weather.temperature} °C")
        }

        binding.rvQuestion.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.articles.observe(viewLifecycleOwner) { articleList ->
            binding.rvQuestion.adapter = QuestionsListAdapter(articleList.map { article ->
                QuestionsListItem(
                    text = article.title,
                    src = article.imageUri
                )
            })
        }

        binding.rvPlants.layoutManager = GridLayoutManager(requireContext(), 2)
        viewModel.plants.observe(viewLifecycleOwner) { plantList ->
            binding.rvPlants.adapter = PlantsListAdapter(plantList.map { plant ->
                PlantsListItem(
                    text = plant.title,
                    src = plant.imageUrl
                )
            })
        }
    }
}