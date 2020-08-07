package com.benrostudios.lastmile.ui.client.placeorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benrostudios.lastmile.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class OrderDescription : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order_description, container, false)
    }

}