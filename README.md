Tasca Avaluacio - Gestió de Conflictes

Descripció del projecte
Aquest projecte és una aplicació Spring Boot que gestiona conflictes internacionals.  
Inclou les següents funcionalitats:

- CRUD complet per a Conflites.
- CRUD per a Faction i Event.
- Endpoints avançats per filtrar conflictes per estat o per país.

L'aplicació utilitza una base de dades H2 en memòria, i les entitats principals són: `Conflict`, `Country`, `Faction` i `Event`.

---

Com compilar i executar l'aplicació

Requisits previs
- Java 17 o superior
- Maven 3.x
- IDE com IntelliJ, Eclipse o VSCode

Compilar i executar
1. Clonar el repositori:
   
   git clone <URL_DEL_REPOSITORI>
   cd tasca_avaluacio
   
2. Compilar el projecte

   mvn clean install
   
3. Executar l'aplicació

   mvn spring-boot:run

   (La aplicació s'executarà com https://localhost:8080)
   
4. Com accedir a la base de dades H2?:

   URL: http://localhost:8080/h2-console

   JDBC URL: jdbc:h2:mem:testdb

   User: dam

   Password: (deixar en blanc)

---

Exemples d'us dels endpoints principals amb Bruno (https://www.usebruno.com/)

Amb GET http://localhost:8080/api/v1/conflicts

<img width="1912" height="952" alt="image" src="https://github.com/user-attachments/assets/056a4f01-058a-44f8-ac3c-2032eb130c12" />

Y amb Post http://localhost:8080/api/v1/conflicts

<img width="1906" height="947" alt="image" src="https://github.com/user-attachments/assets/ff60086e-d591-4339-98b3-67367a4a0b03" />
