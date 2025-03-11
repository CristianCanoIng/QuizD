fun main() {
    val listaProductos = mutableListOf<Producto>()

    while (true) {
        println("""
            
                         __,                      ,__
                      __/==+\  MENU DE OPCIONES  /+==\__
                        "  "`   ===============   '"  "
            
        """.trimIndent())
        println("[1] Crear producto nuevo")
        println("[2] Vender producto")
        println("[3] Reponer stock")
        println("[4] Aplicar descuento del 2% ")
        println("[5] Aumentar precio al 6% ")
        println("[6] Mostrar informacion de todos los productos")
        println("[7] Calcular valor total en inventario")
        println("[8] Eliminar producto por codigo")
        println("[9] Salir")

        print("[] Seleccione una de las opciones: ")
        var opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("[] ¿Cuantos productos desea ingresar?:")
                var n = readln().toInt()

                do {
                    var seguir : String = "false"
                    for (i in 1..n) {
                        println("+ Ingrese el codigo del producto:")
                        var codigo = readln()
                        println("+ Ingrese el nombre del producto:")
                        var nombre = readln()
                        println("+ Ingrese el precio del producto:")
                        var precio = readln().toDouble()
                        println("+ Ingrese la cantidad en stock:")
                        var stock = readln().toInt()
                        var producto = Producto(codigo, nombre, precio, stock)
                        listaProductos.add(producto)
                        println("Producto creado: $producto")

                        println("¿Desea agregar otro producto? true/false: ")
                        seguir = readln()

                        if(seguir=="false"){
                            break
                        }else{
                            seguir = "true"
                        }
                    }
                }while(seguir == "true")
            }
            2 -> {
                println("[] Ingrese el codigo del producto a vender:")
                val codigo = readln()
                val producto = listaProductos.find { it.codigo == codigo }
                if (producto != null) {
                    println("+ Ingrese la cantidad a vender:")
                    val cantidad = readln().toInt()
                    producto.venProd(cantidad)
                } else {
                    println("Codigo de producto no encontrado")
                }
            }
            3 -> {
                println("[] Ingrese el codigo del producto a reponer:")
                val codigo = readln()
                val producto = listaProductos.find { it.codigo == codigo }
                if (producto != null) {
                    println("+ Ingrese la cantidad a reponer:")
                    val cantidad = readln().toInt()
                    producto.repStock(cantidad)
                } else {
                    println("Codigo de producto no encontrado")
                }
            }
            4 -> {
                println("[] Ingrese el codigo del producto para aplicar descuento:")
                val codigo = readln()
                val producto = listaProductos.find { it.codigo == codigo }
                if (producto != null) {
                    producto.aplDesc()
                } else {
                    println("Codigo de producto no encontrado")
                }
            }
            5 -> {
                println("[] Ingrese el codigo del producto para aumentar precio:")
                val codigo = readln()
                val producto = listaProductos.find { it.codigo == codigo }
                if (producto != null) {
                    producto.aumPrecio()
                } else {
                    println("Codigo de producto no encontrado")
                }
            }
            6 -> {
                if (listaProductos.isEmpty()) {
                    println("No hay productos para mostrar.")
                } else {
                    println("----- Informacion de  los productos -----\n")
                    listaProductos.forEach { it.mostrarInfo() }
                }
            }
            7 -> {
                if (listaProductos.isEmpty()) {
                    println("No hay productos para calcular inventario.")
                } else {
                    val totalInventario = listaProductos.sumOf { it.calValInven() }
                    println("Valor total en inventario: $totalInventario")
                }
            }
            8 -> {
                println("[] Ingrese el codigo del producto a eliminar:")
                val codigo = readLine() ?: ""
                val producto = listaProductos.find { it.codigo == codigo }
                if (producto != null) {
                    listaProductos.remove(producto)
                    println("Producto con codigo $codigo eliminado.")
                } else {
                    println("Codigo de producto no encontrado")
                }
            }
            9 -> {
                println("Chao")
                break
            }
            else -> {
                println("Opcion no existente, intente nuevamente.")
            }
        }
        println()
    }
}