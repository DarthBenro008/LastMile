package com.benrostudios.lastmile.ui.client.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.adapters.withSimpleAdapter
import com.benrostudios.lastmile.ui.base.ScopedFragment
import com.benrostudios.lastmile.utils.SharedPreferenceUtils
import com.benrostudios.lastmile.utils.errorSnackBar
import com.benrostudios.lastmile.utils.shortToaster
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dashboard_fragment.*
import kotlinx.android.synthetic.main.package_item_history_layout.view.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel

class Dashboard : ScopedFragment() {

    companion object {
        fun newInstance() = Dashboard()
    }

    private val viewModel by viewModel<DashboardViewModel>()
    private val sharedPreferenceUtils: SharedPreferenceUtils = get()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        networkError()
        getPackages()
        history_status_recycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getPackages() = launch {
        viewModel.getOrders(sharedPreferenceUtils.userId)
        viewModel.ordersList.observe(viewLifecycleOwner, Observer {
            Log.d("hello","$it")
            if (it.isNotEmpty()) {
                history_status_recycler.withSimpleAdapter(
                    it,
                    R.layout.package_item_history_layout
                ) { data ->
                    itemView.package_item_title.text = data.item_title
                    itemView.package_item_status.text = data.status
                    val bundle = Bundle()
                    itemView.order_desc_container.setOnClickListener {
                        val bottomSheetFrag = BottomSheetDialogFragment()
                        bottomSheetFrag.show(requireActivity().supportFragmentManager!!,bottomSheetFrag.tag)
                    }
                }
            } else {
                requireContext().shortToaster("No data found!!!")
            }
        })
    }

    private fun networkError() = launch {
        viewModel.networkError.observe(viewLifecycleOwner, Observer {
            dashboard_fragment_container.errorSnackBar(it)
        })
    }

}