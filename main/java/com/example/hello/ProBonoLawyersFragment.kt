package com.example.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProBonoLawyersFragment : Fragment() {

    private lateinit var recyclerViewProBono: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pro_bono_lawyers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the RecyclerView
        recyclerViewProBono = view.findViewById(R.id.recyclerViewProBono)

        // Sample list of pro bono lawyers
        val proBonoLawyersList = listOf(
            "Lawyer 1: John Doe",
            "Lawyer 2: Jane Smith",
            "Lawyer 3: Richard Roe",
            "Lawyer 4: Mary Major"
        )

        // Set up the RecyclerView with the adapter
        val adapter = ProBonoLawyersAdapter(proBonoLawyersList)
        recyclerViewProBono.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewProBono.adapter = adapter
    }
}
