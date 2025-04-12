# GET /services/locations/{locationId}

Returns data about a location by ID in JSON.

## Error Response:

* **Status Code:** 400
* **Content:**  
  `Location ID 99 is invalid.`

## Success Response:

* **Status Code:** 200
* **Content:**

```json
{
  "id": 1,
  "name": "Capitol Steps",
  "description": "Great night shots when the building is lit up.",
  "city": "Madison",
  "state": "WI",
  "subject": "architecture",
  "latitude": 43.0747,
  "longitude": -89.3841,
  "images": [
    {
      "id": 1,
      "url": "https://example.com/photo1.jpg",
      "caption": "Golden hour"
    }
  ]
}

```

* Sample curl:

  ```
  curl --request GET http://localhost:8080/urbanPhotography_war/services/locations/1
  ```

* Sample request in browser:

  ```
  http://localhost:8080/urbanPhotography_war/services/locations/1
  ```