package com.martinestudio.dialogbox

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.martinestudio.dialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("want to exit ?")
            builder1.setMessage("Do you want to close App ? ")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, i ->
                // Action when yes is clicked
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener{ dialog, i->
                dialog.cancel()
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener{
            val options = arrayOf("Football","Cricket","Hockey")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Chose your sports")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, which ->
                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()

            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener{ dialogInterface, i ->

            })
            builder2.setNegativeButton("Cancel",DialogInterface.OnClickListener{ dialogInterface, i ->

            })
            builder2.show()

        }
        binding.btn3.setOnClickListener{
            val options = arrayOf("Delhi","Mumbai","Gurgaon","Bangalore")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which cities you have visited ?")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, isChecked ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener{ dialogInterface, i ->

            })
            builder3.setNegativeButton("Cancel",DialogInterface.OnClickListener{ dialogInterface, i ->

            })
            builder3.show()
        }

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bgalertdialogbox))


        binding.customDialog.setOnClickListener{
            dialog.show()
        }

        var buttonStats = dialog.findViewById<Button>(R.id.btnStats)
        var buttonClose = dialog.findViewById<Button>(R.id.btnClose)
        buttonStats.setOnClickListener{
            Toast.makeText(this,"You clicked on Stats",Toast.LENGTH_SHORT).show()
        }
        buttonClose.setOnClickListener{
            dialog.dismiss()
        }

    }
}