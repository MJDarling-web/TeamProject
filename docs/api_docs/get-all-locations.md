# GET /services/locations

## Description
Returns all photography locations in the database.

## Params
* `city` (optional) — filter by city
* `state` (optional) — filter by state
* `subject` (optional) — filter by subject
  * Example: `/services/locations?city=madison&state=wi&subject=nature`

## Success Response:
* **Status Code:** 200
* **Content:**

```json
{
  "locations": [
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
    },
    {
      "id": 2,
      "name": "Lakeshore Path",
      "description": "Beautiful nature trail along Lake Mendota.",
      "city": "Madison",
      "state": "WI",
      "subject": "nature",
      "latitude": 43.0831,
      "longitude": -89.4101,
      "images": []
    }
  ]
}

```

* Sample curl:

  ```
  curl --request GET http://localhost:8080/urbanPhotography_war/services/locations
  ```

* Sample request in browser:

  ```
  http://localhost:8080/urbanPhotography_war/services/locations
  ```