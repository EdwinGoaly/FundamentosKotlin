package com.EdwinGoaly.fundamentoskotlin.Reto2

class Album(private var tipoMusica: String) {
    private val canciones = mutableListOf<Cancion>()

    class Cancion(var titulo: String, var artista: String, var añoPublicacion: String, var reproducciones: Int){
        fun obtenerCancion(): String{
            return "Titulo: $titulo, Artista: $artista, Año de Publicacion: $añoPublicacion, Reproducciones: $reproducciones"
        }
    }
    fun obtenerTipoMusicaAlbum(): String{
        return "El tipo de música del albúm es: ${this.tipoMusica}"
    }
    fun obtenerCanciones(){
        if (canciones.isNotEmpty()){
            for (i in canciones){
                println("______________________________________________________________________________________________")
                println(i.obtenerCancion())
                println("______________________________________________________________________________________________")
            }
        }else{
            println("No hay canciones en el album")
        }
    }
    fun agregarCancion(titulo: String, artista: String, añoPublicacion: String, reproducciones: Int){
        val cancion = Cancion(titulo, artista, añoPublicacion, reproducciones)
        canciones.add(cancion)
        println("Cancion agregada al album con exito")
    }
    fun mostrarCancionConMasReproducciones(){
        var reproduccionesCanPopu = 0
        var posicionCanPopular = 0
        if (canciones.isNotEmpty()){
            for ((posicion, valor) in canciones.withIndex()){
                if (valor.reproducciones > reproduccionesCanPopu){
                    reproduccionesCanPopu = valor.reproducciones
                    posicionCanPopular = posicion
                }
            }
            val cancion = canciones[posicionCanPopular]
            println("______________________________________________________________________________________________")
            println("La canción más popular es: ${cancion.titulo} con ${cancion.reproducciones} reproducciones")
            println("______________________________________________________________________________________________")
        }else{
            println("No hay canciones")
        }
    }
    fun evaluarPopularidadCancion(){
        if (canciones.isNotEmpty()){
            for (valor in canciones){
                val popularidad = if (valor.reproducciones <2000) "Poco popular" else "Más popular"
                println("______________________________________________________________________________________________")
                println("Cancion: ${valor.titulo}, Artista: ${valor.artista}, Reproducciones: ${valor.reproducciones}")
                println("Según la cantidad de reproducciones de esta canción, entra en el rango de $popularidad")
                println("______________________________________________________________________________________________")
            }
        }else{
            println("No hay canciones")
        }
    }
}
fun main(){
    var album = Album("Rap")
    album.agregarCancion("Ke no hay alchohol", "Kase.O", "2003", 2000000)
    album.agregarCancion("A veces", "Al2 El Aldenado", "2013", 1000000)
    album.agregarCancion("Guapo Tarde", "Kase.O", "2015", 1500000)
    album.agregarCancion("Amor Sin Clausulas", "Kase.O", "2015", 3000000)
    album.agregarCancion("Vivir para contarlo", "Violadores del verso", "2002", 8000000)
    while (true) {
        println("Reproductor de musica")
        println("1. Mostrar tipo musica del album")
        println("2. Mostrar canciones del album")
        println("3. Evaluar canciones de poco popular o más popular")
        println("4. Mostrar cancion con más reproduciones")
        println("5. Salir")
        println("Ingrese una opción")
        when(readLine()!!.toString().lowercase()){
            "1" -> {
                println(album.obtenerTipoMusicaAlbum())
            }
            "2" ->{
                album.obtenerCanciones()
            }
            "3" ->{
                album.evaluarPopularidadCancion()
            }
            "4" ->{
                album.mostrarCancionConMasReproducciones()
            }
            "5" ->{
                println("Has salido del programa")
                break
            }
            else -> println("Opcion invalida")
        }
    }

}


