package com.example.moto_app

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moto_app.R
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.core.view.marginBottom
import kotlinx.android.synthetic.main.connexionfailed.view.*

class CheckStatusActivity : AppCompatActivity() {
    private var checkIntrnetButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_status)



        checkIntrnetButton = findViewById<View>(R.id.checkInternet) as Button
        checkIntrnetButton!!.setOnClickListener {
            checkConnection()
        }
    }
    private fun alert(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.connexionfailed, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setCancelable(false)
        val  mAlertDialog = mBuilder.show()
        mDialogView.verifier.setOnClickListener {
            checkConnection()
            mAlertDialog.dismiss()
        }
    }
    private fun showDialoe(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.connexionfailed)
        dialog.setCancelable(false)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.findViewById<View>(R.id.verifier).setOnClickListener {

        }
        dialog.show()
        dialog.window!!.attributes = lp
    }

    protected val isOnline: Boolean
        protected get() {
            val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }

    private fun checkConnection() {
        if (isOnline) {
            Toast.makeText(
                this@CheckStatusActivity,
                "Vous etes connecter a  Internet",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            alert()
            Toast.makeText(
                this@CheckStatusActivity,
                "Vous n'estes pas connecter a internet",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}