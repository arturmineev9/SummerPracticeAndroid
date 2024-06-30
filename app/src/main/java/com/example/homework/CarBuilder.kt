package com.example.homework

open class CarBuilder <T: CarBuilder<T>> {
    var brand : String? = null
    var model : String? = null
    var year : Int? = null
    var color : String? = null
    var enginePower : Int? = null

    fun setBrand(brand : String) = apply { this.brand = brand } as T
    fun setModel(model: String) = apply { this.model = model } as T
    fun setYear(year: Int) = apply { this.year = year } as T
    fun setColor(color: String) = apply { this.color = color } as T
    fun setEnginePower(enginePower: Int) = apply { this.enginePower = enginePower } as T

    open fun build(): Car {
        return Car(brand, model, year, color, enginePower)
    }

}