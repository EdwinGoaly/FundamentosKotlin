package com.EdwinGoaly.fundamentoskotlin.Reto1
import kotlin.random.Random
class Telefono {

}
/*1. Reto 1: Por lo general, el teléfono te proporciona un resumen de las notificaciones, escribe un programa que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste. El programa debe permitir almacenar el mensaje y el conteo de mensajes que recibe cada teléfono. El mensaje debe incluir lo siguiente:

· La cantidad exacta de notificaciones cuando haya menos de 100

· 99+ como cantidad de notificaciones cuando haya 100 o más.

· Y si no hay mensajes que aparezca que no existen mensajes disponibles*/
fun main() {
    val mensajesTelefono = mutableMapOf<String, MutableList<String>>()
    val conteoMensajes = mutableMapOf<String, Int>()
    val notificaciones= Random.nextInt(0, 300)
    val cantidadNotificaciones = if (notificaciones < 100) "Ha recibido $notificaciones notificaciones" else "Ha recibido 99+ notificaciones"
    println(cantidadNotificaciones)
    do {
        println("¿Qué desea realizar?")
        println("1. Guardar Mensaje")
        println("2. Obtener conteo de mensajes")
        println("3. Mostrar Mensajes")
        println("4. Finalizar")
        print("Dígite una opción ")
        val opcion = readLine()!!.toString()
        when(opcion){
            "1" ->{
                println("Ingrese el número del teléfono al cual le quiere asignar el mensaje")
                val numTelefono = readLine()!!.toString()
                println("Ingrese el mensaje")
                val mensaje = readLine()!!.toString().lowercase()
                if(mensajesTelefono[numTelefono] != null){
                    val objeto = mensajesTelefono[numTelefono]
                    if(objeto != null) {
                        objeto.add(mensaje)
                        mensajesTelefono.put(numTelefono, objeto)
                    }
                }else{
                    mensajesTelefono.put(numTelefono, mutableListOf(mensaje))
                }
                val conteo = conteoMensajes[numTelefono]
                if (conteo != null) {
                    conteoMensajes.put(numTelefono, conteo + 1)
                }else{
                    conteoMensajes.put(numTelefono, 1)
                }
            }
            "2" ->{
                if (conteoMensajes.isNotEmpty()){
                    for (i in conteoMensajes.entries){
                        println("Num. Teléfono: ${i.key}, Cantidad mensajes: ${i.value}")
                    }
                }else{
                    println("No hay mensajes para mostrar")
                }
            }
            "3" ->{
                if (mensajesTelefono.isNotEmpty()){
                    println("Mostrando los telefonos con sus respectivos mensajes...")
                    for (i in mensajesTelefono.entries){
                        println("Num. Teléfono: ${i.key}, Mensajes: ${i.value}")
                    }
                }else{
                    println("No hay mensajes para mostrar")
                }
            }
            "4" ->{
                println("Saliendo del programa...")
                break
            }
        }
    }while(true)
}