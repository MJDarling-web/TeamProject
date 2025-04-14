# GET /services/locations/{locationId}

Returns data about a location by ID in JSON.

## Error Response:

* **Status Code:** 404
* **Content:**  
  {
  "error": "Location not found"
  }

## Success Response:

* **Status Code:** 200
* **Content:**

```json
{
  "id": 1,
  "locationName": "Capitol Steps",
  "description": "Great night shots when the building is lit up.",
  "city": "Madison",
  "state": "WI",
  "subject": {
    "id": 1,
    "subjectName": "architecture"
  },
  "coordinates": {
    "latitude": 43.0747,
    "longitude": -89.3841
  },
  "images": [
    {
      "id": 1,
      "imageUrl": "https://example.com/photo1.jpg",
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