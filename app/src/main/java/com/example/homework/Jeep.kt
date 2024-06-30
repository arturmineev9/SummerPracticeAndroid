package com.example.homework

class Jeep(
    brand: String?,
    model: String?,
    year: Int?,
    color: String?,
    enginePower: Int?,
    val frameType: String?
) : Car(brand, model, year, color, enginePower) {

    class Builder : CarBuilder<Builder>() {
        private var frameType: String? = null

        fun setFrameType(frameType: String?) = apply { this.frameType = frameType }
        override fun build(): Car {
            return Jeep(brand, model, year, color, enginePower, frameType)
        }
    }
}