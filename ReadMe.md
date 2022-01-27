# Course Management System

## Swagger endpoint :
 http://localhost:8080/swagger-ui.html

## API Endpoints

1. GET : http://localhost:8080/api/student/{studentId}

2. POST : http://localhost:8080/api/student/create

RequestBody :
```
{
    "enrollmentNumber":"111",
    "firstName":"www",
    "lastName":"vvv",
    "dateOfBirth":"18-02-1998"
}
```

3. DELETE : http://localhost:8080/api/student/{studentId}

4. PUT : http://localhost:8080/api/student/{studentId}
RequestBody :
```
{
    "enrollmentNumber":"111",
    "firstName":"www",
    "lastName":"vvv",
    "dateOfBirth":"18-02-1998"
}
```

5. GET : http://localhost:8080/api/course/{courseId}

6. POST : http://localhost:8080/api/course/create

Request Body :
```
{
    "courseName":"java2",
    "credits":"25",
    "instructorName":"kkun"
}
```
7. DELETE : http://localhost:8080/api/course/{courseId}

8. PUT : http://localhost:8080/api/course/{courseId}

Request Body :
```
{
    "courseName":"java2",
    "credits":"25",
    "instructorName":"kkun"
}
```

9. POST : http://localhost:8080/api/student/{studentId}/course/{courseId}

10. DELETE : http://localhost:8080/api/student/{studentId}/course/{courseId}

11. GET : http://localhost:8080/api/student/{studentId}/course/

12. GET : http://localhost:8080/api/course/{courseId}/student