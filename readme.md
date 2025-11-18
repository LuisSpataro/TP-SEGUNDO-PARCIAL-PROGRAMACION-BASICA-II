# Sistema de Gestión de Criaturas Elementales

## Descripción General

Este proyecto modela un ecosistema orientado a objetos compuesto por criaturas elementales, sus transformaciones, interacciones y los maestros que las entrenan. Aplica principios avanzados de POO, pruebas automatizadas (TDD), trabajo colaborativo y buenas prácticas de desarrollo.

## Objetivo General

* Desarrollar un sistema orientado a objetos que represente criaturas elementales, poderes, transformaciones y sus interacciones.
* Aplicar principios de diseño y patrones de software.
* Implementar pruebas automáticas con **JUnit 4** bajo metodología TDD.
* Fomentar un flujo de trabajo profesional utilizando GitHub (branches, issues, pull requests, commits).

## Modalidad de Trabajo

* El trabajo se realiza en equipos de dos personas.
* El equipo debe mantener un repositorio compartido en GitHub.
* Cada integrante debe aportar mínimo **40%** del historial de commits.
* Se evaluará la colaboración real mediante commits, issues y PRs.

## Actividades Esperadas

### ✔ Diseño e Implementación del Sistema

* Criaturas (salvajes, domesticadas, ancestrales)
* Maestros
* Transformaciones
* Interacciones
* Módulo de reportes

### ✔ Principios de POO

* Herencia, polimorfismo, composición
* Delegación, cohesión, bajo acoplamiento
* Estructura de paquetes correcta y convenciones de nomenclatura

### ✔ Prácticas de Desarrollo

* TDD desde el inicio
* Test suite con JUnit 4
* Organización de tareas en GitHub
* Commits frecuentes y significativos por ambos integrantes

## Enunciado

### 🌍 Contexto General

En el mundo de **Elandria**, existen criaturas elementales con afinidades a **agua, fuego, aire o tierra**. Estas criaturas tienen habilidades, energía y comportamientos emocionales. Los Maestros Elementales las entrenan para mantener el equilibrio del reino.

El Consejo de Elandria necesita un sistema para:

* Gestionar criaturas
* Registrar entrenamientos y transformaciones
* Controlar interacciones
* Obtener reportes
* Garantizar prácticas éticas

---

## Parte I – Criaturas Elementales y Maestros

### 🐾 Criaturas

Cada criatura posee:

* Nombre
* Nivel de energía (0–200)
* Afinidad elemental (AGUA, FUEGO, AIRE, TIERRA)
* Comportamiento emocional: **tranquila** o **inestable**

Tipos:

1. **Criaturas Salvajes**

   * Difíciles de controlar
   * Entrenarlas puede generar aumentos impredecibles de energía
   * Si superan 200 → lanzar **unchecked exception**
2. **Criaturas Domesticadas**

   * Energía estable
   * Nunca se vuelven inestables
3. **Criaturas Ancestrales**

   * Energía nunca menor a 100
   * Muy poderosas, sensibles a entrenamientos extremos

### 👤 Maestros Elementales

Tienen:

* Nombre
* Nivel de maestría (1–50)
* Afinidad principal
* Colección de criaturas (**HashMap**, identificadas por nombre)

Los maestros pueden:

* Entrenar criaturas (reglas según tipo)
* Pacificar criaturas inestables (polimórfico)
* Transformarlas
* Si no tienen suficiente maestría → lanzar **checked exception**

---

## Parte II – Transformaciones Elementales (Patrón Decorator)

1. **Bendición del Río**

   * Duplica la energía, máximo 180
2. **Llama Interna**

   * Si es fuego → +30 energía
   * Si no → se vuelve inestable
3. **Vínculo Terrestre**

   * Asegura energía mínima de 50
4. **Ascenso del Viento**

   * Otorga temporalmente afinidad AIRE

Las transformaciones son acumulables y deben estar cubiertas por tests.

---

## Parte III – Interacciones entre Criaturas

* Misma afinidad → ambas +10 energía
* Afinidades opuestas (agua–fuego / aire–tierra) → ambas se vuelven inestables
* Si participa una ancestral:

  * Ancestral: +20 energía
  * La otra: −15 energía (mínimo 0)

Debe implementarse con una jerarquía bien diseñada, siguiendo **SRP** y **OCP**.

---

## Parte IV – Reportes para el Consejo

El sistema debe permitir:

1. Listar todas las criaturas registradas
2. Obtener la criatura con mayor energía
3. Determinar el maestro con más criaturas transformadas
4. Generar un **HashMap** con criaturas agrupadas por afinidad elemental

Todos los reportes deben crearse mediante **TDD desde el inicio**.

---

## Requisitos Mínimos de Aprobación

* Sistema completamente funcional
* Correcto uso de POO (interfaces, herencia, clases abstractas)
* Trabajo colaborativo con commits equilibrados
* Uso adecuado de GitHub (issues, PRs, branches)
* ≥ **70%** de cobertura de tests
* Al menos una **checked** y una **unchecked exception**
* Uso central de **HashMap** y colecciones auxiliares
* Código limpio siguiendo SOLID

## Plazo de Entrega

📅 **Sábado 22 de noviembre — 23:59 hs**

---

Este repositorio contiene toda la implementación del trabajo práctico cumpliendo los requisitos académicos y profesionales.

