package com.example.f1vision.ui.driver.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import com.example.f1vision.R
import com.example.f1vision.data.repository.Driver
import com.example.f1vision.databinding.FragmentDriverListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DriverListFragment : Fragment() {
    private lateinit var binding: FragmentDriverListBinding
    private val viewModel: DriverListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDriverListBinding.inflate(inflater,
            container,
            false,
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = DriverListAdapter(requireContext()) { driver ->
            onShowDetail(driver, view)
        }
        val rv = binding.driverList
        rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect{
                    adapter.submitList(it.driver)
                }
            }
        }
    }

    fun onShowDetail(driver: Driver, view: View) {
        val bundle = Bundle()
        bundle.putParcelable("driver", driver)
        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_driverListFragment_to_driverDetailFragment, bundle)
    }
}