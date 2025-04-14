### POST /services/locations/{locationId}/images

Adds an image to an existing location.

* Data Params

| Parameter Name | Description                    | Type/Format | Required/Optional |
|----------------|--------------------------------|-------------|-------------------|
| imageUrl       | The URL of the image           | string      | Required          |
| caption        | A short caption for the image  | string      | Optional          |

* Error Response:
    * **Status Code:** 404
    * **Content:**  
      {
      "error": "Location not found"
      }

* Success Response:
    * **Status Code:** 200
    * **Content:**
      ```
      {
      "message": "Image added successfully"
      }
      ```

* Sample curl:

    ```
    curl --request POST \
  --url http://localhost:8080/urbanPhotography_war/services/locations/4/images \
  --header "Content-Type: text/plain" \
  --data 'https://example.com/picnic-point-sunset.jpg'
    ```