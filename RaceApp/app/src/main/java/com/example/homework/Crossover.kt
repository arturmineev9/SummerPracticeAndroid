package com.example.homework

class Crossover(
    brand: String?,
    model: String?,
    year: Int?,
    color: String?,
    enginePower: Int?,
    val drive: String?
) : Car(brand, model, year, color, enginePower) {
    class Builder : CarBuilder<Builder>() {
        private var drive: String? = null

        fun setDrive(drive: String) = apply { this.drive = drive }

        override fun build(): Crossover {
            return Crossover(brand, model, year, color, enginePower, drive)
        }
    }
}