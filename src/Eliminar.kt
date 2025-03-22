data class Producto(val id: Int, val nombre: String, val precio: Double)

class Carrito {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
        println("Producto agregado:")
    }

    fun eliminarProducto(id: Int) {
        val productoAEliminar = productos.find { it.id == id }
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar)
            println("Producto eliminado: ")
        } else {2
            println("Producto no encontrado en el carrito.")
        }
    }

    fun mostrarCarrito() {
        if (productos.isEmpty()) {
            println("El carrito está vacío.")
        } else {
            println("Carrito de compras:")
            productos.forEach { println("${it.id} - ${it.nombre} - $${it.precio}") }
        }
    }
}

fun main() {
    val carrito = Carrito()

    val producto1 = Producto()
    val producto2 = Producto()
    val producto3 = Producto()

    carrito.agregarProducto(producto1)
    carrito.agregarProducto(producto2)
    carrito.agregarProducto(producto3)

    carrito.mostrarCarrito()

    println("\nEliminando producto con ID ")
    carrito.eliminarProducto(2)

    carrito.vercarrito()
}