package Modelo;

import java.util.ArrayList;
import Vista.InOut;

public class Test {
    private ArrayList<Preguntas> preguntas;
    private ArrayList<Boolean> respuestas;
    InOut oe=new InOut();
    
    public Test() {
        preguntas = new ArrayList<>();
        respuestas = new ArrayList<>();
        preguntas.add(new Preguntas("¿Has tenido mascotas?\n a) Si\n b) No\n ", true));
        preguntas.add(new Preguntas("¿Te sientes bien en un ambiente social?\n a) Si\n b) No\n ", true));
        preguntas.add(new Preguntas("¿Tiene conocimiento sobre cuidado de mascotas?\n a) Si\n b) No\n ", true));
        preguntas.add(new Preguntas("¿Su salario es mayor o igual que el mínimo?\n a) Si\n b) No\n ", true));
        preguntas.add(new Preguntas("¿La mascota tendrá supervisión?\n a) Si\n b) No\n ", true));
    }

    public void realizarTest() {
        
        oe.mostraDatos("Responde las siguientes preguntas responde (a) para SI y (b) para NO:");
        for (Preguntas pregunta : preguntas) {
            String respuestaUsuario;
            while (true) {
                oe.mostraDatos(pregunta.getDescripcion());
                respuestaUsuario = oe.pedirString("Respuesta: ").trim().toLowerCase();

                if (respuestaUsuario.equals("a") || respuestaUsuario.equals("b")) {
                    boolean valor = respuestaUsuario.equals("a");
                    respuestas.add(valor == pregunta.getValorCorrecto());
                    break;
                } else {
                    oe.mostraDatos("Respuesta inválida. Por favor responde (a) para Si o (b) para No");
                }
            }
        }
        calcularAplicavilidad();
    }

    public void calcularAplicavilidad() {
        int respuestasCorrectas = 0;
        for (boolean respuesta : respuestas) {
            if (respuesta) {
                respuestasCorrectas++;
            }
        }
        double puntaje = (double) respuestasCorrectas / preguntas.size() * 100;
        boolean aplica = puntaje >= 70;

        if (aplica) {
            oe.mostraDatos("¡Bien hecho! Estas aplicado para adoptar una mascota :D");
        } else {
            oe.mostraDatos("Lo lamentamos, no puedes adoptar uno de nuestros amigos de cuatro patas :c.");
        }
    }
}
