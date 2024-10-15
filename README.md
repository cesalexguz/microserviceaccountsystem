# Microservices Account System in Java 

This program has developed in Java 17 using Spring Boot 3.3.4, Gradle and PostgreSQL 17 for database.

## How execute the program?

### Database Configuration

First create an empty database in Postgres, in this case I use the default user and port of Postgres. If you need to update the settings of database, you can update the files application.properties of any project. However if you want to use the same default 
settings, just set the same variables you can see in this image:

For client and account service, the properties file is the same only changing the 8081 port for client and 8082 port for account service:

![image](https://github.com/user-attachments/assets/11c58345-16f8-4ba6-afc7-8e04ac851d3c) ![image](https://github.com/user-attachments/assets/68e43f59-5de0-4669-9fdd-bba1185a2c2a)

For accountstatement service (report service), it uses the 8083 port and this is the properties file:

![image](https://github.com/user-attachments/assets/7affc3dc-da9e-4180-af22-437665afff88)

If you want to restore a database, there is a backup file in "sql" folder:

![image](https://github.com/user-attachments/assets/f52e646d-c5fc-4b7a-b8b5-44c8927fb593)

### Run Program

To run the program, open all project folders in your IDE. These java projects were made using Gradle, so check it first in your IDE. Execute The program in your IDE and you will something like this:

![image](https://github.com/user-attachments/assets/8dbfb9a9-8cd4-41b6-889b-6bfde2c26190)

If is the first time you run the program, it will create the tables to database automatically.

### How to prove it?

In "postman" folder, you will see a collection file of Postman in JSON. If you import it. You will see this folders with all data you need, so just run it one by one:

![image](https://github.com/user-attachments/assets/59d4d03f-a7e4-41ab-a8fd-ac73acebc468)

### Funcionality Examples

After run in Postman the POST options, you can check by ID or get all registers:

![image](https://github.com/user-attachments/assets/cc3b7fb1-eaee-4769-8c6f-c51d35dfde90)

![image](https://github.com/user-attachments/assets/db355a3c-2ad8-4588-9998-e58ff605cde6)

![image](https://github.com/user-attachments/assets/bc1f013d-b9ca-41a7-88ca-4dea5329c501)

![image](https://github.com/user-attachments/assets/59db96df-c482-4883-9cff-348db1c48a32)

![image](https://github.com/user-attachments/assets/edc302f1-e0d5-498a-96dc-907ad84082a8)

![image](https://github.com/user-attachments/assets/78ca6661-e3cc-4d05-9346-ca433cdc9933)

