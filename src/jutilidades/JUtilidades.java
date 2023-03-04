/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jutilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author jp
 */
public class JUtilidades {

    public static void main(String[] args) throws Exception {
        Personas o1 = new Personas(0, "Rodrigo");
        Personas o2 = new Personas(1, "Juan Pablo");
        Personas o3 = new Personas(2, "Pedro");
        Personas o4 = new Personas(3, "Perla");
        Personas o5 = new Personas(4, "Perla");

        Personas[] o = {
            o2, o4, o1, o3
        };

        System.out.println(Arrays.toString(o));

        ArrayList<Personas> lista = new ArrayList<>(Arrays.asList(o));
        System.out.println(lista);

        int i = lista.lastIndexOf(o5);
        if (i != -1) {
            System.out.println(lista.get(i));
        } else {
            System.out.println("no existe");
        }
        
        
    }

    static class Personas implements Comparable<Personas> {

        int id;
        String nombre;

        public Personas(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return id + "=" + nombre;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Personas other = (Personas) obj;
            if (this.id != other.id) {
                return false;
            }
            return Objects.equals(this.nombre, other.nombre);
        }

        @Override
        public int compareTo(Personas t) {
            return Integer.compare(id, t.id);
        }

    }

}
