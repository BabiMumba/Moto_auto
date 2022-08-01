package com.example.moto_app

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.activity_check_status.*
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
    private fun showDialog(){
        val dialog = Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.connexionfailed)
        dialog.setCancelable(false)
        dialog.findViewById<View>(R.id.verifier).setOnClickListener {
            checkConnection()
            dialog.dismiss()
        }
        dialog.show()
    }

    protected val isOnline: Boolean
        protected get() {
            val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }

    @SuppressLint("ResourceType")
    private fun checkConnection() {
        if (isOnline) {
            //setContentView(R.id.activity)
            failed_n.visibility = View.GONE
            checkInternet.visibility = View.VISIBLE
            Toast.makeText(
                this@CheckStatusActivity,
                "Vous etes connecter a  Internet",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            checkInternet.visibility = View.GONE
            failed_n.visibility = View.VISIBLE
            Toast.makeText(
                this@CheckStatusActivity,
                "Vous n'estes pas connecter a internet",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}