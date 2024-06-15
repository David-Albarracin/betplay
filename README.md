![Java](https://raw.githubusercontent.com/David-Albarracin/README_MATERIALS/main/java.png)

# Liga BetPlay en Java

LA FEDERACION COLOMBIANA DE FUTBOL DESEA CREAR UN PROGRAMA QUE LE PERMITA
LLEVAR EL CONTROL Y REGISTRO DE TODOS LOS EQUIPOS QUE SE ENCUENTRAN
PARTICIPANDO EN LA LIGA BETPLAY. LA FEDERACION DESEA ORGANIZAR EL TORNEO
TENIENDO EN CUENTA LA SIGUIENTE INFORMACION:

- NOMBRE DEL EQUIPO

- PJ

- PG

- PP

- PE

- GF

- GC

- TP

  

  ### REQUERIMIENTOS:

  1. EL PROGRAMA DEBE PERMITIR REGISTRAR CADA UNO DE LOS EQUIPOS QUE VAN A
      PARTICIPAR EN EL TORNEO, TENGA EN CUENTA QUE AL MOMENTO DE REGISTRAR CADA
      EQUIPO LAS VARIABLES DE PJ,PG,PP,PE,GF,GC,TP DEBEN SER 0

    

  2. EL PROGRAMA DEBE PERMITIR REGISTRAR A LOS JUGADORES Y LLEVAR UN CONTROL DE LOS GOLES QUE A  REALIZADO EL JUGADOR Y LAS TARGETAS AMARILLAS Y PERMITIR REGISTRAR AL CUERPO TEGNICO Y  MEDICO DEL EQUIPO

    

  3. REGISTRO DE FECHA. EL REGISTRO DE FECHAS SE DEBE INGRESAR LOS EQUIPOS
     QUE SE ENFRENTARON. EL PROGRAMA DEBE PERMITIR SELECCIONAR QUE EQUIPO JUGO DE
     LOCAL Y QUE EQUIPO JUGO DE VISITANTE. ADEMAS SE DEBE REGISTRAR EL MARCADOR DE
     CADA UNO DE LOS EQUIPOS. EL PROGRAMA DEBE DETERMINAR CUAL FUE EL EQUIPO
     GANADOR Y CUAL ES EL PERDEDOR Y ASIGNAR LOS VALORES CORRESPONDIENTES EN LA
     TABLA DE POSICIONES. RECUERDE QUE CADA PARTIDO GANADO EQUIVALE A 3 PUNTO
     Y LOS EMPATADOS EQUIVALEN A 1 PUNTO.

  

  4. REPORTES
     A. NOMBRE DEL EQUIPO QUE MAS GOLES ANOTO
     B. NOMBRE DEL EQUIPO QUE MAS PUNTOS TIENE
     C. NOMBRE DEL EQUIPO QUE MAS PARTIDOS GANO
     D. TOTAL DE GOLES ANOTADOS POR TODOS LOS EQUIPOS
     E. PROMEDIO DE GOLES ANOTADOS EN EL TORNEOLA FEDERACION COLOMBIANA DE FUTBOL .



## Solución

Vamos a implementar una arquitectura hexagonal + vertical slicing y vamos a crear una implementación tanto para MySql como JSON, primero creamos la estructura de carpetas

````
├───java
│   └───com
│       └───campuslands
│           ├───screen
│           │   ├───application
│           │   ├───domain
│           │   └───infrastructure
│           └───server
│               ├───core
│               │   ├───contracts
│               │   └───helpers
│               └───modules
│                   ├───gjson
│                   │   ├───application
│                   │   ├───domain
│                   │   └───infrastructure
│                   ├───match
│                   │   ├───application
│                   │   ├───domain
│                   │   │   ├───models
│                   │   │   └───repository
│                   │   └───infrastructure
│                   ├───mysql
│                   │   ├───application
│                   │   ├───domain
│                   │   └───infrastructure
│                   ├───person
│                   │   ├───application
│                   │   ├───domain
│                   │   │   ├───model
│                   │   │   └───repository
│                   │   └───infrastructure
│                   └───team
│                       ├───application
│                       ├───domain
│                       │   ├───models
│                       │   └───repository
│                       └───infrastructure
└───resources
    ├───datajson
    └───images
````

La estructura la creamos usando el modelo hexagonal mas clean code luego de esto creamos el diagrama de entidades 

