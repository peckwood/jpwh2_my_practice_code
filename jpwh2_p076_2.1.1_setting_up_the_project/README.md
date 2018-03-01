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

1. Start HSQL
   1. If you only have hsqldb jar downloaded from Maven, go inside `C:\Users\lonelythinker\.m2\repository\org\hsqldb\hsqldb\2.4.0` and executed the following command `java -classpath hsqldb-2.4.0.jar org.hsqldb.Server`
   2. or download HSQLDB from its official website and run `runServer.bat`
2. run the main method inside HelloWorld

### Choices:

1. 3 types of configuration
   1. Hibernate **XML Configuration**
      1. Using **hibernate.cfg.xml** instead of hibernate.properties
   2. Hibernate 
2. Configure and use Hibernate **without** Spring
3. **C3P0** Connection pool
4. **HSQL** database, an open-source in-memory database
5. Maven and Hibernate instead of Ant