/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import javax.swing.JOptionPane;

/**
 *
 * @author grupo 03
 */
public class Proyecto_final {

    public static void main(String[] args) {
        // Declaración de variables
        int aforo, mayores = 0, menores = 0, cantidadMiembros = 0, cantidadPro = 0;
        char masInfoChar = 'c';

        // Solicitar el aforo del local al usuario
        aforo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el aforo del local"));

        // Crear una matriz para almacenar los datos de las personas
        String personas[][] = new String[aforo][5];

        int i = 0;
        do {
            // Solicitar información de una persona
            String nombre, apellido, plan;
            int edad;
            
            String idEnTxt = "(" + (i+1) + ") ";

            nombre = JOptionPane.showInputDialog(idEnTxt + "Ingrese el Nombre del usuario");
            apellido = JOptionPane.showInputDialog(idEnTxt + "Ingrese el Apellido del usuario");

            edad = Integer.parseInt(JOptionPane.showInputDialog(idEnTxt + "Ingrese la Edad del cliente"));

            plan = JOptionPane.showInputDialog(idEnTxt + "Ingrese el Plan escogido (\"miembro\", \"pro\")");

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

        boolean hayError;
        do {
            String masInfo = JOptionPane.showInputDialog("Para ver estadísticas, use 'e' \nPara buscar un usuario, use 'b' \nPara no hacer nada, use 'c'");
                if (
                    masInfo.length() != 1 || 
                    (!masInfo.equals("b") && !masInfo.equals("e") && !masInfo.equals("c"))
                ) {
                hayError = true;
            } else {
                hayError = false;
                masInfoChar = masInfo.charAt(0);
                
                if (masInfoChar == 'e') {
                    System.out.println();
                    System.out.println("Cantidad de personas mayores de edad: " + mayores);
                    System.out.println("Cantidad de personas menores de edad: " + menores);
                    System.out.println("Cantidad de personas con plan \"miembro\": " + cantidadMiembros);
                    System.out.println("Cantidad de personas con plan \"pro\": " + cantidadPro);   
                }

                if (masInfoChar == 'b') {
                    String opcionBusqueda = JOptionPane.showInputDialog("Ingrese el criterio de búsqueda:\n1. ID\n2. Nombre");

                    switch (opcionBusqueda) {
                        case "1":
                            {
                                String idBusqueda = JOptionPane.showInputDialog("Ingrese el ID a buscar:");
                                boolean encontrado = false;
                                for (int k = 0; k < aforo; k++) {
                                    if (personas[k][0].equals(idBusqueda)) {
                                        System.out.println();
                                        System.out.println("Usuario encontrado:");
                                        System.out.println("ID: " + personas[k][0]);
                                        System.out.println("Nombre: " + personas[k][1]);
                                        System.out.println("Apellido: " + personas[k][2]);
                                        System.out.println("Edad: " + personas[k][3]);
                                        System.out.println("Plan: " + personas[k][4]);
                                        encontrado = true;
                                        break;
                                    }
                                }   if (!encontrado) {
                                    System.out.println();
                                    System.out.println("No se encontró ningún usuario con el ID proporcionado.");
                                }   break;
                            }
                        case "2":
                            {
                                String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre a buscar:");
                                boolean encontrado = false;
                                for (int k = 0; k < aforo; k++) {
                                    if (personas[k][1].equals(nombreBusqueda)) {
                                        System.out.println();
                                        System.out.println("Usuario encontrado:");
                                        System.out.println("ID: " + personas[k][0]);
                                        System.out.println("Nombre: " + personas[k][1]);
                                        System.out.println("Apellido: " + personas[k][2]);
                                        System.out.println("Edad: " + personas[k][3]);
                                        System.out.println("Plan: " + personas[k][4]);
                                        encontrado = true;
                                    }
                                }   if (!encontrado) {
                                    System.out.println();
                                    System.out.println("No se encontró ningún usuario con el nombre proporcionado.");
                                }   break;
                            }
                        default:
                            System.out.println();
                            System.out.println("Opción de búsqueda inválida.");
                            break;
                    }
                }
            }
        } while (masInfoChar != 'c' || hayError);
        
        System.out.println();
        System.out.println("¡Gracias por usar nuestro software!");
        System.out.println("""
                           Lovera Freitas, Douglas Alexander\t | U21206109
                           Ishuiza Fernandez, Angelo Amador\t | U21204754 
                           Farfan Gonzales, Pelaggio Eduardo\t | U21219159
                           Neyra Cruz, Rodrigo Jesús\t | U21226678
                           """);
    }
}
