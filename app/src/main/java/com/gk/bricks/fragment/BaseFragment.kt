package com.gk.bricks.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.elite.x300.base.primarynav.NavigationCommand
import com.gk.bricks.BaseActivity
import com.gk.bricks.viewmodel.BaseViewModel

abstract class BaseFragment : Fragment() {

    protected lateinit var viewModel: BaseViewModel
    lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        if (this::viewModel.isInitialized) {
            viewModel.navigationCommands.observe(viewLifecycleOwner) { command ->
                when (command) {
                    is NavigationCommand.ToDirections -> navController.navigate(command.direction)
                    is NavigationCommand.ToDestinationId -> navController.navigate(command.destinationId)
                    is NavigationCommand.BackTo -> navController.popBackStack(
                        command.destinationId,
                        command.isInclusive
                    )

                    is NavigationCommand.Back -> navController.popBackStack()
                    is NavigationCommand.ToDeepLink -> navController.navigate(command.deepLinkUri)
                    else -> {}
                }
            }
        }
    }

    fun showToast(message: String) {
        requireActivity().let {
            if (it is BaseActivity) it.showToast(message)
        }
    }


}