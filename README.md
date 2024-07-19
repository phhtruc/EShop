Running the Project with Docker
Clone the Source Code to the Desired Directory
Create a Directory:
Open the terminal (or Git Bash) at the desired location.
Enter and run: mkdir your-directory-name
Initialize Git:
Open Git Bash in the created directory.
Enter and run: git init
Add Remote Repository:
Enter and run: git remote add origin https://github.com/MockProject052024Nhom6/MockProject_052024_Group6.git
Pull Source Code:
Enter and run: git pull origin dev-java
Running the Project
Open Terminal in the Project Directory:

Navigate to the project directory where the source code is pulled.
Enter and run: docker-compose up
Wait for the build process to complete.
Check Docker Desktop:

Open Docker Desktop to verify that the services are running.
Adding Data to the Database
Using HeidiSQL to Connect:

Open HeidiSQL.
Connect to the database using the following details:
IP: localhost
Username: sa
Password: 12345678Aa!
Port: 1434
Screenshot 1:
Screenshot 2:
Using DBeaver to Connect:

Open DBeaver.

Connect to the database using the same details as HeidiSQL.

Screenshot 1:

Screenshot 2:

Run SQL Script:

Copy the data from the db.init.sql file.
Paste and run the script in HeidiSQL or DBeaver to add data to the database.
Testing the Data
Swagger UI:
Access the following URL to test the API endpoints:
http://localhost:8080/swagger-ui/index.html
Postman:
Use the following invite code to join the Postman team and test the endpoints:
Join Team
