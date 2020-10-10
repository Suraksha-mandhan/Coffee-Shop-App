package com.example.coffeeshop

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var numOfCoffee=1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inc_qty_btn.setOnClickListener {
            if (numOfCoffee >= 100) {
                Toast.makeText(this, getString(R.string.inc_bound_warning), Toast.LENGTH_SHORT).show()
            } else {
                numOfCoffee += 1;
                qty_value.text = "$numOfCoffee"
            }
        }
        dec_qty_btn.setOnClickListener {
            if (numOfCoffee == 1) {
                Toast.makeText(this, getString(R.string.dec_bound_warning), Toast.LENGTH_SHORT).show()
            } else {
                numOfCoffee -= 1;
                qty_value.text = "$numOfCoffee"
            }
        }
    }
    fun submitOrder(view: View) {
        var pricePerCup=5.0
        val name=name_value.text.toString()
        val creamStatus=cream_checkbox.isChecked
        if(creamStatus)
        {
            pricePerCup+=1
        }
        val chocStatus=chocolate_checkbox.isChecked
        if(chocStatus)
        {
            pricePerCup+=2
        }
        var price= numOfCoffee*pricePerCup
        orderSummary_value.setMovementMethod(ScrollingMovementMethod())
        var orderSummary= getString(R.string.name_label) + name
        orderSummary+="\n"+getString(R.string.whip_cream) + creamStatus
        orderSummary+= "\n"+getString(R.string.add_choc)+chocStatus
        orderSummary+="\n"+getString(R.string.quantity)+numOfCoffee
        orderSummary+="\n"+ getString(R.string.total)+"$" + price
        orderSummary+="\n"+getString(R.string.thank_you)
       orderSummary_value.text=orderSummary
    }

}
