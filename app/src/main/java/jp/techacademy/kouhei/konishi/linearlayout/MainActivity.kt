package jp.techacademy.kouhei.konishi.linearlayout

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }
    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")

                if ((hour >= 2 && minute >= 0) && (hour < 10 && minute <= 59)){
                    textView.text = "おはよう"
                }else if ((hour >= 10 && minute >= 0) && (hour < 18 && minute <= 59)){
                    textView.text = "こんにちは"
                }else if ((hour >= 18 && minute >= 0) || (hour < 2 && minute <= 59)){
                    textView.text = "こんばんは"
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }
}