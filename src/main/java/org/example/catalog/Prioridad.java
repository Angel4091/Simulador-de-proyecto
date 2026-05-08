package org.example.catalog;

/**
 * Nivel de prioridad asignable a un {@link org.example.model.Elemento}.
 * <p>
 * Permite ordenar y filtrar tareas y recordatorios según su importancia.
 */
public enum Prioridad {
    /** Máxima urgencia: requiere atención inmediata. */
    ALTA,
    /** Prioridad estándar; valor por defecto. */
    MEDIA,
    /** Mínima urgencia: puede aplazarse. */
    BAJA
}
