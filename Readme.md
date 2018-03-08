# Exercise

This project is a RESTful API that would allow a web or mobile front-end to:
- Create a contact record
- Retrieve a contact record
- Update a contact record
- Delete a contact record
- Search for a record by email
- Retrieve all records from the same state or city

For that purpose, it has 6 endpoints and these are the requests examples.

POST - `http://localhost:8080/contacts`

Body:

    {
    	"name": "pedro",
    	"company":"coto",
    	"profileImage":"123",
    	"email":"pepe@gmail.com",
    	"birthDate": "123213213",
    	"phoneNumberWork":"213-1232",
    	"phoneNumberPersonal":"12321-12321",
    	"address":{
    		"street":"Malabia",
    		"city":"Capital",
    		"state":"Buenos Aires",
    		"country":"Argentina"
    		}
    }
    
GET - `http://localhost:8080/contacts/{id}`

Response:

    {
     "idContact": 1,
     "name": "pedro",
     "company": "coto",
     "profileImage": "123",
     "email": "pepe@gmail.com",
     "birthDate": 123213213,
     "phoneNumberWork": "213-1232",
     "phoneNumberPersonal": "12321-12321",
     "address": {
        "street": "Malabia",
        "city": "Capital",
        "state": "BS AS",
        "country": "Argentina"
        }
	}
    
PUT - `http://localhost:8080/contacts/1`

Body:

    {
    	"name": "pedro",
    	"company":"coto",
    	"profileImage":"123",
    	"email":"pepe@gmail.com",
    	"birthDate": "123213213",
    	"phoneNumberWork":"213-1232",
    	"phoneNumberPersonal":"12321-12321",
    	"address":{
    		"street":"Malabia",
    		"city":"Capital",
    		"state":"BS AS",
    		"country":"Argentina"
    		}
    } 
    
DELETE - `http://localhost:8080/contacts/1`

GET - by email - `http://localhost:8080/contacts/email?email=pepe@gmail.com`

Response:

    {
     "idContact": 1,
     "name": "pedro",
     "company": "coto",
     "profileImage": "123",
     "email": "pepe@gmail.com",
     "birthDate": 123213213,
     "phoneNumberWork": "213-1232",
     "phoneNumberPersonal": "12321-12321",
     "address": {
        "street": "Malabia",
        "city": "Capital",
        "state": "BS AS",
        "country": "Argentina"
        }
	}
	
GET - by state or city - `http://localhost:8080/contacts/address?state=BS AS`

Response:

    {
    "content": [
        {
            "idContact": 1,
            "name": "pedro",
            "company": "coto",
            "profileImage": "123",
            "email": "pepe@gmail.com",
            "birthDate": 123213213,
            "phoneNumberWork": "213-1232",
            "phoneNumberPersonal": "12321-12321",
            "address": {
                "street": "Malabia",
                "city": "Capital",
                "state": "BS AS",
                "country": "Argentina"
            }
        }
    ],
    "last": true,
    "totalElements": 1,
    "totalPages": 1,
    "sort": null,
    "first": true,
    "numberOfElements": 1,
    "size": 10,
    "number": 0
}

### Test Application

A junit test for the GET by id endpoint is available.

### Run Application

You can run the application in a console with this line `mvn spring-boot:run`

For this project is used an embedded database, so you can watch stored data on a web browser on this url `http://localhost:8080/h2-console`, setting `JDBC URL=jdbc:h2:mem:testdb`

### Deploy Application

The project contains a Dockerfile and the docker-file-maven-plugin for deploying the app with Docker
