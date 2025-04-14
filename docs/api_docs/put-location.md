# PUT /services/locations/{locationId}

## Description
Updates a location by id

## Request body params (JSON)

| Parameter Name | Description              | Type/Format                           | Required/Optional |
|----------------|--------------------------|---------------------------------------|-------------------|
| locationName   | The name of the location | String                                | Optional          |
| city           | City where the location is                            | string      | Optional          |
| state          | State where the location is                           | string      | Optional          |
| latitude       | Latitude coordinate (e.g., 43.0731)                   | number      | Optional          |
| longitude      | Longitude coordinate (e.g., -89.3845)                 | number      | Optional          |
| bestTime       | Best time of day to shoot (e.g., "Morning")           | string      | Optional          |
| subject        | Subject type (e.g., "Nature", "Urban", "Architecture")| string      | Optional          |
| description    | Description of the location                           | string      | Optional          |


## Request body example:
```json
{
  "locationName": "Lakeshore Path",
  "city": "Madison",
  "state": "WI",
  "latitude": 43.0831,
  "longitude": -89.4101,
  "bestTime": "Morning",
  "subject": "Nature",
  "description": "Beautiful nature trail along Lake Mendota."
}
```

## Error Response:
* Status code 400
* Content:
```json
{
  "error": "Invalid input data"
}
```
## Error Response:
* Status code 404
* Content:
```json
{
  "error": "Location not found"
}
```

## Success Response:
* Status code 200
* Content:

```json
{
  "error": "Location updated successfully"
}
```

```
    curl --request POST \
--url http://localhost:8080/urbanPhotography_war/services/locations/2 \
--header "Content-Type: applicaiton/json" \
--data '{
    "locationName": "Lakeshore Path",
    "city": "Madison",
    "state": "WI",
    "latitude": 43.0831,
    "longitude": -89.4101,
    "bestTime": "Morning",
    "subject": "Nature",
    "description": "Beautiful nature trail along Lake Mendota."
  }'
```