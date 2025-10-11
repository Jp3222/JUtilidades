/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.framework;

/**
 * Define un conjunto de métodos para gestionar los diferentes estados y
 * componentes de un elemento visual o componente.
 * <p>
 * Esta interfaz sigue un patrón de diseño para la inicialización y gestión del
 * ciclo de vida de un componente, separando claramente la configuración de
 * eventos, la adición de componentes y la gestión de estados iniciales y
 * finales.
 *
 * @author jp
 * @since 1.0
 */
public interface ComponentStates {

    /**
     * Construye y configura el componente invocando los métodos del ciclo de
     * vida.
     * <p>
     * Se debe llamar a este método en el constructor de la clase implementadora
     * para inicializar el componente. Para asegurar que la construcción se
     * realice una sola vez, la clase implementadora debe marcar este método
     * como {@code final} si la clase no es final.
     */
    void build();

    /**
     * Define y asigna todos los manejadores de eventos (event listeners) del
     * componente.
     * <p>
     * Este método se encarga de la lógica de interacción del usuario.
     */
    void events();

    /**
     * Inicializa y añade todos los componentes hijos o elementos visuales al
     * componente principal.
     * <p>
     * Se usa para organizar la estructura y el diseño del componente.
     */
    void components();

    /**
     * Define los valores iniciales y los estados modificables (variables) del
     * componente.
     * <p>
     * Este método se utiliza para preparar el componente con su estado por
     * defecto antes de que se muestre o se interactúe con él.
     */
    void initialState();

    /**
     * Define los valores finales y las configuraciones inmutables (constantes)
     * del componente.
     * <p>
     * Este método es ideal para configurar propiedades que no cambiarán durante
     * el ciclo de vida del componente.
     */
    void finalState();

}
