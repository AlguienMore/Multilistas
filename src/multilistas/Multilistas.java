/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilistas;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author JuanS
 */
public class Multilistas {

    /**
     * @param args the command line arguments
     */
    static File file;
    static FileWriter fw;
    static Nodo root = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opc;

        do {
            System.out.println("Que desea hacer?");
            System.out.println("0..Crear Lista principal");
            System.out.println("1..Insertar nodo en lista principal"); //done
//            System.out.println("2..Insertar nodo en sublista"); //Dada una posicion de un nodo (Obviamente)
//            System.out.println("3..Buscar un nodo en lista principal"); //Same from above
//            System.out.println("4..Buscar un nodo en sublistas");
            System.out.println("5..Mostrar Lista");
            System.out.println("6..Salir");
//          System.out.println("7. Eliminar una lista");
//          System.out.println("8. Eliminar una sublista");
//          System.out.println("9. ");
            opc = sc.nextInt();
            switch (opc) {
                case 0:
                    createList();
                    break;
                case 1:
                    insertarNodo();
                    break;
                case 5:
                    showList();
                    break;
            }
        } while (opc != 6);
    }

    static void createList() { // opc 0
        int n;
        int info, opc;
        Nodo p = root;
        do {
            if (root == null) {
                System.out.println("Digite la informacion de el Nodo inicial");
                info = sc.nextInt();
                root = new Nodo(null, null, info);
                p = root;
            }
            System.out.println("1..Insertar Nodo principal");
            System.out.println("2..Insertar Nodo en sublista");
            System.out.println("0..Salir");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Digite la informacion de el nodo");
                    info = sc.nextInt();
                    Nodo q = new Nodo(null, null, info);
                    p.setLink(q);
                    p = q;
                    break;
                case 2:
                    System.out.println("Digite la informacion de el nodo que contiene la sublista");
                    info = sc.nextInt();
                    Nodo objetivo = busqueda(info);
                    if (objetivo != null) {
                        System.out.println("Encontrado, digite la informacion de el nodo que desea ingresar en el nodo " + info);
                        info = sc.nextInt();
                        Subnodo z = new Subnodo(info, null);
                        if (objetivo.getSubroot() == null) {
                            objetivo.setSubroot(z);
                        } else {
                            Subnodo w = objetivo.getSubroot();
                            while (w.getLink() != null) {
                                w = w.getLink();
                            }
                            w.setLink(z);
                        }
                        System.out.println("Agregado " + z.getInfo() + " en " + objetivo.getInfo());
                    } else {
                        System.out.println("No se encontro el nodo con esa informacion");
                    }
                    break;
            }
        } while (opc != 0);
    }

    static void insertarNodo() { // opc 1
        int info, buscar;
        Nodo synthesisObjective, semaris, aux = null;
        System.out.println("Insertar nodo en la posicion: ");
        buscar = sc.nextInt();

        synthesisObjective = busquedak(buscar);
        if (buscar >= 0) {
            aux = busquedak(buscar - 1);
        }
        System.out.println("Digite información: ");
        info = sc.nextInt();

        if (root == synthesisObjective) {
            semaris = new Nodo(root, null, info);
            root = semaris;

        } else {
            semaris = new Nodo(synthesisObjective, null, info);
            aux.setLink(semaris);
            
        }
    }

    static Nodo busquedak(int numero) {
        int aux = 0;
        Nodo p = root;
        while (p != null) {

            if (aux == numero) {

                return p;

            }

            p = p.getLink();
            aux++;

        }
        return null;
    }

    static Nodo busqueda(int info) {
        Nodo p = root;
        while (p != null) {
            if (p.getInfo() == info) {
                return p;
            }
            p = p.getLink();
        }
        return null;
    }

    static void showList() {
        System.out.println("ShowList");
        if (root != null) {
            Nodo p = root;
            while (p != null) {
                System.out.println(p.getInfo());
                if (p.getSubroot() != null) {
                    Subnodo z = p.getSubroot();
                    while (z != null) {
                        System.out.println("-->" + z.getInfo());
                        z = z.getLink();
                    }
                }
                p = p.getLink();
            }
        } else {
            System.out.println("No hay lista que mostrar");
        }
    }

}
