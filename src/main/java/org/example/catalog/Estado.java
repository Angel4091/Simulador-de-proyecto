package org.example.catalog;

/**
 * Estados posibles del ciclo de vida de un {@link org.example.model.Elemento}.
 * <p>
 * Un elemento nace en {@link #PENDIENTE}, transita a {@link #EN_PROGRESO}
 * cuando se trabaja en él y termina en {@link #COMPLETADA} o
 * {@link #CANCELADA}.
 */
public enum Estado {
    /** Elemento creado pero aún no iniciado. */
    PENDIENTE,
    /** Elemento en el que se está trabajando actualmente. */
    EN_PROGRESO,
    /** Elemento finalizado correctamente. */
    COMPLETADA,
    /** Elemento descartado antes de finalizar. */
    CANCELADA
}
