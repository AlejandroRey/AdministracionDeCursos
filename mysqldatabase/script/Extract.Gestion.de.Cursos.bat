@echo off 
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysqldump" -uroot -padmin --routines gestiondecursos > gestiondecursos.sql
echo Done!
exit