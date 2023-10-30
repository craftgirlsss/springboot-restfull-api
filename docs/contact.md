# Contact API Doc

## Create Contact

Endpoint : POST /api/contacts

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName": "Saputra",
  "lastName": "Budianto",
  "email": "localhosting127.0.0.1@gmail.com",
  "password": "081237131587"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstName": "Saputra",
    "lastName": "Budianto",
    "email": "localhosting127.0.0.1@gmail.com",
    "password": "081237131587"
  }
}
```

Response Body (Failed 401) :

```json
{
  "error": "Email or username format invalid"
}
```

## Update Contact

Endpoint :PUT /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body (Success) :

```json
{
  "firstName": "Saputra",
  "lastName": "Budianto",
  "email": "localhosting127.0.0.1@gmail.com",
  "password": "081237131587"
}
```

Response Body (Success) :

```json
"data" : {
        "id" : "random-string",
        "firstName" : "Saputra",
        "lastName" : "Budianto",
        "email" : "localhosting127.0.0.1@gmail.com",
        "password" : "081237131587"
    }
```

Response Body (Failed 401) :

```json
{
  "error": "Email or username format invalid"
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
"data" : {
        "id" : "random-string",
        "firstName" : "Saputra",
        "lastName" : "Budianto",
        "email" : "localhosting127.0.0.1@gmail.com",
        "password" : "081237131587"
    }
```

Response Body (Failed 404) :

```json
{
  "error": "Contact is not found"
}
```

## Search Contact

Endpoint : GET /api/contacts

Query Param :

- name : String, contact first name or last name, using like query optional
- phone : String, contact phone, using like query optional

- email : String, contact email using like query optional

- page : Integer, Start from 0, default 0

- size : Integer, defautlt 10

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "random-string",
      "firstName": "Saputra",
      "lastName": "Budianto",
      "email": "localhosting127.0.0.1@gmail.com",
      "password": "081237131587"
    }
  ],
  "page": {
    "totalPage": 10,
    "size": 10,
    "currentPage": 0
  }
}
```

Response Body (Failed 401) :

```json
{
  "error": "Unauthorized"
}
```

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed 401) :

```json
{
  "error": "Contact not found"
}
```
