/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import javax.swing.JOptionPane;

/**
 *
 * @author https://doulovera.com
 */
public class Proyecto_final {

    public static void main(String[] args) {
        // Declaración de variables
        int aforo, mayores = 0, menores = 0, cantidadMiembros = 0, cantidadPro = 0;

        // Solicitar el aforo del local al usuario
        aforo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el aforo del local"));

        // Crear una matriz para almacenar los datos de las personas
        String personas[][] = new String[aforo][5];

        int i = 0;
        do {
            // Solicitar información de una persona
            String nombre, apellido, plan;
            int edad;

            nombre = JOptionPane.showInputDialog("Ingrese el Nombre del usuario");
            apellido = JOptionPane.showInputDialog("Ingrese el Apellido del usuario");

            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Edad del cliente"));

            plan = JOptionPane.showInputDialog("Ingrese el Plan escogido (\"miembro\", \"pro\")");

            // Verificar que el plan sea "miembro" o "pro"
            if (!plan.equals("miembro") && !plan.equals("pro")) {
                do {
                    plan = JOptionPane.showInputDialog("Ingrese el Plan escogido correctamente: \"miembro\", \"pro\"");
                } while (!plan.equals("miembro") && !plan.equals("pro"));
            }

            // Almacenar los datos de la persona en la matriz
            personas[i][0] = String.valueOf(i + 1); // ID
            personas[i][1] = nombre;
            personas[i][2] = apellido;
            personas[i][3] = String.valueOf(edad);
            personas[i][4] = plan;

            i++;
        } while (i < aforo);

        // Contar el número de personas mayores y menores de edad, y el número de personas con el plan "miembro" o "pro"
        for (int j = 0; j < aforo; j++) {
            if (Integer.parseInt(personas[j][3]) >= 18) {
                mayores++;
            } else if (Integer.parseInt(personas[j][3]) < 18) {
                menores++;
            }

            if (personas[j][4].equals("miembro")) {
                cantidadMiembros++;
            } else if (personas[j][4].equals("pro")) {
                cantidadPro++;
            }
        }

        // Imprimir los datos de las personas almacenadas en la matriz
        System.out.println("Id | Nombre | Apellido | Edad | Plan");
        for (int k = 0; k < aforo; k++) {
            System.out.print(personas[k][0] + "\t");
            System.out.print(personas[k][1] + "\t");
            System.out.print(personas[k][2] + "\t");
            System.out.print(personas[k][3] + "\t");
            System.out.println(personas[k][4]);
        }

        // Imprimir las estadísticas de las personas
        System.out.println("Cantidad de personas mayores de edad: " + mayores);
        System.out.println("Cantidad de personas menores de edad: " + menores);
        System.out.println("Cantidad de personas con plan \"miembro\": " + cantidadMiembros);
        System.out.println("Cantidad de personas con plan \"pro\": " + cantidadPro);
    }
}

