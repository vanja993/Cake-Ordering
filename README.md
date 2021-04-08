# Cake-Ordering

Cake ordering system project in Java with MySQL, JDBC and Swing, where a small business can manage their costumer’s order.

-------------
Requirements:
-------------

Java Development Kit (JDK): https://www.oracle.com/java/technologies/javase-jdk16-downloads.html 

Eclipse IDE: https://www.eclipse.org/downloads/

(or other Integrated Development Environment (IDE), such like IntelliJ IDEA) 

MySQL Database Community Server: https://dev.mysql.com/downloads/mysql/ (MySQL Workbench included).

MySQL Connector/J (JDBC driver):https://dev.mysql.com/downloads/connector/j/

----------
Execution:
----------
After extracting a Cake-Ordering file and opening an Eclipse IDE, you should import a project from file system to  Project Explorer. Go to File->Open Project From File System and click on the Directory button next to import source text field. Find a folder where you extracted the file, select folder CakeFactory and click Finish.  

Right click on CakeFactory in Project Explorer and go to properties.  In Java Build Path go to Libraries and click on Add External JARs. There are two jar files that you will need. First one is jcalendar-1.4.jar which is provided in Cake-Ordering file and second one is mysql-connector-java-8.0.23.jar which is in your  mysql-connector-java-8.0.23 folder where you extracted it. When you add these two jar files , go to “Apply” and then “Apply and Close” 

Go to MySQL Workbench and connect to MySQL server on the local mashine. Create a database called “costumers”. This database shoud contain three tables: 

1.admintable :

| idNumber | username | password | 
|----------|-----------|---------|

idNumber : INT PK NN

username : VARCHAR (45)

password : VARCHAR (45)

2.costumerstable:

| costumer_Number | firstName | lastName | idNumber | contactNumber |
|-----------------|------------|-----------|-----------|------------|

costumer_Number : INT PK NN

firstName, lastName, idNumber, contactNumber : VARCHAR(45)

3.caketable

| idcake | shape | size | tier | sponge | cream | jam | fruit | topping | day | address | decor |
|--------|-------|------|------|--------|-------|-----|-------|---------|-----|---------|-------|

idcake : INT PK NN

shape, size, teir, sponge, cream, jar,fruit, toping, day,addres : VARCHAR(45)

decor : VARCHAR(1000)

This is everything you will need in order to start a program. 

------------------------
Working with applicaton:
------------------------

In Project Explorer go to CakeFactory->src->default package->Main.java. To run a java file click on a run button(green circle with an arrow in toolbar). First frame that appears is a MySQL connection. In Server text field type:  
jdbc:mysql://localhost:3306/costumers 
Username and password text fields are your username and password of connection to MySQL server. 

Clicking on Next button a Login frame will appear.  Username and password text fields are for the people who will have access to cake ordering management. At first, there will be non, so go to SignUp button and fill up the text fields. You can add as many people as you want, and their informations are saved in “admintable”. With that informations you can login to Loby Page which is the next frame.

In Loby Page you will have two options:  

  1.Find costumer: opens a list of costumers. Clicking on any costumer of the list you will have two options, to delete them or to see their order. Back button will bring you back to Loby Page. 

  2.Add costumer: opens a frame where you should put costumer’s personal informations like first and last name, their ID and contact number. This text fields can not be empty. Create button will create a new costumer and open a Costumer’s order frame. There you can create a costumer’s order by picking a shape, size and number of tiers. You can select a sponge and cream filling flavors from drop list. Then you will have an option to put jam or fruit. These options will be enabled when you check a button. For toppings you can choose between a fondant and frosting. Decoration text area is for description of cake decoration, like cake color, designs, text, etc... Delivery panel contains a calendar where you choose a day of delivery. You can also choose if costumer wants a home deliver
