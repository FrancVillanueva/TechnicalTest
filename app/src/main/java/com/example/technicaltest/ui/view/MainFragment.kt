package com.example.technicaltest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technicaltest.ui.viewmodel.GobMxViewModel
import com.example.technicaltest.databinding.FragmentMainBinding
import com.example.technicaltest.ui.view.adapter.FactsAdapter
import androidx.appcompat.widget.SearchView

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private lateinit var adapter: FactsAdapter
    private val viewModel: GobMxViewModel by viewModels()
    private val activity: MainActivity by lazy {
        (requireActivity() as MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentMainBinding.inflate(layoutInflater)
        initRecyclerView()
        observeViewModel()

        _binding.searchByName.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchByName(newText.orEmpty())
                return true
            }
        })
    }

    private fun searchByName(query: String) {
        val filteredResults = viewModel.getFilteredResults(query)
        adapter.setData(filteredResults)
    }

    private fun initRecyclerView() {
        _binding.rvCards.layoutManager = LinearLayoutManager(activity)
        adapter = FactsAdapter(emptyList())
        _binding.rvCards.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.apiResponse.observe(this) { apiResponse ->
            apiResponse?.let {
                adapter.setData(it.results)
            }
        }
    }
}
