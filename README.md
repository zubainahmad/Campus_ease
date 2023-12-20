# Campus_ease
Api for college project 
</br>
</br>
## Post a Job
```
curl --location 'https://campus-ease.onrender.com/jobs' \
--header 'Content-Type: application/json' \
--data '{
    "companyName" : "ABC",
    "jobDescription" : "This job is for software development",
    "jobProfile" : "SDE",
    "expCTC" : "500000",
    "regLink" : "https://ajdk.com/page",
    "startDate" : "31/07/2023",
    "endDate" : "31/12/2023",
    "file" : "https://ajflka.com",
    "branch" : "EE"
}'
```
## Add a student
```
curl --location 'https://campus-ease.onrender.com/student' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId" : fkjsnfkljanjfknd,
    "firstName" : "ABC",
    "lastName" : "XYZ",
    "rollNumber" : "20039473974983",
    "collegeAdmissionNumber" : "20PQR958340",
    "email" : "wxam@gmail.com",
    "branch" : "CS",
    "SGPA" : "9.0",
    "percentage" : "94"
    
}'

```
## Update a student
```
curl --location --request PUT 'https://campus-ease.onrender.com/student' \
--header 'Content-Type: application/json' \
--data-raw '{
     "userId" : fkjsnfkljanjfknd,
    "firstName" : "ABC",
    "lastName" : "XYZ",
    "rollNumber" : "20039473974983",
    "collegeAdmissionNumber" : "20PQR958340",
    "email" : "wxam@gmail.com",
    "branch" : "CS",
    "SGPA" : "9.0",
    "percentage" : "94"
    
}'
```

## Check student exists or not
```
curl --location 'https://campus-ease.onrender.com/student/f4760eb9-c897-426f-8aec-c93205a07172'
```

## Get a Job
jobs/{user_id}
</br>
```
curl --location 'https://campus-ease.onrender.com/jobs/f4760eb9-fkajflika' \
--data ''
```

## Fill a job
</br>

```
curl --location 'https://campus-ease.onrender.com/jobs/submit' \
--header 'Content-Type: application/json' \
--data '{
    "userId" : "jfjalkfjalokjfk",
    "jobId" : 67
}'

```





