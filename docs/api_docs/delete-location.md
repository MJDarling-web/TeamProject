# DELETE /services/locations/{locationId}

## Description
Deletes a location by id

## Error Response:
* Status code 404
* Content:
```
{"error": "Location not found"}
```

## Success Response:
* Status code 200
* Content:

```
{"message": "Location ${locationId deleted succesfully"}
```