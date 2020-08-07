package com.benrostudios.lastmile.ui.common.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.ui.auth.AuthActivity
import com.benrostudios.lastmile.utils.SharedPreferenceUtils
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.ext.android.get
import kotlin.math.log

class Profile : Fragment() {
    private val sharedPreferenceUtils: SharedPreferenceUtils = get()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        profile_username.text = sharedPreferenceUtils.userName
        profile_user_type.text = sharedPreferenceUtils.userType
        logout.setOnClickListener {
            sharedPreferenceUtils.nukeSharedPrefs()
            startActivity(Intent(requireActivity(), AuthActivity::class.java))
            requireActivity().finish()
        }
    }
}