package com.benrostudios.lastmile.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE

class SharedPreferenceUtils(
    private val context: Context
) {

    private fun getPrefs() = context.getSharedPreferences("Data", MODE_PRIVATE)


    companion object {
        const val SHARED_PREFERENCE_USER_TYPE = "userType"
        const val SHARED_PREFERENCE_USER_ID = "clientId"
        const val SHARED_PREFERENCE_NAME = "name"

    }

    var userId: Int
        get() = getPrefs()?.getInt(SHARED_PREFERENCE_USER_ID, 0) ?: 0
        set(value) {
            getPrefs()?.edit()?.putInt(SHARED_PREFERENCE_USER_ID, value)?.apply()
        }

    var userName: String
        get() = getPrefs()?.getString(SHARED_PREFERENCE_NAME, "") ?: ""
        set(value) {
            getPrefs()?.edit()?.putString(SHARED_PREFERENCE_NAME, value)?.apply()
        }
    var userType: String
        get() = getPrefs()?.getString(SHARED_PREFERENCE_USER_TYPE, "") ?: ""
        set(value) {
            getPrefs()?.edit()?.putString(SHARED_PREFERENCE_USER_TYPE, value)?.apply()
        }

    fun nukeSharedPrefs() = getPrefs().edit().clear()

}