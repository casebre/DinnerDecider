package ca.casebre.dinnerdecider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Chinese", "Thai", "Burgers", "Tacos", "Pizza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDecide.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            txtSelectedFood.text = foodList[randomFood]
        }

        btnAdd.setOnClickListener {
            if(edtAddFood.text.length <= 3)
                edtAddFood.setError("Add a food")
            else if (foodList.contains(edtAddFood.text.toString()))
                edtAddFood.setError("Food already exists")
            else {
                foodList.add(edtAddFood.text.toString())
                edtAddFood.text.clear()
                Toast.makeText(
                        this,
                        "Food added successfully",
                        Toast.LENGTH_LONG).show()
            }
        }
    }
}
