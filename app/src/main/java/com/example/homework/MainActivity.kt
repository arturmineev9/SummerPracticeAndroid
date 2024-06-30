package com.example.homework


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var carsCountEditText : EditText
    private lateinit var startRaceButton : Button
    private lateinit var winnerListTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        carsCountEditText = findViewById(R.id.editTextText2)
        startRaceButton = findViewById(R.id.raceBeginButton)
        winnerListTextView = findViewById(R.id.winnerList)

        fun appendToWinnerList(text: String) {
            winnerListTextView.append("$text\n")
        }

        fun createCars(count: Int): List<Car> {
            val colors = listOf("Rainbow", "Black", "Blue", "Red", "Yellow")
            val brands = listOf("Toyota", "Honda", "BMW", "Audi")
            val drives = listOf("FWD", "RWD", "AWD")
            val carTypes = listOf("Crossover", "Sedan", "SportCar", "Jeep")
            val luxuryLevels = listOf("Бюджетный", "Средний", "Премиум")
            val frameTypes = listOf("Лонжеронная", "Хребтовая", "Периферийная")
            return List(count) {
                val brand = brands.random()
                val model = "${it + 1}"
                val year = 2015 + Random.nextInt(10)
                val drive = drives.random()
                val color = colors.random()
                val enginePower = 100 + Random.nextInt(200)
                val luxuryLevel = luxuryLevels.random()
                val frameType = frameTypes.random()
                when (carTypes.random()) {
                    "Crossover" -> Crossover(brand, model, year, color, enginePower, drive)
                    "Sedan" -> Sedan(brand, model, year, color, enginePower, luxuryLevel)
                    "SportCar" -> SportCar(brand, model, year, color, enginePower, 250 + Random.nextInt(100))
                    "Jeep" -> Jeep(brand, model, year, color, enginePower, frameType)
                    else -> Car(brand, model, year, color, enginePower)
                }
            }
        }

        fun race(car1: Car, car2: Car): Car {
            return if (car1.enginePower!! > car2.enginePower!!) {
                appendToWinnerList("Гонка между ${car1.model} и ${car2.model}, Победитель: ${car1.model}")
                car1
            } else {
                appendToWinnerList("Гонка между ${car1.model} и ${car2.model}, Победитель: ${car2.model}")
                car2
            }
        }

        fun startRace(cars: List<Car>) {
            var raceCars = cars.shuffled()
            while (raceCars.size > 1) {
                val nextRound = mutableListOf<Car>()
                for (i in raceCars.indices step 2) {
                    if (i + 1 < raceCars.size) {
                        val winner = race(raceCars[i], raceCars[i + 1])
                        nextRound.add(winner)
                    } else {
                        nextRound.add(raceCars[i])
                    }
                }
                raceCars = nextRound.shuffled()
            }
            appendToWinnerList("Победитель гонки: ${raceCars.first().model}")
        }

        startRaceButton.setOnClickListener(View.OnClickListener {
            val carsCount = carsCountEditText.text.toString().toIntOrNull()

            if (carsCount != null && carsCount > 1) {
                winnerListTextView.text = ""
                val cars = createCars(carsCount)
                startRace(cars)
            }
            else {
                winnerListTextView.text = "Введите правильное число."
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}