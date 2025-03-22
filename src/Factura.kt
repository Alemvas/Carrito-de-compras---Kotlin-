class Factura {
    fun generarFactura(carrito: Carrito) {
        val productos = carrito.obtenerProductos()
        if (productos.isEmpty()) {
            println("No hay productos para facturar.")
            return
        }
        
        println("\n🧾 **FACTURA DE COMPRA**")
        var subtotal = 0.0
        productos.forEach { (producto, cantidad) ->
            val totalProducto = cantidad * producto.precio
            println("${producto.nombre} - $cantidad x \$${producto.precio} = \$${totalProducto}")
            subtotal += totalProducto
        }

        val impuesto = subtotal * 0.13  // 13% de IVA
        val total = subtotal + impuesto
        println("\nSubtotal: \$${subtotal}")
        println("IVA (13%): \$${impuesto}")
        println("💵 Total a pagar: \$${total}\n")
    }
}
