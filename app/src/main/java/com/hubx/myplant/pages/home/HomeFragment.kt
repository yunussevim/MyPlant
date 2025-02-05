package com.hubx.myplant.pages.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hubx.myplant.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    val questions = listOf(
        QuestionsListItem("https://firebasestorage.googleapis.com/v0/b/flora---plant-identifier.appspot.com/o/public%2FCard.png?alt=media", "How to identify plants easily with PlantApp?"),
        QuestionsListItem("https://firebasestorage.googleapis.com/v0/b/flora---plant-identifier.appspot.com/o/public%2FCard.png?alt=media", "How to identify plants?"),
        QuestionsListItem("https://firebasestorage.googleapis.com/v0/b/flora---plant-identifier.appspot.com/o/public%2FCard.png?alt=media", "How to identify plants?"),
    )

    val plants = listOf(
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
        PlantsListItem("https://cms-cdn.plantapp.app/5_d2384a3938/5_d2384a3938.png","Cacti and Succulents"),
    )

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvQuestion.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = QuestionsListAdapter(questions)
        binding.rvQuestion.adapter = adapter

        binding.rvPlants.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvPlants.adapter = PlantsListAdapter(plants)

    }
}