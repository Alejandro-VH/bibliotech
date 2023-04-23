/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.pa.bibliotech.model;

/**
 * Clase que representa un Libro.
 *
 * @author Programacion Avanzada.
 */
public final class Libro {

    /**
     * The ISBN.
     */
    private String isbn;

    /**
     * The Titulo.
     */
    private String titulo;

    /**
     * The Author.
     */
    private String autor;

    /**
     * The Categoria
     */
    private String categoria;

    /**
     * The copias.
     */
    private int copias;

    /**
     * The Califcacion.
     */
    private int calificacion;

    /**
     * The Califcacion.
     */
    private int calificacionCantidad;

    /**
     * The Constructor.
     *
     * @param isbn      del libro.
     * @param titulo    del libro.
     * @param autor     del libro.
     * @param copias    del libro
     * @param categoria del libro.
     */
    public Libro(final String isbn, final String titulo, final String autor, final String categoria, final int copias, final int calificacionCantidad, final int calificacion) { //agregar metodos clasificaccion
        // validacion del isbn
        if (isbn == null || isbn.length() == 0) {
            throw new IllegalArgumentException("Isbn no valido!");
        }
        this.isbn = isbn;

        // validacion del titulo
        if (titulo == null || titulo.length() == 0) {
            throw new IllegalArgumentException("Titulo no valido!");
        }
        this.titulo = titulo;

        // validacion del autor
        if (autor == null || autor.length() == 0) {
            throw new IllegalArgumentException("Autor no valido!");
        }
        this.autor = autor;

        // validacion de la categoria
        if (categoria == null || categoria.length() == 0) {
            throw new IllegalArgumentException("Categoria no valida!");
        }
        this.categoria = categoria;

        // validacion de la cantidad de copias disponibles
        if (copias < 0) {
            throw new IllegalArgumentException("Nro de copias no valido!");
        }
        this.copias = copias;

        // validacion de la calificación
        if (calificacion < 0) {
            throw new IllegalArgumentException("Calificacion no valida!");
        }
        this.calificacion = calificacion;

        // validacion de la cantidad de clasificaciones
        if (calificacionCantidad < 0) {
            throw new IllegalArgumentException("Cantidad de clasificaciones no es valida!");
        }
        this.calificacionCantidad = calificacionCantidad;
    }

    /**
     * @return the ISBN.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * @return the titulo.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * @return the autor.
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * @return the categoria.
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**
     * @return the copias.
     */

    public int getCopias() {
        return copias;
    }

    /**
     * @return the calificacion.
     */
    public double getCalificacion() {
        try {
            return (this.calificacion / calificacionCantidad);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Se hace la calificacion a un libro, se guarda la calificacion y que una nueva persona califico el libro
     *
     * @param calificacion
     */
    public void sumarCalificacion(float calificacion) {
        this.calificacion += calificacion;
        calificacionCantidad += 1;
    }

    /**
     * Le resta una copia a un libro, solo si es que hay copias disponibles
     */
    public void retirarLibro() {
        //si no hay copipas tira error
        if (this.copias == 0) {
            throw new IllegalArgumentException("No quedan copias disponibles de este libro!");
        }
        //Se resta una copia
        this.copias -= 1;
    }
}
