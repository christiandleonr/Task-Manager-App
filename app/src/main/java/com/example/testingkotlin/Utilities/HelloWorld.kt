@file:Suppress("NAME_SHADOWING")

package com.example.testingkotlin.Utilities

fun main(args: Array<String>){
    /*
    println("Hello World!")

    // Variables and how to assign a type
    var name:String = "Christian"
    val lastName:String = "Ramirez"

    println("$name $lastName")
    println("My name is $name and my last name is $lastName")

    // String template
    val nameLastName:String = """
        My name is:
        ${name.length}
        My last name is:
        $lastName
    """.trimIndent()

    println(nameLastName)

    // Reading data
    println("Enter your name : ")
    name = readLine().toString()
    print("The name is $name")

    val names = mutableListOf<String>()
    readLine()?.let { names.add(it) }

    // for loop
    for(i in 0..2){
        readLine()?.let { names.add(it) }
    }

    for(name in names){
        println(name)
    }

    // Maps
    val translation = mutableMapOf<String, String>("Hello" to "Hola", "Good bye" to "Adios")
    translation["Hello"] = "Hi"
    println(translation["Hello"])


    // Functions
    fun hi(){
        println("Hi!")
    }

    hi()

    fun bye(name: String, lastName: String):String{
        return "Bye! $name $lastName"
    }

    println(bye("Christian", "Ramirez"))


    fun bye (name: String, lastName: String): String = "Bye $name $lastName"
    println(bye("Christian", "Ramirez"))
     */

    class Person(name: String, lastName: String){
        var name: String = name
        var lastName: String = lastName
    }

    val person = Person("Christian", "Ramirez")
    println(person.name)
    println(person.lastName)
}