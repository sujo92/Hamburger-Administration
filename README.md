# Hamburger-Administration

Provides service for adding menu item, reservation, store location to administrator.


## Endpoints:

### Menu:
 - POST: http://localhost:8090/menu - to add new entry in menu
 - GET: http://localhost:8090/menu - to get all items in menu sorted by category and then sorted by menuId
 - DELETE: http://localhost:8090/menu/{menuId} - to delete entry in menu
 - PUT: http://localhost:8090/menu/{menuId} - to update menu by its id

 ### Reservations:

- POST: http://localhost:8090/reservations - to make reservation
- DELETE: http://localhost:8090/reservations/{reservationId} : to vancel reservation
- GET: http://localhost:8090/reservations - get all reervations sorted by date and time
- GET: http://localhost:8090/reservations/{reservationId} - to get details of provided reservationId
- PUT: http://localhost:8090/reservations/{reservationId} - to update reservation entry

 ### Lacation:

 - POST: http://localhost:8090/api/locations -to add new location 
 - GET: http://localhost:8090/api/locations - to get all locations
 - GET: http://localhost:8090/api/locations/{id} - to get entry of particular locatioId
 - PUT: http://localhost:8090/api/locations/{id} - to update Location entry
 - DELETE: http://localhost:8090/api/locations/{id} - to delete given location
