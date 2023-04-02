fun main(){

    //objeto pedido es de la clase Consumible
    val pedido = Consumible()


    //Impresion de pantalla informativa
    println("******Bienvenidos a Cine BEDU******\n")
    do{
        println("""
            
            Puede escoger entre nuestros productos
            
            (Todos en Chico/Mediano/Grande)
            
            1- Palomitas 
            2- Refresco 
            3- Nachos   
            4- Combo1: Palomitas y Refresco  
            5- Combo2: Palomitas, Refresco y Nachos 
            
            ____________________________________________
            
            6- Pedido : Para consultar el pedido
            7- Quitar:  Para quitar algún producto
            
            ____________________________________________
            
            8- Terminar : Para terminar la compra y regresar a la pantalla principal
                                      
            
        """.trimIndent())

        /*Lectura y adecuación del dato leido
                Si es un número que puede volverse entero, lo convierte en una cadena adecuada
                para el funcionamiento del siguiente when
                Si no se puede volver entero, lo vuelve cadena*/
        var lectura =  readln()
        if (lectura.toIntOrNull() != null){

            when(lectura.toInt()){
                1-> lectura = "PALOMITAS"
                2-> lectura = "REFRESCO"
                3-> lectura = "NACHOS"
                4-> lectura = "COMBO1"
                5-> lectura = "COMBO2"
                6-> lectura = "PEDIDO"
                7-> lectura = "QUITAR"
                8-> lectura = "TERMINAR"
            }
        }else{lectura.toString()}
            lectura = lectura.toUpperCase()
            when (lectura) {
                "PALOMITAS", "REFRESCO", "NACHOS", "COMBO1", "COMBO2" -> pedido.agregarProducto(lectura)
                "PEDIDO" -> {
                    println("\n")
                    pedido.orden()
                }

                "QUITAR" -> {
                    pedido.orden()
                    println("¿Qué producto quiere quitar de su lista?\n...")
                    println("Ingrese el número correspondiente")
                    var indice = readln().toInt()

                    pedido.borrarProducto(indice)
                }

                "TERMINAR" -> {
                    println("Ha sido un gusto atenderle\n")
                    pedido.totalCompraTienda()
                }

                else -> println("Disculpe, no se reconoció el comando, intente de nuevo\n\n")
            }


    }while(lectura != "TERMINAR")
}