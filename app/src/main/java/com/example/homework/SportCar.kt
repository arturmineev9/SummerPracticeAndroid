package com.example.homework

class SportCar(
    brand: String?,
    model: String?,
    year: Int?,
    color: String?,
    enginePower: Int?,
    val topSpeed: Int?
) : Car(brand, model, year, color, enginePower) {
    class Builder : CarBuilder<Builder>() {
        private var topSpeed: Int? = null

        fun setTopSpeed(topSpeed: Int) = apply { this.topSpeed = topSpeed }

        override fun build(): SportCar {
            return SportCar(brand, model, year, color, enginePower, topSpeed)
        }
    }
}