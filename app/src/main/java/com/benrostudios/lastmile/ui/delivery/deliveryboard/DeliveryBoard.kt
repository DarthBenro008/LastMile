package com.benrostudios.lastmile.ui.delivery.deliveryboard

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benrostudios.lastmile.R

class DeliveryBoard : Fragment() {

    companion object {
        fun newInstance() = DeliveryBoard()
    }

    private lateinit var viewModel: DeliveryBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.delivery_board_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DeliveryBoardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}