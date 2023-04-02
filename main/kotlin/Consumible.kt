class Consumible {

    /*Costo de productos por tamaño
    Palomitas = popCorn
    Refresco = soda
    Combo = combos
*/
    val popCornPrice = mapOf<String, Double>("C"  to 20.0,
                                        "M" to 30.0,
                                        "G" to 40.0)

    val sodaPrice = mapOf<String, Double>("C"  to 10.0,
                                    "M" to 20.0,
                                    "G" to 25.0)
    val nachosPrice = mapOf<String, Double>("C"  to 30.0,
                                            "M" to 50.0,
                                            "G" to 65.0)


    val combos1Price = mapOf<String, Double>("C"  to 80.0,
                                        "M" to 100.0,
                                        "G" to 120.0)

    val combos2Price = mapOf<String, Double>("C"  to 120.0,
                                        "M" to 160.0,
                                        "G" to 180.0)

   /* Se declara el mapa de productos para relacionar
    el nombre con los precios anteriores. mapOf<String,Map>*/

    val ProductPair = mapOf("PALOMITAS" to popCornPrice,
                            "REFRESCO" to sodaPrice,
                            "NACHOS" to nachosPrice,
                            "COMBO1" to combos1Price,
                            "COMBO2" to combos2Price)


    //Inicio de la lista de compras

    val listaCompras = mutableMapOf<String, Double>()

/*    Funcion que agrega productos a la lista
    con una cadena ingresada busca en el mapa ProductPair
    la existencia del producto, luego pregunta el tamaño
    que se desea comprar. Lo busca en el mapa de cada producto
    y agrega a la lista el nombre y precio del producto*/

    fun agregarProducto(producto:Any){
        println("\n A ingresado $producto\n")
        if( ProductPair.containsKey(producto.toString().toUpperCase())){


                println("¿De que tamaño quiere su producto:  $producto")
                var tamano = readln()?: "Chico"

                var price = ProductPair[producto]?.get(tamano.toUpperCase().get(0).toString())?: 0.0
                println("$producto tamaño:  ${tamano.toUpperCase()}   precio: $price" )

                listaCompras.put("$producto $tamano", price)
                println("Producto: $producto tamaño $tamano agregado\n")


            }else { println("No se reconoce el producto, intente de nuevo\n") }
        println("Algún otro producto?")
    }

    /*Funcion para borrar productos de la lista
    ingresa el nombre del producto <String> en
    la lista de compras para eliminarlo*/


    fun borrarProducto(producto: String){
        listaCompras.remove(producto)
        println("Producto Borrado")
        println("Algún otro producto")
    }




    fun orden(){
       println(" Su pedido es el siguiente... \n")
        for((producto,precio) in listaCompras){
            println("$producto   $ $precio")
        }
    }

    fun imprimirTicket(){
        println("Cines BEDU")
        orden()

        println()
        println("Total ${listaCompras.values}")
    }
}