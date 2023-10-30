# Address API Doc

## Create Address

Endpoint : POST /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan a",
  "city": "Kota",
  "province": "Provinsi",
  "country": "Negara",
  "postalCode": "Kode Pos"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan a",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "Kode Pos"
  }
}
```

Response Body (Failed) :

```json
{
  "error": "contact is not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan a",
  "city": "Kota",
  "province": "Provinsi",
  "country": "Negara",
  "postalCode": "Kode Pos"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan a",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "Kode Pos"
  }
}
```

Response Body (Failed) :

```json
{
  "error": "address is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan a",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "Kode Pos"
  }
}
```

Response Body (Failed) :

```json
{
  "error": "address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "error": "OK"
}
```

Response Body (Failed) :

```json
{
  "error": "address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan a",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "Kode Pos"
  }
}
```

Response Body (Failed) :

```json
{
  "error": "Address is not found"
}
```
