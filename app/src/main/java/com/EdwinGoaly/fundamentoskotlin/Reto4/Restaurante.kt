package com.EdwinGoaly.fundamentoskotlin.Reto4

class Restaurante {
    private val menu = mutableMapOf<Int, Plato>()

    class Plato(val codigo: Int, var nombre: String, var descripcion: String, var precio: Double) {
        fun mostrarPlato(): String {
            return "Código: $codigo, Nombre: $nombre, Descripción: $descripcion, Precio: $precio"
        }
    }
    fun añadirPlatoAlMenu(codigo: Int, nombre: String, descripcion: String, precio: Double) {
        val plato = Plato(codigo, nombre, descripcion, precio)
        menu[codigo] = plato
    }

    fun mostrarPlatos() {
        println("   MENÚ DEL RESTAURANTE   ")
        if (menu.isEmpty()){
            println("No hay platos en el menú")
        }else{
            for (plato in menu.values) {
                println(plato.mostrarPlato())
            }
        }
    }

    fun mostrarPlatoPorCodigo(codigo: Int): Boolean {
        val plato = menu[codigo]
        if (plato != null) {
            println("------- Plato con código $codigo -------")
            println(plato.mostrarPlato())
            return true
        } else {
            println("No se encontró ningún plato con el código $codigo")
        }
        return false
    }

    fun modificarPlatoMenu(codigo: Int, nombre: String, descripcion: String, precio: Double) {
        val plato = menu[codigo]
        if (plato != null) {
            plato.nombre = nombre
            plato.descripcion = descripcion
            plato.precio = precio
            println("Plato con código $codigo modificado exitosamente.")
        }
    }

    fun removerPlatoMenu(codigo: Int) {
        if (menu.remove(codigo) != null) {
            println("El Plato con el código $codigo se ha eliminado.")
        }
    }
}

fun main() {
    val restaurante = Restaurante()
    var continuar = true


    while (continuar) {
        println("\nMenú del Restaurante")
        println("1. Agregar plato")
        println("2. Mostrar todos los platos")
        println("3. Mostrar plato por código")
        println("4. Modificar plato")
        println("5. Eliminar plato")
        println("6. Salir")
        println("")
        print("Ingrese la opción deseada: ")
        var op: Int = readLine()!!.toInt()
        when (op) {
            1 -> {
                println("Agregar Plato")
                print("Ingrese el código del plato: ")
                val codigo = readLine()!!.toInt()
                print("Ingrese el nombre del plato: ")
                val nombre = readLine()!!.toString()
                print("Ingrese la descripción del plato: ")
                val descripcion = readLine()!!.toString()
                print("Ingrese el precio del plato: ")
                val precio = readLine()!!.toDouble()

                restaurante.añadirPlatoAlMenu(codigo, nombre, descripcion, precio)
                println("El Plato  ha sido agregado exitosamente.")
            }
            2 -> {
                restaurante.mostrarPlatos()
            }
            3 -> {
                println("Mostrar Plato por Código")
                print("Ingrese el código del plato: ")
                val codigo = readLine()!!.toInt()
                if (restaurante.mostrarPlatoPorCodigo(codigo)) {
                    restaurante.mostrarPlatoPorCodigo(codigo)
                } else {
                    println("Código inválido.")
                }
            }
            4 -> {
                println("Modificar Plato")
                print("Ingrese el código del plato que desea modificar: ")
                val codigo = readLine()!!.toInt()
                if (restaurante.mostrarPlatoPorCodigo(codigo)) {
                    println("Deje el campo vacio si no desea modificar el campo, solamente en los campos de nombre y descripción")
                    println("")
                    print("Ingrese el nuevo nombre: ")
                    val nombre = readLine()!!.toString()
                    print("Ingrese la nueva descripción: ")
                    val descripcion = readLine()!!.toString()
                    print("Ingrese el nuevo precio: ")
                    val precio = readLine()!!.toDouble()

                    restaurante.modificarPlatoMenu(codigo, nombre, descripcion, precio)
                } else {
                    println("Código incorrecto.")
                }
            }
            5 -> {
                println("Eliminar Plato")
                print("Ingrese el código del plato que desea eliminar: ")
                val codigo = readLine()!!.toInt()
                if (restaurante.mostrarPlatoPorCodigo(codigo)) {
                    restaurante.removerPlatoMenu(codigo)
                } else {
                    println("Código inválido.")
                }
            }
            6 -> {
                continuar = false
                println("Ha salido del programa Exitosamente.")
            }
            else -> println("Opción incorrecta.")
        }
    }
}