@echo off 
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysql" -uroot -padmin -e "DROP DATABASE gestiondecursos;"
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysql" -uroot -padmin -e "CREATE DATABASE gestiondecursos;"
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysql" -uroot -padmin -D gestiondecursos < gestiondecursos.sql
echo Done!
exit