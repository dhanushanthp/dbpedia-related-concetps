dbpedia-related-concetps
========================
This application has been developed to find the meaning full related phrases.

**For example:**

*If you search for* **obama** *the result will be, *

- President of the United States
- Member of the Illinois Senate
- Author
- Constitutional law
- Lawyer
- Community organizing
- Kwame_Raoul
- Roland_Burris
- Honolulu
- Hawaii
- U.S.
- White_House
- Chicago
- Illinois
- Nobel Peace Prize
- Barack Obama
- Dreams from My Father
- The Audacity of Hope

So the result that has been given contain occupation, status, books written by him, etc. The sample test file has been added to test the application.

Installation
--------------
####Create db-conf folder in /opt directory
```sh
mkdir /opt/db-conf
chmod 777 /opt/db-conf
```

Move the ```relation.properties``` file to ```/opt/db-donf ``` folder

####Set the db-conf folder as a  classpath.
```sh
export CLASSPATH=$CLASSPATH:/opt/db-conf
```
git clone [url]

*go to project folder and :* 
``` mvn install ```
