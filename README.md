
# billing-sample
basic billing app


![Development Status](https://img.shields.io/badge/Status-Under%20Development-orange) 


### how to run
    1. cd billing-sample/src/main/resources/
    2. touch .env
    3. add this and their values
          DB_USERNAME=
          DB_PASSWORD=
          DB_NAME=
          CONNECTION_NAME=
    4. ./mvnw spring-boot:run -DskipTests


### API Reference

####  Get customer details

```http
  GET customer/get/{customer-id}
```

#### Get customer-id via phone

```http
  GET /customer/get/phone/{customer-phone}
```
#### POST billing

```http
  POST /billing/v1/add
```
####  body
```json
  {
  "fromAddress": "123 Main St",
  "customer": {
    "name": "John Doe",
    "address": "456 Side St",
    "phone": 9876543210,
    "billingIdList": []
  },
  "productList": [
    {
      "name": "Product A",
      "price": 10.0,
      "quantity": 2,
      "total": 20.0
    },
    {
      "name": "Product B",
      "price": 15.0,
      "quantity": 1,
      "total": 15.0
    }
  ],
  "subTotal": 35.0,
  "taxAmount": 6.3,
  "taxPercentage": 18.0,
  "grandTotal": 41.3
}

```
## Authors

- [@aakashsinha46](https://www.github.com/aakashsinha46)
