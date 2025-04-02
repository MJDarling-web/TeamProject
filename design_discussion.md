# Design Discussion 04/02/25

## Resources

### Location

|Property|Description|Type/Format|
|---|---|---|
|id|Unique identifier|number|
|locationName|Name of the location. For example "Picnic Point"|string|
|city|City the location resides in|string|
|state|Abbreviated state the location resides in. For example "WI"|string|
|coordinates|Includes latitude and longitude location is at|object|
|bestTime|The best time to photograph here. Choices are "morning", "afternoon", evening"|string|
|description|The description of the location|string|
|subjects|The subject categories a location falls into. See subject categories for details|array of strings|
|images|The image URLs associated with the location.|array of strings|




## Requests


### GET

http://localhost:8080/services/locations/{locationId} - Finds location by id


http://localhost:8080/services/locations - Finds all locations

http://localhost:8080/services/locations?city=cityName&state=stateAbrv - Finds location by city & state

http://localhost:8080/services/locations?subjects=Lake,Nature- Finds locations by subject

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
- private List\<String> subjects;
- private List\<String> images;
</details>

<details>
<summary><strong>Coordinates</strong></summary>

- private double latitude;
- private double longitude;
</details>

## Database
* [Option 1 Diagram](db/photo_chasers_db_design.png)
* [Option 1 SQL](db/createTables.sql)

## Subject Categories?
|ID|Subject Name|
|--|------------|
|1| TBD|

## Best Time Categories?
|ID| Best Time Name |
|--|----------------|
|1| TBD            |