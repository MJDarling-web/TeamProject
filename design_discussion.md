# Design Discussion 04/02/25

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



## Requests


### GET

http://localhost:8080/services/locations/{locationId} - Finds location by id


http://localhost:8080/services/locations - Finds all locations

http://localhost:8080/services/locations?city=cityName&state=stateAbrv - Finds location by city & state

http://localhost:8080/services/locations?subjects=Lake,Nature - Finds locations by subject

|Parameter|Description|Type/Format| Required |
|---|---|---|---|
|city|City the location resides in|string| No|
|state|Abbreviated state the location resides in. For example "WI"|string| No|
|subjects|Subjects that are related to the location|string(s) comma separated| No|


---

### POST

http://localhost:8080/services/locations -  Add a new location<br>

http://localhost:8080/services/locations/{locationId}/images - Uploads an image to the Location<br>

---

### PUT 
http://localhost:8080/services/locations/{locationId} - Updates an existing location

http://localhost:8080/services/locations/{locationId}/images - Updates an image to the Location<br>

---

### DELETE
http://localhost:8080/services/locations/{locationId} - Deletes an existing location

http://localhost:8080/services/locations/{locationId}/images/{imageId} - Deletes an image url from an existing location

---


## Entities

<details>
<summary><strong>Location</strong></summary>

- private String locationName;
- private String city;
- private String stateCode;
- private Coordinates coordinates
- private String bestTime;
- private String description;
- private String Subject;
- private List\<String> images;
</details>

<details>
<summary><strong>Coordinates</strong></summary>

- private double latitude;
- private double longitude;
</details>

## Database
* [Option 1 Diagram](db/db_design_option1.png)
* [Option 1 SQL](db/createTablesOp1.sql)
* [Option 2 Diagram](db/db_design_option2.png)
* [Option 2 SQL](db/createTablesOp2.sql)

## Subject Categories
| ID | Subject Name    |
|----|-----------------|
| 1  | Nature          |
| 2  | Lake            |
| 3  | Urban           |
| 4  | Architecture    |
| 5  | Cityscape       |
| 6  | People          |
| 7  | Wild Life       |
| 8  | Sun Rise        |
| 9  | Sun Set         |
| 10 | Street Art |

## Best Time Categories
| ID | Best Time Name |
|----|----------------|
| 1  | Morning        |
| 2  | Afternoon      |
| 3  | Evening        |
| 4  | Golden Hour    |
| 5  | Night          |