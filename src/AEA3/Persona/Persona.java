package AEA3.Persona;

public class Persona {
    public static void main(String[] args) {
        Programador programador = new Programador("Marc", "Av. Diagonal 600", 2500, "Programador");
        Gerente gerente = new Gerente("Laia", "Roger de Llúria 97", 3200, "Gerente", 8);
        Desarrollador desarrollador = new Desarrollador("Pau", "Rosselló 55", 2800, "Desarrollador", "Java");

        System.out.println(programador.generarInforme());
        System.out.println(programador.depurar());
        System.out.println("--------------------");

        System.out.println(gerente.generarInforme());
        System.out.println(gerente.gestionarProyecto());
        System.out.println("--------------------");

        System.out.println(desarrollador.generarInforme());
        System.out.println(desarrollador.escribirCodigo());
    }
}
