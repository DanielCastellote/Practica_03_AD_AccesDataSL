# MariaDB
FROM yobasystems/alpine-mariadb:10
# FROM mariadb:10.5

# Configuramos BBDD
ENV MYSQL_ROOT_PASSWORD 123
ENV MYSQL_USER dani
ENV MYSQL_PASSWORD 2002
ENV MYSQL_DATABASE data

# Copiamos los ficheros sql para que se ejecuten
COPY ./sql /docker-entrypoint-initdb.d/