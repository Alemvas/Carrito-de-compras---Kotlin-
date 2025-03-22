class Tienda {
    val productos = mutableListOf(
        Producto(1, "Laptop", 750.0, 10),
        Producto(2, "Mouse", 25.0, 50),
        Producto(3, "Teclado", 40.0, 30),
        Producto(4, "Monitor", 200.0, 15)
    )

    fun mostrarProductos() {
        println("\n**PRODUCTOS DISPONIBLES**")
        productos.forEach { println("${it.id}. ${it.nombre} - \$${it.precio} (Stock: ${it.cantidadDisponible})") }
    }

    fun obtenerProductoPorId(id: Int): Producto? {
        return productos.find { it.id == id }
    }
}
