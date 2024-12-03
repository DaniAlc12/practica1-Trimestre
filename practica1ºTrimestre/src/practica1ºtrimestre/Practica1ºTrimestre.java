package practica1ºtrimestre;

import java.util.Scanner;

public class Practica1ºTrimestre {

    public static Scanner datos = new Scanner(System.in);
    //Aqui pongo las victorias en estatica para que se me vayan acumulando los valores
    public static int victorias = 0;

    //Creo este metodo para sacar la lista de los colores que estan disponibles
    public static void listaColores() {
        System.out.println("-------------------------------------------");
        System.out.println("La lista de colores es la siguiente:"
                + "\nAmarillo\nRojo\nAzul\nVerde\nMorado\nNaranja\nNegro\nBlanco\nMarron\nRosa");
        System.out.println("-------------------------------------------");
    }

    //Este metodo creará el array que se tendra que adivinar,basicamente saco un numero random con el
    //Math.random del 1 al 10 y cada numero representa a un color
    public static String[] arrayMaquina() {
        String[] arrayDeColores = new String[5];
        for (int i = 0; i < arrayDeColores.length; i++) {
            int colorRandom = (int) (Math.random() * 10) + 1;
            if (colorRandom == 1) {
                arrayDeColores[i] = "Amarillo";
            } else if (colorRandom == 2) {
                arrayDeColores[i] = "Rojo";
            } else if (colorRandom == 3) {
                arrayDeColores[i] = "Azul";
            } else if (colorRandom == 4) {
                arrayDeColores[i] = "Verde";
            } else if (colorRandom == 5) {
                arrayDeColores[i] = "Morado";
            } else if (colorRandom == 6) {
                arrayDeColores[i] = "Naranja";
            } else if (colorRandom == 7) {
                arrayDeColores[i] = "Negro";
            } else if (colorRandom == 8) {
                arrayDeColores[i] = "Blanco";
            } else if (colorRandom == 9) {
                arrayDeColores[i] = "Marron";
            } else if (colorRandom == 10) {
                arrayDeColores[i] = "Rosa";
            }
        }
        return arrayDeColores;
    }

    //Este metodo creará el array del usuario que despues se comparará con el de la
    //maquina para saber si ha acertado los colores o no
    public static String[] arrayUsuario() {
        String[] arrayUsuario = new String[5];
        for (int i = 0; i < arrayUsuario.length; i++) {
            boolean color = true;
            //Con este while,el usuario me va metiendo los 5 colores y si introduce otro color o otra palabra 
            //le vuelve a preguntar sin pasar de posicion en el array
            while (color) {
                System.out.println("Introduce un color");
                String colorIntroducido = datos.next();
                if (colorIntroducido.equalsIgnoreCase("Amarillo") || colorIntroducido.equalsIgnoreCase("Rojo")
                        || colorIntroducido.equalsIgnoreCase("Azul") || colorIntroducido.equalsIgnoreCase("Verde")
                        || colorIntroducido.equalsIgnoreCase("Morado") || colorIntroducido.equalsIgnoreCase("Naranja")
                        || colorIntroducido.equalsIgnoreCase("Blanco") || colorIntroducido.equalsIgnoreCase("Marron")
                        || colorIntroducido.equalsIgnoreCase("Rosa") || colorIntroducido.equalsIgnoreCase("Negro")) {
                    arrayUsuario[i] = colorIntroducido;
                    color = false;
                } else {
                    System.out.println("Color no posible,vuelve a introducirlo");
                    color = true;
                }
            }
        }
        for (int i = 0; i < arrayUsuario.length; i++) {
            System.out.println(arrayUsuario[i]);
        }
        return arrayUsuario;
    }

