# Task API Spec

## Create Task

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

## Mark Complete Task

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

## List of Tasks
- Endpoint : GET /api/list/incomplete

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
    "errors": "task status not defined",
}
```

## Sum of Even Number
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