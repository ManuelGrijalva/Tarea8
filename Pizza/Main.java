package Pizza;

import especialidades.PizzaHawaiana;
import especialidades.PizzaItaliana;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la Pizzería");
        System.out.println("Por favor, seleccione una opción (escriba el numero y luego presione enter):");
        System.out.println("1. Pizza Personalizada");
        System.out.println("2. Pizza Italiana");
        System.out.println("3. Pizza Hawaiana");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                // Pizza personalizada
                Pizza.Tamaño tamañoPizzaPersonalizada = seleccionarTamaño(scanner);
                Pizza pizzaPersonalizada = crearPizzaPersonalizada(tamañoPizzaPersonalizada, scanner);
                prepararYMostrarPizza(pizzaPersonalizada);
                break;
            case 2:
                // Pizza Italiana
                Pizza.Tamaño tamañoPizzaItaliana = seleccionarTamaño(scanner);
                Pizza pizzaItaliana = new PizzaItaliana("Pizza Italiana", tamañoPizzaItaliana);
                prepararYMostrarPizza(pizzaItaliana);
                break;
            case 3:
                // Pizza Hawaiana
                Pizza.Tamaño tamañoPizzaHawaiana = seleccionarTamaño(scanner);
                Pizza pizzaHawaiana = new PizzaHawaiana("Pizza Hawaiana", tamañoPizzaHawaiana);
                prepararYMostrarPizza(pizzaHawaiana);
                break;
            default:
                System.out.println("Selección no válida. Saliendo del programa.");
                break;
        }

        scanner.close();
    }

    private static Pizza.Tamaño seleccionarTamaño(Scanner scanner) {
        System.out.println("Por favor, seleccione el tamaño de la pizza (escriba el numero y luego presione enter):");
        System.out.println("1. Pequeña");
        System.out.println("2. Mediana");
        System.out.println("3. Grande");

        int tamañoSeleccionado = scanner.nextInt();

        switch (tamañoSeleccionado) {
            case 1:
                return Pizza.Tamaño.PEQUEÑA;
            case 2:
                return Pizza.Tamaño.MEDIANA;
            case 3:
                return Pizza.Tamaño.GRANDE;
            default:
                System.out.println("Selección de tamaño no válida, se usará tamaño predeterminado (Pequeña).");
                return Pizza.Tamaño.PEQUEÑA;
        }
    }

    private static Pizza crearPizzaPersonalizada(Pizza.Tamaño tamañoPizza, Scanner scanner) {
        Pizza pizza = new Pizza("Pizza Personalizada", tamañoPizza);
        boolean continuarAñadiendoIngredientes = true;

        while (continuarAñadiendoIngredientes) {
            System.out.println("Por favor, seleccione un ingrediente para agregar (escriba el numero) y luego presione enter:");
            System.out.println("1. Tomate");
            System.out.println("2. Mozzarella");
            System.out.println("3. Albahaca");
            System.out.println("4. Pepperoni");
            System.out.println("5. Jamón");
            System.out.println("6. Piña");
            System.out.println("7. Champiñones");
            System.out.println("8. Aceitunas");
            System.out.println("9. Salchichas");
            System.out.println("10. Cebolla");
            System.out.println("11. escriba este numero cuando aya terminado de agregar los ingredientes que desea(y presione enter)");

            int opcionIngrediente = scanner.nextInt();

            switch (opcionIngrediente) {
                case 1:
                    pizza.agregarIngrediente(new Topping("Tomate", 5));
                    break;
                case 2:
                    pizza.agregarIngrediente(new Topping("Mozzarella", 4));
                    break;
                case 3:
                    pizza.agregarIngrediente(new Topping("Albahaca", 3));
                    break;
                case 4:
                    pizza.agregarIngrediente(new Topping("Pepperoni", 6));
                    break;
                case 5:
                    pizza.agregarIngrediente(new Topping("Jamón", 7));
                    break;
                case 6:
                    pizza.agregarIngrediente(new Topping("Piña", 6));
                    break;
                case 7:
                    pizza.agregarIngrediente(new Topping("Champiñones", 4));
                    break;
                case 8:
                    pizza.agregarIngrediente(new Topping("Aceitunas", 4));
                    break;
                case 9:
                    pizza.agregarIngrediente(new Topping("Salchichas", 5));
                    break;
                case 10:
                    pizza.agregarIngrediente(new Topping("Cebolla", 3));
                    break;
                case 11:
                    continuarAñadiendoIngredientes = false;
                    break;
                default:
                    System.out.println("Selección de ingrediente no válida. Intente de nuevo.");
                    break;
            }
        }
        return pizza;
    }

    private static void prepararYMostrarPizza(Pizza pizza) {
        System.out.println("Preparando la pizza...");
        pizza.preparar();
        System.out.println("Precio de la pizza: Q" + pizza.getPrecioPizza());
    }
}
