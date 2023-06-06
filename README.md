
# Student - Spring Boot

This API is made to post, get, delete, and put students into a SQL data base. It's based in MVC with the layers of Controller, Service and Domain.


## API Reference

#### Get all students

```http
  GET /api/v1/students
```

#### Post students

```http
  POST api/v1/saveStudents
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Required**. Student' name |
| `email`      | `String` | **Required**. Studen's email |
| `dob`      | `LocalDate` | **Required**. Student's date of birth |

#### Put students

```http
  PUT /api/v1/{studentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `studentId`      | `Long` |  Student's id |
| `name`      | `String` | **Required**. Student' name |
| `email`      | `String` | **Required**. Studen's email |

#### Delete a student 

```http
  DELETE /api/v1/deleteStudents/
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `studentId`      | `Long` |  Student's id |










