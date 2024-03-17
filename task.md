# Task API Spec

# User

## Authentication
For authentication usage in login user and store the password use hashing with BCrypt

## Register User

Endpoint : POST /api/users

Request Body :

```json
{
  "username" : "khannedy",
  "password" : "rahasia",
  "name" : "Eko Kurniawan Khannedy" 
}
```

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Username must not blank, ???"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username" : "lala",
  "password" : "rahasia"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 1234567890 // milliseconds
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Username or password wrong"
}
```

## Get User

Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory) 

Response Body (Success) :

```json
{
  "data" : {
    "username" : "lala",
    "name" : "Lala Po"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Unauthorized"
}
```

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

# Task

## Create a new task

- Endpoint : POST /api/tasks

Request Body :
```json
{
    "detail": "save transaction",
}
```

Response Body (Success) :
```json
{
    "data": {
        "id" : 1,
        "detail": "save transaction"
    },
}
```

Response Body (Failed) :
```json
{
    "errors": "Detail not defined",
}
```

## Mark a task as completed

- Endpoint : POST /api/complete_task

Request Body :
```json
{
    "id": 1,
    "isComplete": true
}
```

Response Body (Success) :
```json
{
    "data": "OK",
}
```

Response Body (Failed) :
```json
{
    "errors": "id not defined",
}
```

## Retrieve a list of tasks
- Endpoint : GET /api/list/{isCompleted}

Response Body (Success) :
```json
{
    "data": [
        {
            "id": 1,
            "detail": "Save Transaction"
        }
    ],
}
```

Response Body (Failed) :
```json
{
    "errors": "task is completed status not defined",
}
```

Query to retrieve all incomplete tasks from the database.
```sql
select * from tasks where is_completed = false
```

## Sum of Even Number
A function that takes a list of integers as input and returns the sum of all even numbers in the list
- Endpoint : POST /api/sum

Request Body :
```json
{
    "numbers": [1, 2, 3, 4, 5]
}
```

Response Body (Success) :
```json
6
```