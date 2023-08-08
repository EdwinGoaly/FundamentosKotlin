package com.EdwinGoaly.fundamentoskotlin.Reto5

/* Definimos los atributos directamente en la declaración de la clase (constructor primario).
 Es una forma alternativa de crear el método constructor.
 Los atributos numCelular y clave los declaramos de tipo Val debido a que serán valores inmutables.
*/

class Nequi(private val numCelular: String, private val clave: String) {
    //Definimos lo atributos de tipo Var (mutables) de la cuenta nequi
    private var saldo: Double = 4500.0
    private var intentos: Int = 4

    //Creamos un método para mostrar el saldo
    fun mostrarSaldo(){
        println("El saldo actual es de: $saldo pesos")
    }

    //Creamos el método para validar los datos que van a ser ingresados por el usuario y poder contrastarlos con los de la cuenta
    fun validarInicio(): Boolean{
        //Si el usuario no ingresa los datos correctos después de 4 intentos, finalizará el programa por falta de intentos
        while (intentos > 0){
            //Solicitamos los datos de la cuenta y capturamos
            println("Ingrese el número de célular para ingresar")
            val numCelular = readLine()!!.toString()
            println("Ingrese la clave para ingresar")
            val clave = readLine()!!.toString()
            // Si los datos concuerdan, el usuario ya podrá acceder a su cuenta para realizar las distintas operaciones
            if (numCelular == this.numCelular && clave == this.clave) {
                return true
            }else{
                //Si lo datos no concuerdan, se le íran quitando intentos y mostrando el mensaje de los campos que no coinciden
                intentos --
                if (numCelular != this.numCelular ){
                    println("El numero de celular no es correcto")
                }
                if (clave != this.clave){
                    println("La clave de la cuenta no es correcta")
                }
                println("tienes $intentos intentos restantes")
            }
        }
        // Si se acaban los intentos, el usuario ya no podrá ingresar a su cuenta y finaliza el programa
        println("Se acabaron los intentos, vuelve más tarde")
        return false
    }

    //Creamos un método privado (visible solo para la clase) para generar un codigo de 6 dígitos de forma aleatoria
    private fun generarCodigoRetiro(): Int {
        return (100000..999999).random()
    }

    //Creamos un método para sacar dinero de la cuenta
    fun sacar(){
        //Mostramos las dos opciones y solicitamos la opción
        println("Tienes 2 opciones: \n 1. Cajero \n 2. Punto físico")
        println("Ingresa la opción")

        //Capturamos la opción
        var opcion: Int = readLine()!!.toInt()

        //Encerramos al usuario en un bucle hasta que ingrese una opción válida
        while (opcion !in 1..2){
            println("Opcion incorrecta, digita una que sea válida para continuar")
            opcion = readLine()!!.toInt()
        }
        // Utilizamos un if ternario para que, dependiendo de la opción, guardemos la opcion ("Cajero" o "Punto Físico")
        val lugarRetiro = if (opcion == 1) "Cajero" else "Punto físico"

        //Si el saldo es menor a 2000, no podrá retirar
        if(this.saldo < 2000){
            println("No te alcanza")
        }else{
            // Si, de lo contrario, el saldo es mayor a 2000, podrá retirar el usuario
            //Mostramos la opción que escogió el usuario
            println("Usted ha escogido retirar en un $lugarRetiro")

            //Solicitamos el monto a retirar
            println("¿Cuánto desea retirar?")

            //Capturamos el monto
            var retirar: Double = readLine()!!.toDouble()

            //Si el monto es mayor al saldo actual, se le encerrará en un bucle hasta que ingrese un monto válido
            while(retirar > this.saldo){
                println("El dinero que usted quiere retirar es mayor al saldo actual. \n Por favor ingrese una cantidad correcta retirar ")
                retirar = readLine()!!.toDouble()
            }

            //Si el monto es menor 0 o 0, se le encerrará en un bucle hasta que ingrese un monto válido
            while(retirar <= 0){
                println("El dinero que usted quiere retirar es 0 o menor a 0 \n Por favor ingrese una cantidad correcta para retirar")
                retirar = readLine()!!.toDouble()
            }

            //Restamos el monto a retirar al saldo actual de la cuenta
            this.saldo -= retirar

            /*Mostramos el saldo de la cuenta y el monto a retirar y mostramos el codigo (invcocando el método para
            generar el código de retiro)*/
            println("El monto a retirar es de $retirar, su codigo para retirar es ${generarCodigoRetiro()}")
            println("Saldo actual: $saldo")
        }

    }

