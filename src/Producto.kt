class Producto {

    var codigo: String = ""
    var nombre: String = ""
    var precio: Double = 0.0
    var cantidadStock: Int = 0

    constructor()

    constructor(codigo: String, nombre: String, precio: Double, cantidadStock: Int) {
        this.codigo = codigo
        this.nombre = nombre
        this.precio = precio
        this.cantidadStock = cantidadStock
    }

    fun venProd(cantidad: Int) {
        if (cantidad <= cantidadStock) {
            cantidadStock -= cantidad
            println("Se vendieron $cantidad unidades de $nombre.")
        } else {
            println("Stock insuficiente para vender $cantidad unidades de $nombre.")
        }
    }

    fun repStock(cantidad: Int) {
        cantidadStock += cantidad
        println("Se repusieron $cantidad unidades de $nombre.")
    }

    fun aplDesc() {
        precio -= precio * 0.02
        println("Se aplico descuento del 2% al producto $nombre. Nuevo precio: $precio")
    }

    fun aumPrecio() {
        precio += precio * 0.06
        println("Se aumento el precio del producto $nombre en un 6%. Nuevo precio: $precio")
    }

    fun mostrarInfo() {
        println("Codigo: $codigo, Nombre: $nombre, Precio: $precio, Stock: $cantidadStock")
    }

    fun calValInven(): Double {
        return precio * cantidadStock
    }

    override fun toString(): String {
        return "Producto(codigo='$codigo', nombre='$nombre', precio=$precio, cantidadStock=$cantidadStock)"
    }
}