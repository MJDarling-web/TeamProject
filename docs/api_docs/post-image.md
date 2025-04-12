### POST /services/locations/{locationId}/images

Adds an image to an existing location.

* Data Params

| Parameter Name | Description                    | Type/Format | Required/Optional |
|----------------|--------------------------------|-------------|-------------------|
| imageUrl       | The URL of the image           | string      | Required          |
| caption        | A short caption for the image  | string      | Optional          |

* Error Response:
    * **Status Code:** 400
    * **Content:**  
      `Property 'imageUrl' is missing.`

* Success Response:
    * **Status Code:** 200
    * **Content:**
      ```
      Image added to location 4: (imageUrl = https://example.com/picnic-point-sunset.jpg, caption = Sunset at Picnic Point)
      ```

* Sample curl:

    ```
    curl --request POST \
      --url http://localhost:8080/urbanPhotography_war/services/locations/4/images \
      --header "Content-Type: application/json" \
      --data '{
        "imageUrl": "https://example.com/picnic-point-sunset.jpg",
        "caption": "Sunset at Picnic Point"
      }'
    ```