# PUT /services/locations/{locationId}/images/{imageId}

## Description
Updates an image of a location

## Request body params (JSON)

| Parameter Name | Description          | Type/Format                           | Required/Optional |
|----------------|----------------------|---------------------------------------|-------------------|
| imageUrl       | The url for the image | String                                | Required          |

## Request body example:
```json
{
  "imageUrl": "https://example.com/new-photo.jpg"
}
```

## Error Response:
* Status code 404
* Content:
```json
{
  "error": "Image not found for the given location"
}
```

## Error Response:
* Status code 400
* Content:
```json
{
  "error": "Property 'imageUrl' is missing."
}
```

## Success Response:
* Status code 200
* Content:
```json
{
  "message": "Image updated successfully"
}
```
* Sample curl:
```
curl --request PUT \
  --url http://localhost:8080/urbanPhotography_war/services/locations/4/images/2 \
  --header "Content-Type: application/json" \
  --data '{
    "imageUrl": "https://example.com/new-photo.jpg",
  }'
```

