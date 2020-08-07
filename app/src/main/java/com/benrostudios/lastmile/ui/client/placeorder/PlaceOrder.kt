package com.benrostudios.lastmile.ui.client.placeorder


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.benrostudios.lastmile.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlaceOrder : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = PlaceOrder()
    }

    private lateinit var viewModel: PlaceOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.place_order_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlaceOrderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}