    public static void masterMind(int vidas) {
        //Aqui hago unos booleanos para asegurarme de cada dificultad y que asi me sea
        //mas facil hacer los logros
        boolean facil = false;
        boolean medio = false;
        boolean dificil = false;
        if (vidas == 10) {
            facil = true;
        } else if (vidas == 5) {
            medio = true;
        } else {
            dificil = true;
        }
        //Aqui creo un array con el metodo arrayMaquina
        String[] arrayMaquina = arrayMaquina();
        System.out.println("---------------------------------");
        //Creo un while que se repetira hasta que las vidas bajen a 0
        while (vidas != 0) {
            //Creo la variable de los aciertos y de los fallos dentro del while porque
            //si lo colocase afuera se irian acumulando.
            int aciertos = 0;
            int fallos = 0;
            listaColores();
            String[] arrayUsuario = arrayUsuario();
            //Aqui voy recorriendo los dos arrays comparando los colores,si coinciden se suma un acierto
            //y si son diferente se suma un fallo
            for (int i = 0; i < arrayMaquina.length; i++) {
                if (arrayUsuario[i].equalsIgnoreCase(arrayMaquina[i])) {
                    aciertos++;
                } else {
                    fallos++;
                }
            }
            System.out.println("Has tenido " + aciertos + " aciertos");
            System.out.println("Has tenido " + fallos + " fallos");
            //Aqui hago la comprobacion de que si aciertos no son 5 quiere decir que ha fallado algun color,por lo que
            //se le resta una vida y vuelve al principio del while.Si los aciertos si son 5,entra en el else donde te suma una victoria
            //y empieza con las condiciones de los logros
            if (aciertos != 5) {
                vidas--;
                System.out.println("Tienes " + vidas + " vidas");
            } else {
                victorias++;
                System.out.println("Felicidades,has ganado!!!");
                System.out.println("LLevas " + victorias + " victoria/s");
                //------------
                //LOGROS
                //------------
                //Aqui hago el logro de la 1º victoria
                if (victorias == 1) {
                    System.out.println("""
                                       ******************************************
                                       LOGRO DESBLOQUEADO:PRIMERA VICTORIA
                                       ******************************************""");
                }
                //Aqui hago el logro de la primera Victoria en dificultad dificil
                if (dificil && victorias == 1) {
                    System.out.println("""
                                       ******************************************
                                       LOGRO DESBLOQUEADO:PRIMERA VICTORIA EN DIFICIL
                                       ******************************************""");
                }
                //Por ultimo hago el logro de ganar el juego a la primera
                if (victorias == 1 && (facil && vidas == 10) || (medio && vidas == 5) || (dificil && vidas == 3)) {
                    System.out.println("""
                                       ******************************************
                                       LOGRO DESBLOQUEADO:PERFECT WIN
                                       ******************************************""");
                }
                break;
            }
        }
    }

    public static void masterMindTesteo(int vidas) {
        //Aqui hago unos booleanos para asegurarme de cada dificultad y que asi me sea
        //mas facil hacer los logros
        boolean facil = false;
        boolean medio = false;
        boolean dificil = false;
        if (vidas == 10) {
            facil = true;
        } else if (vidas == 5) {
            medio = true;
        } else {
            dificil = true;
        }
        String[] arrayMaquina = arrayMaquina();
        System.out.println("""
                                       ******************************************
                                       MODO TESTEO:COLORES
                                       ******************************************""");
        for (int i = 0; i < arrayMaquina.length; i++) {
            System.out.println(arrayMaquina[i]);
        }
        System.out.println("---------------------------------");
        while (vidas != 0) {
            //Creo la variable de los aciertos y de los fallos dentro del while porque
            //si lo colocase afuera se irian acumulando.
            int aciertos = 0;
            int fallos = 0;
            listaColores();
            String[] arrayUsuario = arrayUsuario();
            for (int i = 0; i < arrayMaquina.length; i++) {
                if (arrayUsuario[i].equalsIgnoreCase(arrayMaquina[i])) {
                    aciertos++;
                } else {
                    fallos++;
                }
            }
            System.out.println("Has tenido " + aciertos + " aciertos");
            System.out.println("Has tenido " + fallos + " fallos");
            if (aciertos != 5) {
                vidas--;
                System.out.println("Tienes " + vidas + " vidas");

            } else {
                victorias++;
                System.out.println("Felicidades,has ganado!!!");
                System.out.println("LLevas " + victorias + " victoria/s");
                //------------
                //LOGROS
                //------------
                //Aqui hago el logro de la 1º victoria
                if (victorias == 1) {
                    System.out.println("""
                                       ******************************************
                                       LOGRO DESBLOQUEADO:PRIMERA VICTORIA
                                       ******************************************""");
                }
                //Aqui hago el logro de la primera Victoria en dificultad dificil
                if (dificil && victorias == 1) {
                    System.out.println("""
                                       ******************************************
                                       LOGRO DESBLOQUEADO:PRIMERA VICTORIA EN DIFICIL
                                       ******************************************""");
                }
                //Por ultimo hago el logro de ganar el juego a la primera
                //ESTE LOGRO NO ME VA
                if ((victorias == 1 && ((facil && vidas == 10) || (medio && vidas == 5) || (dificil && vidas == 3)))) {
                    System.out.println("""
                                       ******************************************
                                       LOGRO DESBLOQUEADO:PERFECT WIN
                                       ******************************************""");
                }
                break;
            }
        }
    }

