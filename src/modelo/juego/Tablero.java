/**
 *
 */
package modelo.juego;

/**
 * Clase que representa el tablero de juego de la aplicación.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class Tablero {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Matriz que representa el tablero.
     */
    private final Pieza[][] tablero;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el tablero.
     */
    public Tablero() {
        tablero = new Pieza[3][3];
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Inicializa el tablero. (Reinicia)
     */
    public void inicializarTablero() 
    {
        for (Pieza[] tablero1 : tablero) {
            for (int j = 0; j < tablero1.length; j++) {
                Pieza pieza = new Pieza(Pieza.LIBRE);
                tablero1[j] = pieza;
            }
        }
    }

    /**
     * Actualiza una posicion de la matriz cin un valor de pieza entregado por
     * el controlador.
     *
     * @param x Fila de la matriz.
     * @param y Columna de la matriz.
     * @param piezaId Valor de la posiocion seleccionada. piezaId = Pieza.X ||
     * piezaId = PIeza.O .
     */
    public void actualizarPosicion(int x, int y, int piezaId) {
        Pieza pieza = tablero[x][y];
        if (pieza.getEstado() == Pieza.LIBRE) {
            pieza.setEstado(piezaId);
            tablero[x][y] = pieza;
        }
    }

    /**
     * Obtiene el valor de un punto de la matriz en una coordenada especificada.
     *
     * @param x Fila de la matriz.
     * @param y Columna de la matriz.
     * @return Valor en la posicion especificada.
     */
    public int validarCasilla(int x, int y) {
        return tablero[x][y].getEstado();
    }

    /**
     * Valida una fila � columna de la matriz. Cada fila y columna se
     * representaron mediante un numero para facilitar el proceso de validación.
     *
     * @param x Identifica una fila o columna de la matriz definidia
     *
     * |	|
     * 0.0	| 0.1	| 0.2 ******************** 1.0	| 1.1	| 1.2 |	|
     * ******************** 2,0	| 2.1	| 2.2 |	|
     *
     * @param idPieza Valor que define si una columna o fila es valida
     * @return true: si las posiciones de la fila o columna coincide con el
     * valor idPieza. false: si las posiciones de la fila o columna no coincide
     * con el valor idPieza.
     */
    public boolean validarFila(int x, int idPieza) {
        if (x == 1) {
            int linea1 = validarCasilla(0, 0);
            int linea2 = validarCasilla(1, 0);
            int linea3 = validarCasilla(2, 0);

            if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                return true;
            }
        } else {
            if (x == 2) {
                int linea1 = validarCasilla(0, 0);
                int linea2 = validarCasilla(0, 1);
                int linea3 = validarCasilla(0, 2);

                if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                    return true;
                }
            } else {
                if (x == 3) {
                    int linea1 = validarCasilla(0, 2);
                    int linea2 = validarCasilla(1, 2);
                    int linea3 = validarCasilla(2, 2);

                    if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                        return true;
                    }
                } else {
                    if (x == 4) {
                        int linea1 = validarCasilla(2, 0);
                        int linea2 = validarCasilla(2, 1);
                        int linea3 = validarCasilla(2, 2);

                        if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                            return true;
                        }
                    } else {
                        if (x == 5) {
                            int linea1 = validarCasilla(0, 1);
                            int linea2 = validarCasilla(1, 1);
                            int linea3 = validarCasilla(2, 1);

                            if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                                return true;
                            }
                        } else {
                            if (x == 6) {
                                int linea1 = validarCasilla(1, 0);
                                int linea2 = validarCasilla(1, 1);
                                int linea3 = validarCasilla(1, 2);

                                if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                                    return true;
                                }
                            } else {
                                if (x == 7) {
                                    int linea1 = validarCasilla(2, 0);
                                    int linea2 = validarCasilla(1, 1);
                                    int linea3 = validarCasilla(0, 2);

                                    if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                                        return true;
                                    }
                                } else {
                                    if (x == 8) {
                                        int linea1 = validarCasilla(0, 0);
                                        int linea2 = validarCasilla(1, 1);
                                        int linea3 = validarCasilla(2, 2);

                                        if (linea1 == idPieza && linea2 == idPieza && linea3 == idPieza) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Valida si una posicon especifica es sificiente para determinar un
     * ganador. Es decir si se ha fomrado una linea con tres elementos iguales
     * en la matriz.
     *
     * @param x Fila en la matriz.
     * @param y Columna en la matriz.
     * @return true: alguna de las validaciones necesarias para una posición es
     * suficientes para ganar el juego. false: ninguna de las validaciones
     * necesarias para una posicion determinada son verdaderas.
     */
    public boolean validarGanador(int x, int y) {
        Pieza pieza = tablero[x][y];
        int estadoPieza = pieza.getEstado();

        //1
        if (x == 0 && y == 0) {
            boolean fila1 = validarFila(1, estadoPieza);
            if (fila1) {
                return true;
            }

            boolean fila2 = validarFila(2, estadoPieza);
            if (fila2) {
                return true;
            }

            boolean fila8 = validarFila(8, estadoPieza);
            if (fila8) {
                return true;
            }
        } else {
            //2
            if (x == 0 && y == 1) {
                boolean fila2 = validarFila(2, estadoPieza);
                if (fila2) {
                    return true;
                }

                boolean fila5 = validarFila(5, estadoPieza);
                if (fila5) {
                    return true;
                }
            } else {
                //3
                if (x == 0 && y == 2) {
                    boolean fila2 = validarFila(2, estadoPieza);
                    if (fila2) {
                        return true;
                    }

                    boolean fila3 = validarFila(3, estadoPieza);
                    if (fila3) {
                        return true;
                    }

                    boolean fila7 = validarFila(7, estadoPieza);
                    if (fila7) {
                        return true;
                    }
                } else {
                    //4
                    if (x == 1 && y == 0) {
                        boolean fila1 = validarFila(1, estadoPieza);
                        if (fila1) {
                            return true;
                        }

                        boolean fila6 = validarFila(6, estadoPieza);
                        if (fila6) {
                            return true;
                        }
                    } else {
                        //5
                        if (x == 1 && y == 1) {
                            boolean fila5 = validarFila(5, estadoPieza);
                            if (fila5) {
                                return true;
                            }

                            boolean fila6 = validarFila(6, estadoPieza);
                            if (fila6) {
                                return true;
                            }

                            boolean fila8 = validarFila(8, estadoPieza);
                            if (fila8) {
                                return true;
                            }

                            boolean fila7 = validarFila(7, estadoPieza);
                            if (fila7) {
                                return true;
                            }
                        } else {
                            //6
                            if (x == 1 && y == 2) {
                                boolean fila3 = validarFila(3, estadoPieza);
                                if (fila3) {
                                    return true;
                                }

                                boolean fila6 = validarFila(6, estadoPieza);
                                if (fila6) {
                                    return true;
                                }
                            } else {
                                //7
                                if (x == 2 && y == 0) {
                                    boolean fila1 = validarFila(1, estadoPieza);
                                    if (fila1) {
                                        return true;
                                    }

                                    boolean fila4 = validarFila(4, estadoPieza);
                                    if (fila4) {
                                        return true;
                                    }

                                    boolean fila7 = validarFila(7, estadoPieza);
                                    if (fila7) {
                                        return true;
                                    }
                                } else {
                                    //8
                                    if (x == 2 && y == 1) {
                                        boolean fila4 = validarFila(4, estadoPieza);
                                        if (fila4) {
                                            return true;
                                        }

                                        boolean fila5 = validarFila(5, estadoPieza);
                                        if (fila5) {
                                            return true;
                                        }
                                    } else {
                                        //9
                                        if (x == 2 && y == 2) {
                                            boolean fila3 = validarFila(3, estadoPieza);
                                            if (fila3) {
                                                return true;
                                            }

                                            boolean fila4 = validarFila(4, estadoPieza);
                                            if (fila4) {
                                                return true;
                                            }

                                            boolean fila8 = validarFila(8, estadoPieza);
                                            if (fila8) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
