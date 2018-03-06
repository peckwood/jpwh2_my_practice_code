### Steps to develop the project

1. create a maven quickstart project
2. add dependencies, those first 3 dependencies are minimum dependencies
3. add `hibernate.cfg.xml` in resources folder, the root of classpath
4. Create the domain model. Add entity class `com.raidencentral.hello.Message`, and make sure to write a default constructor as hibernate uses reflection on this constructor to instantiate object.
5. Mapping the class to a database schema. Create `Mesaage.hbm.xml` next to `Message.java` file
6. Add a mapping tag for `Message`'s mapping file inside  `hibernate.cfg.xml`
7. Add other classes like HibernateUtil and HelloWorld
8. add logging

### Steps to run the program:

1. ~~Start HSQL~~
   1. ~~If you only have hsqldb jar downloaded from Maven, go inside `C:\Users\lonelythinker\.m2\repository\org\hsqldb\hsqldb\2.4.0` and executed the following command `java -classpath hsqldb-2.4.0.jar org.hsqldb.Server`~~
   2. ~~or download HSQLDB from its official website and run `runServer.bat`~~
2. Start Mysql @ localhost with username root and password root at port 3307
3. Create an empty database named `jpwh2_p076_2.1.1_setting_up_the_project` if it doesn't exist
2. run the main method inside HelloWorld

### Choices:

1. 3 types of configuration
   1. Hibernate **XML Configuration**
      1. Using **hibernate.cfg.xml** instead of hibernate.properties
   2. Hibernate Programmatic Configuration (<u>not working</u>)(in order to test correctly you have to rename hibernate.properties to something else to ensure pure programmatic configuration)
   3. Read hibernate.properties
2. Configure and use Hibernate **without** Spring
3. **C3P0** Connection pool, hibernate doesn't seem to support Druid natively, but we can use Druid when Spring is integrated.
4. MySQL5.7 ~~**HSQL** database, an open-source in-memory database~~
5. Maven instead of Ant

### About the code

Thrid unit of work shows hibernate's features. 

One is **automatic dirty checking**, update database when an object state is modified. 

Another is **cascading save**, meaning if an object(message "Take me to your leader (please)") is reachable by an already persisted instance(message "Greeting Earthling"), it will be persisted automatically.

Thrd is **transactional write-behind**. 