    //Creamos el método para enviar el dinero
    fun enviar(){
        //Solicitamos el teléfono al cual se le enviará el dinero, y el dinero a envíar
        println("Ingrese el número de teléfono al que desea enviar dinero")
        //Capturamos los datos
        val numCelularEnviar: String = readLine()!!.toString()
        println("Ingrese la cantidad de dinero a enviar")
        var enviar: Double = readLine()!!.toDouble()

        //Si el monto a envíar es mayor al saldo actual, se encerrará al usuario en un ciclo hasta que ingrese un monto válido
        while(enviar > this.saldo){
            println("No es posible enviar el dinero, la cantidad a envíar excede el saldo actual. Ingrese una cantidad adecuada")
            enviar = readLine()!!.toDouble()
        }

        //Mostramos un mensaje de la cantidad enviada y el teléfono al cual se envío el dinero
        println("Se ha enviado $enviar pesos al número $numCelularEnviar")

        //Restamos el monto que fue envíado y mostramos el saldo actual
        this.saldo -= enviar
        println("Saldo actual: $saldo")
    }

    //Creamos el método para hacer recargar a la cuenta
    fun recargar(){

        //Solicitamos el valor de la recarga
        println("Ingrese el valor a recargar")

        //Capturamos el valor de la recarga
        val recargar: Double = readLine()!!.toDouble()

        //Encerramos al usuario en un ciclo do-while para evaluar al final si la opción de confirmación es válida
        //Si la confirmación no es 1 o 2, se repetirá el ciclo hasta que ingrese una de estas
        do {
            println("¿Desea confirmar la recarga? \n 1. Si \n 2. No")
            val confirmacionRecar: Int = readLine()!!.toInt()

            /*Si la confimarción de la recarga es 1 (Sí), mostramos que la recarga fue exitoso y sumamos la recarga
            al saldo actual de la cuenta*/
            if(confirmacionRecar == 1){
                println("La recarga se ha realizado con exito")
                this.saldo += recargar
            } else{
                println("Usted ha decidido no confimar la recarga")
            }
        }while(confirmacionRecar != 1 && confirmacionRecar !=2)
        //Mostramos el saldo actual de la cuenta
        println("Saldo actual: $saldo")
    }
}

fun main() {
    val numCelular = "3134033857" //  Num. Célular para acceder
    val clave = "8989" // Clave para acceder
    // Creamos la instancia de la clase
    val nequi = Nequi(numCelular, clave)
    // Declaramos una variable para controlar el ciclo
    var salir = false

    /*Validamos el inicio mediante la invocación del metodo validarInicio para asegurar que los datos ingresados concuerden
    * con los datos establecidos. Esta funcion retornará un valor Boolean, si es verdadero, el usuario podrá
    * ingresar, de lo contrario, se le restará intentos por cada vez que los datos no concuerden. Una vez que
    * los intentos lleguen a 0, se finalizará el programa y se le mostrará un mensaje adecuado*/

    if (nequi.validarInicio()){
        //Utilizamos un ciclo do-while para repetir la opciones hasta que el usuario decida salir del programa Nequi
        do {
            // Invocamos el método para mostrar el saldo
            nequi.mostrarSaldo()
            // Mostramos la opciones
            println("Seleccione una opción:")
            println("1. Sacar dinero")
            println("2. Enviar dinero")
            println("3. Recargar")
            println("4. Salir")

            // Capturamos la opcion
            val opcion = readLine()!!.toInt()

            // Validamos la opción ingresada e invocamos el método correspondiente (si es el caso)
            when(opcion){
                1 -> {
                    nequi.sacar()
                }
                2 -> {
                    nequi.enviar()
                }
                3 -> {
                    nequi.recargar()
                }
                4 -> {
                    println("Has decido salir de la cuenta Nequi")
                    salir = true
                }
                // Si ingresa una opción incorrecta, se le mostrará un mensaje
                else -> println("Opcion incorrecta")
            }
            // Si la variable Boolean es verdadera (si es que el usuario eligió la opción 4) se finalizará el programa
        }while(!salir)
    }
    println("Fin del prgrama")
}
