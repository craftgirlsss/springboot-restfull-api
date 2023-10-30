# User API Doc

## Register User

- Endpoint : Post /api/users

Request Body :

```json
{
  "username": "Putra",
  "password": "Rahasia",
  "name": "Saputra Budianto"
}
```

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response (Failed 401) :

```json
{
  "error": "Username must not blank"
}
```

## Login User

- Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "Putra",
  "password": "Rahasia"
}
```

Response Body (Success) :

```json
{
  "data": "OK",
  "token": "TOKEN",
  "expiredAt": 122312423 //milisecond
}
```

Response (Failed 401) :

```json
{
  "error": "username of password wrong"
}
```

## Get User

- Endpoint : GET /api/users/{username}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "username": "Putra Budianto",
    "name": "Saputra Budianto"
  }
}
```

Response (Failed 401) :

```json
{
  "error": "Unathorized"
}
```

## Update User

- Endpoint : PATCH /api/users/{username}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body (Success) :

```json
{
  "name": "Saputra Budianto", //put if only update name
  "password": "KaliLinux23/" // put if only update password
}
```

Response Body (Success) :

```json
{
  "data": {
    "username": "Putra Budianto",
    "name": "Saputra Budianto"
  }
}
```

Response (Failed 401) :

```json
{
  "error": "Unathorized"
}
```

## Logout User

- Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body (Success) :

```json
{
  "data": "Success"
}
```