    public static void dosJugadores(int vidasj1, int vidasj2) {
        String[] arrayJugador1 = arrayMaquina();
        String[] arrayJugador2 = arrayMaquina();
        while (vidasj1 != 0 || vidasj2 != 0) {
            int aciertosj1 = 0;
            int fallosj1 = 0;
            int aciertosj2 = 0;
            int fallosj2 = 0;
            System.out.println("TURNO DEL JUGADOR 1");
            listaColores();
            String[] arrayUsuario = arrayUsuario();
            for (int i = 0; i < arrayJugador2.length; i++) {
                if (arrayUsuario[i].equalsIgnoreCase(arrayJugador2[i])) {
                    aciertosj1++;
                } else {
                    fallosj1++;
                }
            }
            System.out.println("Has tenido " + aciertosj1 + " aciertos");
            System.out.println("Has tenido " + fallosj1 + " fallos");
            if (aciertosj1 != 5) {
                vidasj1--;
                System.out.println("Tienes " + vidasj1 + " vidas");
                if (vidasj1 == 0) {
                    System.out.println("El jugador 1 se ha quedado sin vidas,el jugador 2 ha ganado");
                    break;
                }
            } else {
                victorias++;
                System.out.println("Felicidades,el jugador 1 ha adivinado todos los colores!!!");
                System.out.println("LLevas " + victorias + " victoria/s");
                break;
            }
            System.out.println("TURNO DEL JUGADOR 2");
            listaColores();
            String[] arrayUsuario2 = arrayUsuario();
            for (int i = 0; i < arrayJugador2.length; i++) {
                if (arrayUsuario2[i].equalsIgnoreCase(arrayJugador1[i])) {
                    aciertosj2++;
                } else {
                    fallosj2++;
                }
            }
            System.out.println("Has tenido " + aciertosj2 + " aciertos");
            System.out.println("Has tenido " + fallosj2 + " fallos");
            if (aciertosj2 != 5) {
                vidasj2--;
                System.out.println("Tienes " + vidasj2 + " vidas");
                if (vidasj2 == 0) {
                    System.out.println("El jugador 2 se ha quedado sin vidas,el jugador 1 ha ganado");
                    break;
                }
            } else {
                victorias++;
                System.out.println("Felicidades,el jugador 2 ha adivinado todos los colores!!!");
                System.out.println("LLevas " + victorias + " victoria/s");
                break;
            }

        }
    }

