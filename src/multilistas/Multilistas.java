/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilistas;

import java.util.Scanner;

/**
 *
 * @author JuanS
 */
public class Multilistas {

    /**
     * @param args the command line arguments
     */
    static Node root = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opc;

        do {
            System.out.println("Que desea hacer?");
            System.out.println("0..Crear Lista principal");
            System.out.println("1..Insertar nodo en lista principal");
            System.out.println("2..Insertar nodo en sublista");
            System.out.println("3..Buscar un nodo en lista principal");
            System.out.println("4..Buscar un nodo en sublistas");
            System.out.println("5..Mostrar Lista");
            System.out.println("6..Salir");
            opc = sc.nextInt();
            switch (opc) {
                case 0:
                    createList();
                    break;
                case 1:
                case 5:
                    showList();
                    break;
            }
        } while (opc != 6);
    }

    static void createList() {
        int n;
        int info, opc;
        Node p = root;
        do {
            if (root == null) {
                System.out.println("Digite la informacion de el Nodo inicial");
                info = sc.nextInt();
                root = new Node(null, null, info);
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
                    Node q = new Node(null, null, info);
                    p.setLink(q);
                    p=q;
                    break;
                case 2:
                    System.out.println("Digite la informacion de el nodo que contiene la sublista");
                    info = sc.nextInt();
                    Node objetivo = busqueda(info);
                    if (objetivo != null) {
                        System.out.println("Encontrado, digite la informacion de el nodo que desea ingresar en el nodo " + info);
                        info = sc.nextInt();
                        Subnode z = new Subnode(info, null);
                        if (objetivo.getSubroot() == null) {
                            objetivo.setSubroot(z);
                        } else {
                            Subnode w = objetivo.getSubroot();
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

    static Node busqueda(int info) {
        Node p = root;
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
            Node p = root;
            while (p != null) {
                System.out.println(p.getInfo());
                if (p.getSubroot() != null) {
                    Subnode z = p.getSubroot();
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
