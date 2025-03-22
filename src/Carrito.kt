class Carrito {
    private val productosEnCarrito = mutableMapOf<Producto, Int>()

    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (producto.cantidadDisponible >= cantidad) {
            productosEnCarrito[producto] = productosEnCarrito.getOrDefault(producto, 0) + cantidad
            producto.cantidadDisponible -= cantidad
            println("✅ $cantidad x ${producto.nombre} agregado al carrito.")
        } else {
            println("No hay suficiente stock de ${producto.nombre}.")
        }
    }

    fun eliminarProducto(producto: Producto) {
        if (productosEnCarrito.containsKey(producto)) {
            producto.cantidadDisponible += productosEnCarrito[producto]!!
            productosEnCarrito.remove(producto)
            println("${producto.nombre} eliminado del carrito.")
        } else {
            println("El producto no está en el carrito.")
        }
    }

    fun mostrarCarrito() {
        if (productosEnCarrito.isEmpty()) {
            println("El carrito está vacío.")
            return
        }
        println("\n🛍 Productos en el carrito:")
        var total = 0.0
        productosEnCarrito.forEach { (producto, cantidad) ->
            val totalProducto = cantidad * producto.precio
            println("${producto.nombre} - $cantidad x \$${producto.precio} = \$${totalProducto}")
            total += totalProducto
        }
        println("Total: \$${total}\n")
    }

    fun obtenerProductos(): Map<Producto, Int> = productosEnCarrito.toMap()
}
