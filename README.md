# Running the Project with Docker

## Clone the Source Code to the Desired Directory

1. **Create a Directory**:
   - Open the terminal (or Git Bash) at the desired location.
   - Enter and run: `mkdir your-directory-name`
   
2. **Initialize Git**:
   - Open Git Bash in the created directory.
   - Enter and run: `git init`
   
3. **Add Remote Repository**:
   - Enter and run: `git remote add origin https://github.com/MockProject052024Nhom6/MockProject_052024_Group6.git`
   
4. **Pull Source Code**:
   - Enter and run: `git pull origin dev-java`

## Running the Project

1. **Open Terminal in the Project Directory**:
   - Navigate to the project directory where the source code is pulled.
   - Enter and run: `docker-compose up`
   - Wait for the build process to complete.

2. **Check Docker Desktop**:
   - Open Docker Desktop to verify that the services are running.

## Adding Data to the Database

### Using HeidiSQL to Connect

1. **Open HeidiSQL**.
2. **Connect to the database using the following details**:
   - **IP**: `localhost`
   - **Username**: `sa`
   - **Password**: `12345678Aa!`
   - **Port**: `1434`

3. **Screenshots**:
   - ![HeidiSQL Connection](path/to/heidisql-connection-screenshot1.png)
   - ![HeidiSQL Connection](path/to/heidisql-connection-screenshot2.png)

### Using DBeaver to Connect

1. **Open DBeaver**.
2. **Connect to the database using the same details as HeidiSQL**.

3. **Screenshots**:
   - ![DBeaver Connection](path/to/dbeaver-connection-screenshot1.png)
   - ![DBeaver Connection](path/to/dbeaver-connection-screenshot2.png)

### Run SQL Script

1. **Copy the data from the `db.init.sql` file**.
2. **Paste and run the script in HeidiSQL or DBeaver** to add data to the database.

## Testing the Data

### Swagger UI

- Access the following URL to test the API endpoints:
  - [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
  
### Postman

- Use the following invite code to join the Postman team and test the endpoints:
  - [Join Team](https://app.getpostman.com/join-team?invite_code=c24281393caae3789e3e237d00d7a954&target_code=6b1b163e2b2478908db4fbe82abf9696)
