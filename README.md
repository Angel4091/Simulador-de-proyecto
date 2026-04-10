# 📘 Sistema de Gestión de Tareas Colaborativas

## 🧩 Descripción General

Este proyecto implementa un sistema orientado a la gestión de tareas y recordatorios dentro de un entorno colaborativo.

El objetivo principal es permitir que múltiples usuarios puedan:
- Crear tareas
- Organizar actividades
- Compartir responsabilidades
- Dar seguimiento al progreso

El diseño del sistema está basado en Programación Orientada a Objetos (POO), buscando claridad, modularidad y facilidad de mantenimiento.

---

## 🏗️ Arquitectura del Sistema

El sistema está estructurado en torno a entidades principales que representan los elementos reales del problema: usuarios, tareas y recordatorios.

Cada componente tiene una responsabilidad clara, lo que permite que el sistema sea escalable y fácil de entender.

---

## 👤 Gestión de Usuarios

### 🔹 Usuario (Clase Base)

Representa a cualquier persona que interactúa con el sistema.

Responsabilidades principales:
- Autenticarse en el sistema
- Crear tareas
- Crear recordatorios

Esta clase funciona como base para otros tipos de usuarios, permitiendo reutilizar comportamiento común.

---

### 🔹 UsuarioClasico

Extiende la funcionalidad básica del usuario con ciertas restricciones.

Características:
- Tiene un límite de tareas que puede crear
- Controla la cantidad de tareas activas

Esto permite simular un modelo de usuario con acceso limitado.

---

### 🔹 UsuarioPremium

Representa un usuario con privilegios adicionales.

Funcionalidades:
- Acceso a estadísticas del sistema
- Capacidad de compartir tareas con otros usuarios

Este tipo de usuario está diseñado para ofrecer una experiencia más completa dentro del sistema.

---

## 📋 Gestión de Tareas

### 🔹 Elemento (Clase Abstracta)

Es la base de los objetos principales del sistema.

Contiene información común como:
- Título
- Descripción
- Estado
- Prioridad
- Fecha de creación

Permite evitar duplicación de código y centralizar comportamiento compartido.

---

### 🔹 Tarea

Representa una actividad que debe ser completada.

Características:
- Puede tener una fecha límite
- Puede compartirse con otros usuarios
- Puede contener múltiples recordatorios

Esto permite modelar tareas complejas dentro de un entorno colaborativo.

---

### 🔹 Recordatorio

Representa una notificación asociada a una tarea o evento.

Funcionalidad:
- Programar alertas en fechas y horas específicas

Su propósito es ayudar al usuario a no olvidar actividades importantes.

---

## 🔗 Modelo de Interacción

El sistema se basa en las siguientes relaciones clave:

- Un usuario puede crear múltiples tareas y recordatorios
- Una tarea puede ser compartida entre varios usuarios
- Una tarea puede tener múltiples recordatorios asociados
- Los usuarios premium pueden compartir elementos con otros usuarios

Estas relaciones permiten una interacción flexible y colaborativa entre los usuarios.

---

## 🔐 Autenticación

El sistema incluye un mecanismo de autenticación que permite validar el acceso de los usuarios.

Esto asegura que:
- Solo usuarios registrados puedan acceder
- Las acciones estén asociadas a un usuario específico

---

## 🤝 Colaboración

Uno de los aspectos principales del sistema es la colaboración.

Se permite:
- Compartir tareas entre usuarios
- Trabajar en conjunto sobre una misma actividad
- Gestionar responsabilidades de forma distribuida

---

## 📊 Organización de Tareas

Para mejorar la gestión, las tareas cuentan con:

### Estados:
- Pendiente
- En progreso
- Completada
- Cancelada

### Prioridades:
- Alta
- Media
- Baja

Esto permite al usuario tener mejor control y organización de sus actividades.

---

## 🎯 Decisiones de Diseño

El sistema fue diseñado siguiendo buenas prácticas de POO:

- Uso de clases abstractas para reutilización
- Separación de responsabilidades
- Uso de interfaces para definir comportamientos
- Extensibilidad para futuros cambios

Estas decisiones permiten que el sistema sea:
- Escalable
- Mantenible
- Fácil de entender

---

## 🚀 Conclusión

Este proyecto demuestra la implementación de un sistema estructurado y organizado, aplicando correctamente conceptos de Programación Orientada a Objetos.

Además, refleja un enfoque colaborativo donde múltiples usuarios pueden interactuar de manera eficiente, simulando un entorno real de gestión de tareas.
