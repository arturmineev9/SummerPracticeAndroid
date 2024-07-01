package com.example.homework

class Sedan(
    brand: String?,
    model: String?,
    year: Int?,
    color: String?,
    enginePower: Int?,
    val luxuryLevel: String?
) : Car(brand, model, year, color, enginePower) {
    class Builder : CarBuilder<Builder>() {
        private var luxuryLevel: String? = null

        fun setLuxuryLevel(luxuryLevel: String) = apply { this.luxuryLevel = luxuryLevel }

        override fun build(): Sedan {
            return Sedan(brand, model, year, color, enginePower, luxuryLevel)
        }
    }
}