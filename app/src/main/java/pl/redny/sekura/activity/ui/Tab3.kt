package pl.redny.sekura.activity.ui

import android.Manifest
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guardanis.applock.AppLock
import com.guardanis.applock.dialogs.LockCreationDialogBuilder
import kotlinx.android.synthetic.main.tab3.*
import pl.redny.sekura.R
import pl.redny.sekura.util.SuperUser

class Tab3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.tab3, container, false)
    }

    override fun onStart() {
        super.onStart()
        button_pin.setOnClickListener { setAuthButton() }
        button_pin_reset.setOnClickListener { resetAuthButton() }
        button_ask_permissions.setOnClickListener { grantPermissions() }
        button_ask_permissions_root.setOnClickListener { askForRoot() }
    }

    private fun setAuthButton() {
        LockCreationDialogBuilder(activity)
            .show()
    }

    private fun resetAuthButton() {
        AppLock.getInstance(activity)
            .invalidateEnrollments()
    }

    private fun grantPermissions() {
        requestPermissions(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_SMS,
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.RECEIVE_BOOT_COMPLETED
            ),
            100
        )
    }

    private fun askForRoot() {
        SuperUser().execute()
    }

}