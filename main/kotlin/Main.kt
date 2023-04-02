fun main(){
    var cadena: String?
    var lectura : Any?
    val pedido = Consumible()

    println("******Bienvenidos a Cine BEDU******\n")
    do{
        println("""
            
            Puede escoger entre nuestros productos
            
            1- Palomitas (Chicas /Medianas /Grandes)
            2- Refresco (Chico /Mediano /Grande)
            3- Nachos    (Chicos / Grandes)
            4- Combo1: Palomitas y Refresco  (Chico /Grande)
            5- Combo2: Palomitas, Refresco y Nachos (Chico/ Grande)
            
            6- Pedido : Para consultar el pedido
            7- Quitar:  Para quitar algún producto
            
            8- Terminar : Para terminar la compra y regresar a la pantalla principal
            
            
                    
            
        """.trimIndent())
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

            when (lectura.toUpperCase()) {
                "PALOMITAS", "REFRESCO", "NACHOS", "COMBO1", "COMBO2" -> pedido.agregarProducto(lectura)
                "PEDIDO" -> {
                    println("\n")
                    pedido.orden()
                }

                "QUITAR" -> {
                    pedido.orden()
                    println("¿Qué producto quiere quitar de su lista?\n...")
                    cadena = readln().toUpperCase()
                    pedido.borrarProducto(cadena)
                }

                "TERMINAR" -> {
                    println("Ha sido un gusto atenderle\n")
                    pedido.imprimirTicket()
                }

                else -> println("Disculpe, no se reconoció el comando, intente de nuevo\n\n")
            }


    }while(lectura != "TERMINAR")
}