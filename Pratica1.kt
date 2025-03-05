import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

fun main() {
    var opcion: Int
    do {
        // Menu
        println("Menu:")
        println("1. Sumar tres numeros")
        println("2. Ingresar nombre completo")
        println("3. Calcular tiempo vivido")
        println("4. Salir")
        print("Seleccione una opcion: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> sumarTresNumeros()
            2 -> ingresarNombreCompleto()
            3 -> calcularTiempoVivido()
            4 -> println("Saliendo del programa...")
            else -> println("Opcion no valida. Intente de nuevo.")
        }
    } while (opcion != 4)
}

fun sumarTresNumeros() {
    println("Ingrese tres numeros:")
    print("Numero 1: ")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0
    print("Numero 2: ")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0
    print("Numero 3: ")
    val num3 = readLine()?.toDoubleOrNull() ?: 0.0

    val suma = num1 + num2 + num3
    println("La suma de los tres numeros es: $suma")
}

fun ingresarNombreCompleto() {
    println("Ingrese su nombre completo:")
    val nombreCompleto = readLine()
    println("Nombre completo ingresado: $nombreCompleto")
}

fun calcularTiempoVivido() {
    println("Ingrese su fecha de nacimiento (AAAA-MM-DD):")
    val fechaNacimientoStr = readLine()

    try {
        val fechaNacimiento = LocalDate.parse(fechaNacimientoStr)
        val fechaActual = LocalDate.now()

        // Calcular el periodo entre la fecha de nacimiento y la fecha actual
        val periodo = Period.between(fechaNacimiento, fechaActual)
        val diasVividos = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)
        val horasVividas = diasVividos * 24
        val minutosVividos = horasVividas * 60
        val segundosVividos = minutosVividos * 60

        println("Tiempo vivido:")
        println("Anios: ${periodo.years}")
        println("Meses: ${periodo.months}")
        println("Dias: ${periodo.days}")
        println("Horas: $horasVividas")
        println("Minutos: $minutosVividos")
        println("Segundos: $segundosVividos")
    } catch (e: Exception) {
        println("Error: Formato de fecha no valido. Use el formato AAAA-MM-DD.")
    }
}
