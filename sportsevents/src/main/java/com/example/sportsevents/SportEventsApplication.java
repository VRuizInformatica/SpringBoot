// src/main/java/com/example/sportsevents/SportEventsApplication.java
package com.example.sportsevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportEventsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SportEventsApplication.class, args);
    }
}

//1. Usuarios
//POST /usuarios
//Descripción: Crea un nuevo usuario.
//Uso: Enviar un JSON con los datos, por ejemplo:
//
//json
//Copiar
//{
//  "nombre": "Juan Pérez",
//  "correo": "juan.perez@example.com"
//}
//GET /usuarios
//Descripción: Devuelve la lista de todos los usuarios registrados.
//
//PUT /usuarios/{id}
//Descripción: Actualiza la información de un usuario existente (identificado por su ID).
//Uso: Enviar un JSON con los nuevos datos, por ejemplo:
//
//json
//Copiar
//{
//  "nombre": "Juan P. Actualizado",
//  "correo": "juan.actualizado@example.com"
//}
//DELETE /usuarios/{id}
//Descripción: Elimina al usuario especificado por su ID.
//
//2. Eventos
//POST /eventos
//Descripción: Crea un nuevo evento deportivo.
//Uso: Enviar un JSON con los datos del evento, por ejemplo:
//
//json
//Copiar
//{
//  "nombre": "Torneo de Fútbol",
//  "descripcion": "Torneo anual de fútbol",
//  "fecha": "2025-05-10",
//  "hora": "18:00:00",
//  "duracion": 120
//}
//GET /eventos
//Descripción: Lista todos los eventos disponibles.
//Opcional: Puedes filtrar por parámetros de consulta:
//
//Filtrar por fecha:
//Ejemplo: /eventos?fecha=2025-05-10
//Filtrar por fecha y ubicación:
//Ejemplo: /eventos?fecha=2025-05-10&ubicacion=Zaragoza
//Filtrar por fecha y tipo (de instalación asociada):
//Ejemplo: /eventos?fecha=2025-05-10&tipo=pista
//PUT /eventos/{id}
//Descripción: Actualiza los datos de un evento existente identificado por su ID.
//Uso: Enviar un JSON con la nueva información del evento.
//
//DELETE /eventos/{id}
//Descripción: Elimina el evento especificado por su ID.
//
//3. Reservas
//POST /reservas
//Descripción: Crea una nueva reserva para una instalación (y opcionalmente la asocia a un evento).
//Uso: Enviar un JSON con los datos de la reserva. Ejemplo:
//
//json
//Copiar
//{
//  "fecha": "2025-05-10",
//  "franjaHoraria": "08:00-10:00",
//  "instalacion": { "id": 1 },
//  "evento": { "id": 1 }  // Opcional, solo si deseas asociar el evento
//}
//Importante: Asegúrate de que el ID de la instalación (y el del evento, si se usa) existan previamente.
//
//GET /reservas/instalacion/{id}
//Descripción: Devuelve la lista de reservas asociadas a una instalación específica (identificada por su ID).
//
//DELETE /reservas/{id}
//Descripción: Elimina la reserva identificada por su ID.
//
//4. Instalaciones
//POST /instalaciones
//Descripción: Registra una nueva instalación deportiva.
//Uso: Enviar un JSON con los datos, por ejemplo:
//
//json
//Copiar
//{
//  "nombre": "Gimnasio Central",
//  "tipo": "Gimnasio",
//  "ubicacion": "Centro de la ciudad"
//}
//GET /instalaciones
//Descripción: Lista todas las instalaciones registradas.
//
//GET /instalaciones/disponibles?fecha=YYYY-MM-DD
//Descripción: Consulta las instalaciones disponibles en una fecha determinada (es decir, sin reserva en esa fecha).
//Uso: Ejemplo: /instalaciones/disponibles?fecha=2025-05-10.
//
//DELETE /instalaciones/{id}
//Descripción: Elimina la instalación identificada por su ID.
