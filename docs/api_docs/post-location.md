### POST /services/locations

Adds a new photography location.

* Data Params

| Parameter Name | Description                                           | Type/Format | Required/Optional |
|----------------|-------------------------------------------------------|-------------|-------------------|
| locationName   | Location name, for example "Picnic Point"             | string      | Required          |
| city           | City where the location is                            | string      | Optional          |
| state          | State where the location is                           | string      | Optional          |
| latitude       | Latitude coordinate. For example, 43.0731             | number      | Required          |
| longitude      | Longitude coordinate. For example, -89.3845           | number      | Required          |
| bestTime       | Best time of day to shoot (e.g., "Afternoon")         | string      | Optional          |
| subject        | Photo subject (e.g., "Nature", "Urban")               | string      | Optional          |
| description    | Description of the location                           | string      | Optional          |
| images         | Image URL(s), comma-separated if more than one       | string      | Optional          |

* Error Response:
    * **Status Code:** 400
    * **Content:**  
      `Property 'locationName' is missing.`

* Success Response:
    * **Status Code:** 200
    * **Content:**
      ```
      Location 4 created: (locationName = Picnic Point, city = Madison, state = WI, latitude = 43.0731, longitude = -89.3845, subject = Nature, bestTime = Afternoon)
      ```

* Sample curl:

    ```
    curl --request POST --data "locationName=Picnic Point&city=Madison&state=WI&latitude=43.0731&longitude=-89.3845&bestTime=Afternoon&subject=Nature&description=Vibrant alley with murals&images=https://example.com/image1.jpg" http://localhost:8080/urbanPhotography_war/services/locations
    ```