    public static void dosJugadoresTesteo(int vidasj1, int vidasj2) {
        String[] arrayJugador1 = arrayMaquina();
        String[] arrayJugador2 = arrayMaquina();
        System.out.println("""
                                       ******************************************
                                       MODO TESTEO:COLORES
                                       ******************************************""");
        System.out.println("COLORES JUGADOR 1");
        for (int i = 0; i < arrayJugador1.length; i++) {
            System.out.println(arrayJugador1[i]);
        }
        System.out.println("*******************************");
        System.out.println("COLORES JUGADOR 2");
        for (int i = 0; i < arrayJugador2.length; i++) {
            System.out.println(arrayJugador2[i]);
        }
        while (vidasj1 != 0 || vidasj2 != 0) {
            int aciertosj1 = 0;
            int fallosj1 = 0;
            int aciertosj2 = 0;
            int fallosj2 = 0;
            System.out.println("TURNO DEL JUGADOR 1");
            listaColores();
            String[] arrayUsuario = arrayUsuario();
            for (int i = 0; i < arrayJugador2.length; i++) {
                if (arrayUsuario[i].equalsIgnoreCase(arrayJugador2[i])) {
                    aciertosj1++;
                } else {
                    fallosj1++;
                }
            }
            System.out.println("Has tenido " + aciertosj1 + " aciertos");
            System.out.println("Has tenido " + fallosj1 + " fallos");
            if (aciertosj1 != 5) {
                vidasj1--;
                System.out.println("Tienes " + vidasj1 + " vidas");
                if (vidasj1 == 0) {
                    System.out.println("El jugador 1 se ha quedado sin vidas,el jugador 2 ha ganado");
                    break;
                }
            } else {
                victorias++;
                System.out.println("Felicidades,el jugador 1 ha adivinado todos los colores!!!");
                System.out.println("LLevas " + victorias + " victoria/s");
                break;
            }
            System.out.println("TURNO DEL JUGADOR 2");
            listaColores();
            String[] arrayUsuario2 = arrayUsuario();
            for (int i = 0; i < arrayJugador2.length; i++) {
                if (arrayUsuario2[i].equalsIgnoreCase(arrayJugador1[i])) {
                    aciertosj2++;
                } else {
                    fallosj2++;
                }
            }
            System.out.println("Has tenido " + aciertosj2 + " aciertos");
            System.out.println("Has tenido " + fallosj2 + " fallos");
            if (aciertosj2 != 5) {
                vidasj2--;
                System.out.println("Tienes " + vidasj2 + " vidas");
                if (vidasj2 == 0) {
                    System.out.println("El jugador 2 se ha quedado sin vidas,el jugador 1 ha ganado");
                    break;
                }
            } else {
                victorias++;
                System.out.println("Felicidades,el jugador 2 ha adivinado todos los colores!!!");
                System.out.println("LLevas " + victorias + " victoria/s");
                break;
            }

        }
    }

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido al juego Master Mind\nTu objetivo"
                    + " sera el de adivinar los colores y sus respectivas posiciones\nEmpecemos "
                    + "seleccionando tu modo de juego:\n1-Un jugador\n2-Dos jugadores\n0-Salir");
            int numeroMenu = datos.nextInt();
            //EN ESTE PRIMER SWITCH,EL JUGADOR ELIGE SI QUIERE EL MODO DE UN JUGADOR(CON EL 1)
            //O EL MODO DE DOS JUGADORES(CON EL 2)
            switch (numeroMenu) {
                case 1:
                    System.out.println("Has elegido el"
                            + " modo de 1 jugador");
                    System.out.println("--------------------------------------");
                    System.out.println("Selecciona tu dificultad:\n1-Facil\n2-Media\n3-Dificil\n4-Modo Testeo\n0-Salir");
                    int numeroMenu2 = datos.nextInt();
                    //EN ESTE SEGUNDO SWITCH,EL JUGADOR ELIGE LA DIFICULTAD CON LA QUE QUIERE JUGAR O SI QUIERE JUGAR EN MODO TESTEO
                    switch (numeroMenu2) {
                        case 1:
                            System.out.println("Has elegido la"
                                    + " dificultad facil,con la que empezaras con 10 vidas");
                            System.out.println("--------------------------------------");
                            //Aqui pongo el metodo donde esta toda la logica del juego,el 10 que ponemos por
                            //teclado son las vidas
                            masterMind(10);
                            //Aqui simplemente hago un while como el del menu para preguntarle si quiere o no jugar otra partida
                            //y si me pone otra cosa le vuelvo a preguntar
                            boolean otraPartida = true;
                            while (otraPartida) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }

                            break;
                        case 2:
                            System.out.println("Has elegido la dificultad"
                                    + "media,con la que empezaras con 5 vidas");
                            System.out.println("--------------------------------------");
                            masterMind(5);
                            boolean otraPartida2 = true;
                            while (otraPartida2) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida2 = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida2 = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Has elegido la dificultad"
                                    + " dificil,con la que empezaras con 3 vidas");
                            System.out.println("--------------------------------------");
                            masterMind(3);
                            boolean otraPartida3 = true;
                            while (otraPartida3) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida3 = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida3 = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }
                            break;
                        case 4:
                            //Con este modo podras ver el array de la maquina,es como los demas pero con un for para
                            //mostrar las posiciones del arrayMaquina
                            System.out.println("Has elegido el modo de testeo,donde podras ver la solucion de la maquina");
                            System.out.println("--------------------------------------");
                            //Este metodo es igual al masterMind anteriores,lo unico que añade unos fors para mostrar los colores de los arrays
                            masterMindTesteo(4);
                            boolean otraPartida4 = true;
                            while (otraPartida4) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida4 = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida4 = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }
                            break;
                        case 0:
                            System.out.println("Has elegido salir,hasta pronto!!");
                            menu = false;
                            break;
                        default:
                            System.out.println("Ese numero no esta disponible,intentalo de nuevo");
                            menu = true;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Has elegido el modo"
                            + "de 2 jugadores");
                    System.out.println("--------------------------------------");
                    System.out.println("Seleccione la dificultad:\n1-Facil\n2-Media\n3-Dificil\n4-Modo testeo\n0-Salir");
                    int numeroMenu3 = datos.nextInt();
                    switch (numeroMenu3) {
                        case 1:
                            System.out.println("Has elegido la"
                                    + " dificultad facil,con la que empezareis con 10 vidas");
                            System.out.println("--------------------------------------");
                            //Aqui pongo el metodo donde esta toda la logica del juego,los 10 son las vidas de los dos jugadores
                            dosJugadores(10, 10);
                            //Aqui simplemente hago un while como el del menu para preguntarle si quiere o no jugar otra partida
                            //y si me pone otra cosa le vuelvo a preguntar
                            boolean otraPartida = true;
                            while (otraPartida) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }

                            break;
                        case 2:
                            System.out.println("Has elegido la dificultad"
                                    + "media,con la que empezareis con 5 vidas");
                            System.out.println("--------------------------------------");
                            dosJugadores(5, 5);
                            boolean otraPartida2 = true;
                            while (otraPartida2) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida2 = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida2 = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Has elegido la dificultad"
                                    + " dificil,con la que empezareis con 3 vidas");
                            System.out.println("--------------------------------------");
                            dosJugadores(3, 3);
                            boolean otraPartida3 = true;
                            while (otraPartida3) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida3 = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida3 = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Has elegido el modo de testeo");
                            System.out.println("--------------------------------------");
                            dosJugadoresTesteo(5, 5);
                            boolean otraPartida4 = true;
                            while (otraPartida4) {
                                System.out.println("Quieres jugar otra partida??");
                                String siono = datos.next();
                                if (siono.equalsIgnoreCase("Si")) {
                                    otraPartida4 = false;
                                    menu = true;
                                } else if (siono.equalsIgnoreCase("No")) {
                                    System.out.println("Gracias por jugar a Master Mind,hasta pronto!!");
                                    otraPartida4 = false;
                                    menu = false;
                                } else {
                                    System.out.println("Caracteres no permitidos,intentalo de nuevo");
                                }
                            }
                            break;
                        case 0:
                            System.out.println("Has elegido salir,hasta pronto!!");
                            menu = false;
                            break;
                        default:
                            System.out.println("Ese numero no esta disponible,intentalo de nuevo");
                            menu = true;
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Has elegido salir,hasta pronto!!");
                    menu = false;
                    break;
                default:
                    System.out.println("Ese numero no esta disponible,intentalo de nuevo");
                    menu = true;
                    break;
            }
        }
    }

}
