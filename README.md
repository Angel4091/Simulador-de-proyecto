# 📘 Sistema de Gestión de Tareas Colaborativas

## 📌 Descripción General del Proyecto

Este proyecto consiste en el desarrollo de una aplicación en Java que permite la gestión de tareas y recordatorios dentro de un entorno colaborativo.

El sistema permite a los usuarios:
- Crear tareas y recordatorios
- Organizar actividades según prioridad y estado
- Compartir tareas con otros usuarios
- Dar seguimiento al progreso de cada actividad

El diseño está basado en Programación Orientada a Objetos (POO), utilizando clases abstractas, herencia e interfaces para estructurar el sistema de forma clara y escalable.

---

## 🎯 Objetivos de los Entregables

- **Entrega 1:** Diseño del sistema mediante diagrama UML
- **Entrega 2:** Implementación de las clases principales en Java
- **Entrega 3:** Integración del sistema, pruebas y funcionamiento completo

---

## 🧪 Guía de Uso del Proyecto en Java

### ▶️ Cómo ejecutar el proyecto

1. Abrir el proyecto en un IDE (IntelliJ, NetBeans o VS Code)
2. Ubicar la clase principal (`Main`)
3. Ejecutar el programa

---

### ➕ Cómo ingresar datos

El sistema puede solicitar datos como:

- Nombre del usuario
- Correo electrónico
- Tipo de usuario (clasico o premium)
- Título de tarea
- Descripción
- Prioridad (ALTA, MEDIA, BAJA)
- Fecha (para recordatorios o vencimientos)

---

## 🧾 Indicaciones para probar el sistema

### 👤 Creación de usuario

Ejemplo de datos esperados:
- Nombre: Juan Pérez  
- Correo: juan@email.com  
- Tipo: premium  

---

### 📋 Creación de tarea

Pasos:
1. Ingresar título
2. Ingresar descripción
3. Seleccionar prioridad
4. (Opcional) agregar fecha de vencimiento

---

### ⏰ Crear recordatorio

Pasos:
1. Ingresar título
2. Definir fecha y hora
3. Asociarlo a una tarea (si aplica)

---

### 🤝 Compartir tarea

Pasos:
1. Seleccionar tarea existente
2. Seleccionar usuario
3. Ejecutar opción de compartir

---

## 📥📤 Ejemplos de Entrada y Salida

### 🔹 Ejemplo 1: Crear usuario

**Entrada:**
Nombre: Ana López
Correo: ana@email.com
Tipo: clasico

**Salida esperada:**

Usuario creado correctamente
Tipo: UsuarioClasico

---

### 🔹 Ejemplo 2: Crear tarea

**Entrada:**

Título: Estudiar POO
Descripción: Repasar clases abstractas
Prioridad: ALTA

**Salida esperada:**

Tarea creada exitosamente
Estado: PENDIENTE

---

### 🔹 Ejemplo 3: Compartir tarea

**Entrada:**

Usuario destino: Carlos

**Salida esperada:**

Tarea compartida correctamente

---

### 🔹 Ejemplo 4: Crear recordatorio

**Entrada:**

Título: Entrega proyecto
Fecha: 2026-04-10 18:00

**Salida esperada:**

Recordatorio programado correctamente

---

## 🧠 Explicación General del Funcionamiento

El sistema está estructurado en torno a tres elementos principales:

- **Usuarios:** crean y gestionan tareas
- **Tareas:** representan actividades a realizar
- **Recordatorios:** ayudan a notificar eventos importantes

Existen dos tipos de usuarios:
- UsuarioClasico: con limitaciones
- UsuarioPremium: con funciones avanzadas como compartir tareas

Las tareas pueden:
- Tener diferentes estados (pendiente, en progreso, etc.)
- Tener prioridad (alta, media, baja)
- Ser compartidas con otros usuarios
- Contener recordatorios

Esto permite simular un entorno colaborativo real.

---

## 📎 Conclusión

Este proyecto demuestra la aplicación de conceptos de Programación Orientada a Objetos en Java, integrando múltiples clases y relaciones para construir un sistema funcional, organizado y fácil de extender.
