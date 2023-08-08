package com.EdwinGoaly.fundamentoskotlin.Reto3

class Subasta() {
    fun subastaParticipantes(articulo: Double) {
        var cantidadOfertantes: Int = 5
        var ofertaGanadora = 0.0
        var contadorOfertantes = 1

        while (cantidadOfertantes > 0) {
            if (contadorOfertantes > 5){
                contadorOfertantes = 1
            }
            if (ofertaGanadora > 0) {
                print("¿OFERTANTE N°$contadorOfertantes, ¿desea hacer una oferta por este artículo teniendo en cuenta que la oferta más alta es de: $ofertaGanadora? (Si/No): ")
            } else {
                print("¿OFERTANTE N°$contadorOfertantes, ¿desea hacer una oferta por este artículo? (Si/No): ")
            }

            val respuesta: String = readLine()!!.toString().lowercase()
            when (respuesta) {
                "si" -> {
                    print("Por favor, ingrese el precio que desea ofertar, debe ser superior al precio base: ")
                    val ofertaNueva: Double = readLine()!!.toDouble()
                    if (ofertaNueva > ofertaGanadora && ofertaNueva > articulo) {
                        ofertaGanadora = ofertaNueva
                    } else {
                        println("El monto de la oferta debe ser superior al precio actual del artículo.")
                    }
                }
                else -> {
                    cantidadOfertantes--
                }

            }
            contadorOfertantes++
            if(cantidadOfertantes == 1 && ofertaGanadora > 0){
                break

            }
        }

        if (ofertaGanadora > 0) {
            println("La oferta ganadora es $ofertaGanadora")
        } else {
            println("El artículo se vendió a la casa de subastas con el precio de $articulo debido a que nadie ofertó por él.")
        }
    }

}

fun main() {
    println("Bienvenidos a la subasta")
    while (true) {
         println("Digite el número del artículo que se va a subastar:")
        println("1) Articulo 1")
        println("2) Articulo 2")
        println("3) Articulo 3")
        println("4) Articulo 4")
        println("5) Salir")
        val opcion: String = readLine()!!.toString().lowercase()

        val subasta = Subasta()

        if (opcion == "1") {
            val valorArticulo1: Double = 3000.0
            println("El precio base del Articulo 1 es de ($valorArticulo1)")
            subasta.subastaParticipantes(valorArticulo1)
        }
        else if (opcion == "2") {
            val valorArticulo2: Double = 2500.0
            println("El precio base del Articulo 2 es de ($valorArticulo2)")
            subasta.subastaParticipantes(valorArticulo2)
        }
        else if (opcion == "3") {
            val valorArticulo3: Double = 3000.0
            println("El precio base del Articulo 3 es de ($valorArticulo3)")
            subasta.subastaParticipantes(valorArticulo3)
        }
        else if (opcion == "4") {
            val valorArticulo4: Double = 7000.0
            println("El precio base del Articulo 4 es de ($valorArticulo4)")
            subasta.subastaParticipantes(valorArticulo4
            )
        }
        else if (opcion == "5") {
            break
        }
        else {
            print("OPCIÓN EQUIVOCADA, DIGITE UNA OPCIÓN VÁLIDA")
        }
    }
}
