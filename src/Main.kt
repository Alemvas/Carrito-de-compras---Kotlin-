fun main() {
    val tienda = Tienda()
    val carrito = Carrito()
    val factura = Factura()

    while (true) {
        println("\n**Menú Principal**")
        println("1️ Ver productos")
        println("2️ Agregar producto al carrito")
        println("3️ Eliminar producto del carrito")
        println("4️ Ver carrito")
        println("5️ Finalizar compra")
        println("6️ Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> tienda.mostrarProductos()
            2 -> {
                tienda.mostrarProductos()
                print("Ingrese el ID del producto: ")
                val id = readLine()?.toIntOrNull()
                val producto = id?.let { tienda.obtenerProductoPorId(it) }

                if (producto != null) {
                    print("Ingrese la cantidad: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                    carrito.agregarProducto(producto, cantidad)
                } else {
                    println("⚠ Producto no encontrado.")
                }
            }
            3 -> {
                carrito.mostrarCarrito()
                print("Ingrese el nombre del producto a eliminar: ")
                val nombre = readLine()
                if (!nombre.isNullOrBlank()) {
                    carrito.eliminarProductoPorNombre(nombre)
                } else {
                    println("Nombre inválido.")
                }
            }
            4 -> carrito.mostrarCarrito()
            5 -> {
                factura.generarFactura(carrito)
                println("Gracias por su compra.")
                break
            }
            6 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción inválida, intente de nuevo.")
        }
    }
}
