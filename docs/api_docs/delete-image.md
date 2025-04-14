# DELETE /services/locations/{locationId}/images/{imageId}

## Description
Deletes an image by id

## Error Response:
* Status code 404
* Content:
```
{"error": "Location not found"}

OR

{"error": "Image not found for this location"}
```

## Success Response:
* Status code 200
* Content:

```
{"message": "Image ${imageId} deleted successfully for location ${locationId"}
```