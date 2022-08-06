# omo-online-motorcycle-api
OMO-Online Motorcycle Api


##Nama Produk : OMO (Online Motorcycle)

## Overview Produk
Omo Api adalah API untuk produk OMO (Online Motorcyc) berisi api untuk register customer, login customer dan get custmer serta menyediakan api untuk register driver, login driver dan get driver.
Api ini ditambahkan object service locator dimana user dapat search location, reverse location dan mendapatkan routes nya

## Base Url
https://omo-online-motorcycle-api.herokuapp.com/

## Endpoint
Register Customer : https://omo-online-motorcycle-api.herokuapp.com/api/customer/register <br>
Login Customer ; https://omo-online-motorcycle-api.herokuapp.com/api/customer/login <br>
Get Customer : https://omo-online-motorcycle-api.herokuapp.com/api/customer <br>

Register Driver : https://omo-online-motorcycle-api.herokuapp.com/api/driver/register <br>
Login Driver : https://omo-online-motorcycle-api.herokuapp.com/api/driver/login <br>
Get Driver: https://omo-online-motorcycle-api.herokuapp.com/api/driver <br>

Get Search Location: https://omo-online-motorcycle-api.herokuapp.com/api/location/search <br> 
Get Reverse Location: https://omo-online-motorcycle-api.herokuapp.com/api/location/reverse <br> 
Get Routes Location: https://omo-online-motorcycle-api.herokuapp.com/api/location/routes <br> 

Post Search Location: https://omo-online-motorcycle-api.herokuapp.com/api/customer/insert/search-location <br> 
Post Reverse Location: https://omo-online-motorcycle-api.herokuapp.com/api/customer/insert/reverse-location <br> 

**untuk API Update Customer and Driver akan segera diupdate, thank you

| Name | Endpoint | Method | Bearer Token | Body and Response |
| --- | --- | --- | --- | --- |
| Register Customer | api/customer/register | POST | no | [example](#register-customer) |
| Login Customer | api/customer/login | POST | no | [example](#login-customer) |
| Get Customer | api/customer | GET | yes | [example](#get-customer) |
| Register Driver | api/driver/register | POST | no | [example](#driver-register) |
| Login Driver | api/driver/login | POST | no | [example](#driver-login) |
| Get Driver | api/driver | GET | yes | [example](#get-driver) |
| | |  | | | |
| Get Search Location | api/location/search | GET | no | [example](#get-search-location) |
| Get Reverse Location | api/location/reverse | GET | no | [example](#get-reverse-location) |
| Get Routes Location | api/location/routes | GET | no | [example](#get-routes-location) |
| Post Search Location | api/customer/insert/search-location | POST | yes | [example](#post-search-location)
| Post Reverse Location | api/customer/insert/reverse-location | POST | yes | [example](#post-reverse-location)

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

### Get search location
#### request param 
```json

  "coordinate" : -7.6658716,110.2926581
  "name" : "cafe"
```

#### response
```json
{
    "status": true,
    "message": "success",
    "data": [
        {
            "name": "Gumuk Pasir Ndeso",
            "address": {
                "city": "Magelang Kabupaten",
                "country": "Indonesia",
                "district": "Ngluwar"
            },
            "coordinate": {
                "latitude": -7.66985,
                "longitude": 110.28469
            }
        },
        {
            "name": "Angkringan Mas Pendi",
            "address": {
                "city": "Magelang Kabupaten",
                "country": "Indonesia",
                "district": "Ngluwar"
            },
            "coordinate": {
                "latitude": -7.65561,
                "longitude": 110.29447
            }
        }
    ]
}
```

### Get reverse location
#### request param 
```json

  "coordinate" : -7.6658716,110.2926581
```

#### response
```json
{
    "status": true,
    "message": "success",
    "data": [
        {
            "name": "79, Jalan Bitung Jaya, Tangerang Kabupaten 15712, Indonesia",
            "address": {
                "city": "Tangerang Kabupaten",
                "country": "Indonesia",
                "district": "Cikupa"
            },
            "coordinate": {
                "latitude": -6.22913,
                "longitude": 106.55053
            }
        }
    ]
}
```

### Get routes location
#### request param 
```json

  "origin" : 7.7894765,110.3526919
  "destination" : -7.7894765,110.3526919
```

#### response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "route": [
            {
                "latitude": -7.789486,
                "longitude": 110.3528
            },
            {
                "latitude": -7.789486,
                "longitude": 110.3528
            }
        ]
    }
}
```

### Post search location
#### request header Authorization
#### request param
```json

  "coordinate" : -7.6658716,110.2926581
  "name" : "cafe"
```

#### response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "idLocation": "00fab6b2-b09d-46b7-8589-9e04993f19a2",
        "idUser": "478049de-5479-483b-97e6-94690cf74287",
        "location": [
            {
                "name": "Caffe Mus",
                "address": {
                    "city": "Magelang Kabupaten",
                    "country": "Indonesia",
                    "district": "Ngluwar"
                },
                "coordinate": {
                    "latitude": -7.65614,
                    "longitude": 110.28118
                }
            },
            {
                "name": "Angkringan Maryono",
                "address": {
                    "city": "Magelang Kabupaten",
                    "country": "Indonesia",
                    "district": "Ngluwar"
                },
                "coordinate": {
                    "latitude": -7.65479,
                    "longitude": 110.28228
                }
            }
        ]
    }
}
```
### Post reverse location
#### request header Authorization
#### request param
```json

  "coordinate" : -7.6658716,110.2926581
```

#### response
```json
{
    "status": true,
    "message": "success",
    "data": {
        "idLocation": "c3a39814-ff3b-40a0-b1a6-60fab920327e",
        "idUser": "478049de-5479-483b-97e6-94690cf74287",
        "location": [
            {
                "name": "TK Pertiwi Somokaton 1",
                "address": {
                    "city": "Magelang Kabupaten",
                    "country": "Indonesia",
                    "district": "Ngluwar"
                },
                "coordinate": {
                    "latitude": -7.66723,
                    "longitude": 110.28977
                }
            }
        ]
    }
}
```
