# POST /services/locations

## Description
Adds a new location

## Request body params (JSON)

| Parameter Name | Description              | Type/Format                           |Required/Optional|
|----------------|--------------------------|---------------------------------------|---|
| locationName   | The name of the location | String                                |Required|
... fill out the rest

### Request body example

```json
{
"locationName": "Picnic Point",
"city": "Madison",
"state": "WI",
"coordinates": {
"latitude": 43.0731,
"longitude": -89.3845
},
"bestTime": "Afternoon",
"subject": "Nature",
"description": "Vibrant alley with constantly changing graffiti murals.",
"images": ["url_to_image1"]
}
```

## Error Response:
* Status code 400
* Content:
```
FILL IN IF NECESSARY
```

## Success Response:
* Status code 201
* Content:
```
FILL IN RESPONSE BODY
```