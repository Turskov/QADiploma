# Шаги для запуска автотестов

## MySQL:
1. Чтобы клонировать репозиторий из GitHub по указанной ссылке, используйте команду `git clone` https://github.com/Turskov/QADiploma;
2. Откройте проект в среде разработки `IntelliJ IDEA`;
3. Для запуска контейнера используйте команду `docker-compose up -d`;
4. Чтобы запустить приложение, используйте команду `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar .\artifacts\aqa-shop.jar`;
5. Для выполнения тестов используйте команду `./gradlew clean test '-Ddb.url=jdbc:mysql://localhost:3306/app'`;
6. Чтобы открыть отчет в браузере, используйте команду `./gradlew allureServe`;
7. Для остановки контейнера используйте команду `docker compose down`;

## PostgreSQL:
1. Чтобы клонировать репозиторий из GitHub по указанной ссылке, используйте команду `git clone` https://github.com/Turskov/QADiploma;
2. Откройте проект в среде разработки `IntelliJ IDEA`;
3. Для запуска контейнера используйте команду `docker-compose up -d`;
4. Чтобы запустить приложение, используйте команду `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar .\artifacts\aqa-shop.jar`;
5. Для выполнения тестов используйте команду `./gradlew clean test '-Ddb.url=jdbc:mysql://localhost:3306/app'`;
6. Чтобы открыть отчет в браузере, используйте команду `./gradlew allureServe`;
7. Для остановки контейнера используйте команду `docker compose down`;
