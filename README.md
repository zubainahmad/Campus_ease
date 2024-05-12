# Campus_ease
End Points:
</br>
</br>
## Post a Job
```
curl --location 'https://campus-ease.onrender.com/jobs' \
--header 'Content-Type: application/json' \
--data '{
    "companyName" : "Autoscale",
    "jobDescription" : "This job is for software development",
    "jobProfile" : "SDE",
    "expCTC" : "500000",
    "regLink" : "https://ajdk.com/page",
    "startDate" : "31/07/2023",
    "endDate" : "31/12/2023",
    "file" : "https://ajflka.com",
    "branch" : ["EE","CS","IT"],
    "minimumPercentage" : "100",
    "userId":"gssgsdgsgr",
    "websiteUrl": "https://ajdk.com/page",
    "jobLocation" : "Noida"

}'
```
## Add a student
```
curl --location 'https://campus-ease.onrender.com/student' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId" : "fkjsnfkljanjfknd",
    "firstName" : "ABC",
    "lastName" : "XYZ",
    "rollNumber" : "20039473974983",
    "collegeAdmissionNumber" : "20PQR958340",
    "email" : "wxam@gmail.com",
    "branch" : "CS",
    "SGPA" : "9.0",
    "percentage" : "94",
    "imageUrl" : "https://"
    
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
    "percentage" : "94",
    "imageUrl" : "https://" 
    
}'
```

## Get a student

</br>

```
curl --location 'https://campus-ease.onrender.com/students/fkjsnfkljanjfknddvxcbxbxcbffsf' \
--header 'Content-Type: application/json' \
--data ''

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

## Add ccpd

</br>

```
curl --location 'https://campus-ease.onrender.com/ccpd' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"Sanjeeev",
    "userId":"hjsdhkfdssssssfsdfess",
    "lastName":"Bro",
    "email":"naughtybro@abes.ac.in"
}'

```

## Ping

</br>

```

curl --location 'https://campus-ease.onrender.com/ping'

```


## GET all jobs ccpd application

</br>


```
curl --location 'https://campus-ease.onrender.com/jobs'

```



## Get jobs data in ccpd application

</br>

```
curl --location 'https://campus-ease.onrender.com/jobs/data'

```

## GET jobs info in ccpd application

</br>

```
curl --location 'https://campus-ease.onrender.com/jobs/info?id=552&id=553&id=554'

```

## GET jobs info in student application

</br>

```
curl --location 'https://campus-ease.onrender.com/students/jobs/info?id=558'

```

## GET jobs data in student application 

</br>

```
curl --location 'https://campus-ease.onrender.com/students/jobs/data?userId=1'

```

## CSV unregistered

</br>

```
curl --location 'https://campus-ease.onrender.com/download/unregistered?id=552'

```

## CSV registered


</br>

```
curl --location 'https://campus-ease.onrender.com/download/registered?id=552'

```

##  CSV all

</br>

```
curl --location 'https://campus-ease.onrender.com/download/all?id=552'

```

## Students registered for a job

</br>

```
curl --location 'https://campus-ease.onrender.com/students/registered?jobId=552'

```

## Students unregistered for a job

</br>

```
curl --location 'https://campus-ease.onrender.com/students/unregistered?jobId=552'

```

## All eligible students for a job

</br>

```

curl --location 'https://campus-ease.onrender.com/students/all?jobId=552'

```

## Notification all students

</br>

```
curl --location 'https://campus-ease.onrender.com/students/notify/all?jobId=552'

```

## Notification registered students

</br>

```
curl --location 'https://campus-ease.onrender.com/students/notify/registered?jobId=552'

```


## Notification unregistered students

</br>

```
curl --location 'https://campus-ease.onrender.com/students/notify/unregistered?jobId=552'

```






