Prerequisites:

1. Docker installed
2. Start postgres pod in docker with this command:  
   docker run --name myPostgresDb -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=postgresDB -d postgres
