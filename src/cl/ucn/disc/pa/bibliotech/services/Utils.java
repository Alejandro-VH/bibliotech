/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.pa.bibliotech.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Clase que reune los metodos utilitarios.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class Utils {

    /**
     * The Email validator.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    /**
     * The Password validator.
     */
    // -Contraseña de 5-16 caracteres
    // -al menos 1 letra minúscula y una letra mayúscula
    // -sin espacios en blanco
    // -que contenga numeros
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,16}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    /**
     * Constructor privado: nadie puede instanciar esta clase.
     */
    private Utils() {
        // nothing here
    }

    /**
     * Add theObject to theStaticArray.
     *
     * @param theStaticArray the array.
     * @param theObject      the object to append.
     * @param <T>            generic to use.
     * @return the static array.
     */
    public static <T> T[] append(T[] theStaticArray, T theObject) {
        // new arraylist
        List<T> theList = new ArrayList<>();
        // copy all the items from [] to the list
        Collections.addAll(theList, theStaticArray);
        // add the object
        theList.add(theObject);
        // return the static array
        return theList.toArray(theStaticArray);
    }

    /**
     * Valida un correo electronico, en caso de no ser valido se lanza una Exception.
     *
     * @param email a validar.
     */
    public static void validarEmail(final String email) {
        // el correo debe ser estructuralmente valido
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Correo Electronico no valido: " + email);
        }
    }

    /**
     * Se valida que el nombre no tenga caracteres invalidos y su longitud
     *
     * @param nombre
     */
    public static void validarNombre(final String nombre) {
        // Se valida que el nombre no se nulo
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo!");
        }
        //Se verifica la longitud del nombre
        if (nombre.length() < 2 || nombre.length() > 25) {
            throw new IllegalArgumentException("La longitud del nombre debe rondar entre los 2 a los 25 caracteres!");
        }
        //Se verifica que el nombre no tenga ningun numero
        contieneNumeros(nombre);
    }

    /**
     * Se valida que el apellido no tenga caracteres invalidos y su longitud
     *
     * @param apellido
     */
    public static void validarApellido(final String apellido) {
        // Se valida que el apellido no se nulo
        if (apellido == null) {
            throw new IllegalArgumentException("El apellido no puede ser nulo!");
        }
        //Se verifica la longitud del apellido
        if (apellido.length() < 2 || apellido.length() > 25) {
            throw new IllegalArgumentException("La longitud del apellido debe rondar entre los 2 a los 25 caracteres!");
        }
        //Se verifica que el apellido no tenga ningun numero
        contieneNumeros(apellido);
    }

    /**
     * Valida la contraseña, revisa que tenga 8-16 caracteres, un carter caracter especial, sin espacios en blanco, al menos una letra minúscula y una letra mayúscula.
     *
     * @param contrasenia Author: https://www.techiedelight.com/es/validate-password-java/
     */
    public static void validarContrasenia(final String contrasenia) {
        //Se verifica que cumpla los requisitos
        if (!PASSWORD_PATTERN.matcher(contrasenia).matches()) {
            throw new IllegalArgumentException("Se ha ingresado una contraseña invalida!");
        }
    }

    public static void validarNumeroDeSocio(final int numSocio) {
        // se verifica que no sea negativo
        if (numSocio <= 0) {
            throw new IllegalArgumentException("El numero de socio es invalido!");
        }
    }

    /**
     * Revisa si el string entregado contiene un digito numerico, en ese caso mostrara un error
     *
     * @param string a validar
     *               Author: https://www.delftstack.com/es/howto/java/check-if-string-contains-numbers-in-java/
     */
    public static void contieneNumeros(String string) {
        char[] aux = string.toCharArray();
        boolean invalido = false;
        for (char c : aux) {
            if (Character.isDigit(c)) {
                invalido = true;
            }
        }

        if (invalido) {
            throw new IllegalArgumentException("No se pueden usar numeros en este campo!");
        }
    }
}
