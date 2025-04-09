# API Documentation

## Resources

### Location

|Property| Description                                                                    |Type/Format|
|---|--------------------------------------------------------------------------------|---|
|id| Unique identifier                                                              |number|
|locationName| Name of the location. For example "Picnic Point"                               |string|
|city| City the location resides in                                                   |string|
|state| Abbreviated state the location resides in. For example "WI"                    |string|
|coordinates| Includes latitude and longitude location is at                                 |object|
|bestTime| The best time to photograph here. Choices are "morning", "afternoon", evening" |string|
|description| The description of the location                                                |string|
|subject| The subject category a location falls into. See subject categories for details |string|
|images| The image URLs associated with the location.                                   |array of strings|

### JSON
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

## Service Endpoints

| Method | URI                                                                                | Description              |
|--------|------------------------------------------------------------------------------------|--------------------------|
| GET    | [/services/locations](docs/api_docs/get-all-locations.md)                          | Returns all locations    |
| GET    | [/services/locations/{locationId}](docs/api_docs/get-location-by-id.md)            | Returns location by id   |
| POST   | [/services/locations](docs/api_docs/post-location.md)                              | Adds a new location      |
| POST   | [/services/locations/{locationId}/images](docs/api_docs/post-image.md)             | Adds an image to a location |
| PUT    | [/services/locations/{locationId}](docs/api_docs/put-location.md)                  | Updates a location by id |
| PUT    | [/services/locations/{locationId}/images/{imageId}](docs/api_docs/put-image.md)    | Updates an image of a location |
| DELETE | [/services/locations/{locationId}](docs/api_docs/delete-location.md)               | Deletes a location       |
| DELETE | [/services/locations/{locationId}/images/{imageId}](docs/api_docs/delete-image.md) | Deletes an image of a location |

## Subject Categories
| ID | Subject Name    |
|----|-----------------|
| 1  | Nature          |
| 2  | Architecture    |
| 3  | Wildlife        |
| 4  | Abstract        |
| 5  | Cityscape       |
| 6  | Historical      |
| 7  | Waterfront      |
| 8  | Night           |
| 9  | Murals          |
| 10 | Cultural        |
| 11 | Industrial      |
| 12 | Parks           |
| 13 | Minimalism      |
| 14 | Rural           |
| 15 | Urban           |
| 16 | Seasonal        |
| 17 | People          |

## Best Time Categories
| ID | Best Time Name |
|----|----------------|
| 1  | Morning        |
| 2  | Afternoon      |
| 3  | Evening        |
| 4  | Golden Hour    |
| 5  | Night          |

