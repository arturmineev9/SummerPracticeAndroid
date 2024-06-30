package com.example.homework

open class Car (
    val brand : String?,
    val model : String?,
    val year : Int?,
    val color : String?,
    val enginePower : Int?,
) {

    open fun getInfo()
    {
        println("Марка: $brand, Модель: $model, Год выпуска: $year, Цвет авто: $color, Мощность двигателя: $enginePower")
    }

}