### Steps to demonstrate functionality

1. Execute postgres and pgAdmin containers by _docker-compose up_ command in project root directory
2. Open pgAdmin in browser using http://localhost:5050 address
3. Use _name@example.com_ and _admin_ as login and password 
4. Add server with these parameters:
```
   name: postgresdb
   host: host.docker.internal
   database: postgres
   user: postgres
   password: admin
```
5. Open _Query Tool_ and execute sql statements from [create-table.sql](create-table.sql) file
6. Run Application from IDE
7. Open Postman and import new API using [languages-catalog.yaml](languages-catalog.yaml)
8. Try to send requests by Postman using new API