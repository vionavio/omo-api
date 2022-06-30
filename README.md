# omo-online-motorcycle-api
OMO-Online Motorcycle Api


##Nama Produk : OMO (Online Motorcycle)

## Overview Produk
Omo Api adalah API untuk produk OMO (Online Motorcyc) berisi api untuk register customer, login customer dan get custmer serta menyediakan api untuk register driver, login driver dan get driver

## Base Url
https://omo-online-motorcycle-api.herokuapp.com/

## Endpoint
Register Customer : https://omo-online-motorcycle-api.herokuapp.com/api/customer/register <br>
Login Customer ; https://omo-online-motorcycle-api.herokuapp.com/api/customer/login <br>
Get Customer : https://omo-online-motorcycle-api.herokuapp.com/api/customer <br>

Register Driver : https://omo-online-motorcycle-api.herokuapp.com/api/driver/register <br>
Login Driver : https://omo-online-motorcycle-api.herokuapp.com/api/driver/login <br>
Get Driver: https://omo-online-motorcycle-api.herokuapp.com/api/driver <br>

**untuk API Update Customer and Driver akan segera diupdate, thank you

| Name | Endpoint | Method | Bearer Token | Body and Response |
| --- | --- | --- | --- | --- |
| Register Customer | api/customer/register | POST | no | [example](#register-customer) |
| Login Customer | api/customer/login | POST | no | [example](#login-customer) |
| Get Customer | api/customer | GET | yes | [example](#get-customer) |
| Register Driver | api/driver/register | POST | no | [example](#driver-register) |
| Login Driver | api/driver/login | POST | no | [example](#driver-login) |
| Get Driver | api/driver | GET | yes | [example](#get-driver) |

### Register Customer 
Request
```json
{
    "username" : "renata",
    "password" : "1234"
    
}
```
Response
```json
{
    "status": true,
    "message": "success",
    "data": true
}
```

### Login Customer
Request
```json
{
    "username" : "renata",
    "password" : "1234"
    
}
```
Response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1NTgyMGJmMC1hZmEwLTQ5YWEtYmJhMy03NmQwMmJmZGFiOTciLCJhdXRoIjpbInJlbmF0YSJdLCJleHAiOjE2NTY3MTkwMzN9.pMIEo5QfSu144YfA8AC0KiokrHMwEq7cGS22-GCG5iI"
    }
}
```

### get customer
insert auth
response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "id": "478049de-5479-483b-97e6-94690cf74287",
        "username": "viola",
        "password": null
    }
}
```

### Driver Register
request
```json
{
    "username" : "leo",
    "password" : "1111",
    "vehicleType" : "Supra",
    "vehicleRegistNumber" : "AB4313YK"
}
```
response
```json
{
    "status": true,
    "message": "success",
    "data": true
}
```
### Driver Login
request
```json
{
    "username" : "leo",
    "password" : "1111"
}
```
response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmMDM0YmZlZi0zOTVjLTQxYmItOTAzYS1mMzFmOThlMWQwYzkiLCJhdXRoIjpbImxlbyJdLCJleHAiOjE2NTY3MTcxNjZ9.HeqZv7X2g-urmqpYI_6Ut_n8rQqt88gOx6ZpNB31JkU"
    }
}
```

### Get driver
request insert auth
response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "id": "5399066e-13bd-44e9-a884-aa5848a5f457",
        "username": "Ari",
        "password": null,
        "vehicleType": "Supra",
        "vehicleRegistNumber": "AB4313YK"
    }
}
```






