# MSA-Car_Rental
MSA Spring Boot application for car rental service

## API routes 

### MS Vehicle 
Route | Method | Description
--- | --- | ---|
`http://<host>:<port>/vehicules/` | `GET` | List all vehicles
`http://<host>:<port>/vehicules/{id}` | `GET` | List vehicle by ID
`http://<host>:<port>/vehicules/cm/{id}` | `GET` | Show maintenance state vehicle
`http://<host>:<port>/vehicules/` | `POST` | Add vehicle
`http://<host>:<port>/vehicules/` | `PUT` | Update vehicle
`http://<host>:<port>/vehicules/{id}` | `DELETE` | Delete vehicle by ID
`http://<host>:<port>/vehicules/available/?startDate='{YYYY-MM-DD}'&endDate={YYYY-MM-DD}` | `GET` | List available vehicles based on start- and end date
`http://<host>:<port>/vehicules/?brand={brand}` | `GET` | List vehicles by precised attribute(s)
`&type={vehicle type}`
`&color={color}`
`&fiscalHp={int}` 


### MS Reservation

Route | Method | Description
--- | --- | ---|
`http://<host>:<port>/reservations/` | `GET` | List all reservations
`http://<host>:<port>/reservations/{id}` | `GET` | List reservations by ID
`http://<host>:<port>/reservations/` | `POST` | Add reservation with reservation body
`http://<host>:<port>/reservations/` | `PUT` | Update resveration with given reservation body
`http://<host>:<port>/reservations/{id}` | `DELETE` | Delete reservation by id
`http://<host>:<port>/return/{odometerReturn}` | `PUT` | Calculate surplus based on return mileage / schedule maintenance if needed


### MS Customer

Route | Method | Description
--- | --- | ---|
`http://<host>:<port>/customers/` | `GET` | List all customers
`http://<host>:<port>/customers/{id}` | `GET` | List all customers by ID
`http://<host>:<port>/customers/` | `POST` | Add customer with customer body
`http://<host>:<port>/customers/` | `PUT` | Update customer with given customer body
`http://<host>:<port>/customers/{id}` | `DELETE` | Delete customer by id 
`http://<host>:<port>/customers/getReservations/{id}` | `GET` | List reserved vehicle ID's by customer ID

