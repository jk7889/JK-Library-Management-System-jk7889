# JK Library Management System (Java based)

<img src="screenshots/interface screenshots/Statistics.PNG" align="center" /> 
<p align="justify"> <b>JK Libray</b> is a fictional library which is collaborating with 4 other fictional libraries namely <b>Willow Creek Regional Library</b>, <b>Hope Community Library</b>, <b>Chandigarh Regional Lobrary</b> and <b>Mumbai State Library</b>. All these fictional libraries have their own service policy (fictional) according to which they don't issue books for free but charge a fee and also sell books. These libraries use <b>JK Library Management system</b> with a <b>straightforward</b>, <b>user friendly</b> interface and an <b>uncomplicated data management</b> and <b>maintenance</b> procedure to fulfill their libary management needs.</p>

## Dasboard
* <p align="justify"><b>Users</b> - Only accessible via Administrator Login. User Login does not have this option as users don't have permission to add new users or access information of all users. Only System Admin can add users (library employees) who can then access this system via User Login option</b>
 
* **Records** - Used to add, access and manage book rent and purchase transactions for each library customer

* **Customers** - Used to store customer information such as name, address, email, city, phone_number 

* **Books** - Used to store book information for all the books available in the libarary

* **Numbers** - Used to access various counts for books_rented_or_purchased_per_customer, books_rented_per_customer, books_purchased_per_customer, books_per_author to find information regarding customers who rent most/least or buy most/least or authors with most/least books in JK Library

* <p align="justify"><b>Statistics</b> - Shows total counts for books, books rented, books purchased, members (library employees/users of this system), customers, system_admins (library tech employees who have access to the complete database), money earned, money earned from rent, money earned from purchase.</p>

* **Logout** - To exit the system and back to login page 

## Functionalities
* **Administrator Login** - For JK library system administrator

* **User Login** -  For other JK library and the collaborating libraries employees

* **Table** - To display the whole table

* **Add** - To add new records, customers, books and users(in case of system admin)

* **Delete** -  To delete records, customers, books and users based on their respective id or s_no(in case of record)

* **View** - To access information regarding a particular record, customer, book or user. It displays all the information for a particular record in the JTextField as well as the table. Also used for the purpose of updating the same.

* **Save** - To save changes after making changes to a particular record in the JTextField. The only column that cannot be updated is Id in all tables (except record) and s_no (in record) to maintain referential integrity

* **Search** - To serach any text in the table. Eg. "Rent" in Search TextField shows all values with "Rent" in record

* **Reset** - To clear all JTextFields 

## Associations and checks
* **Users** - Before adding and updating a new user, the code makes sure that 
>  password and confirm password are same for the user to be added
* **Records** - Before adding and updating a record, the code checks a few things <br>
>  1) If the customer_id entered by the user already exists in customers table then the customer_name associated with the entered ID is added to record
>  2) If the customer_name entered by the user already exists in customers table but customer_id doesn't then the customer_id associated with entered name is added to record
>  3) If both customer_id and customer_name entered by the user does not exist in customers table then this id and name is not only added to the record table but also to customers table
>  4) If charge field is left empty then the default value 10 is added to record
>  5) If the book_id entered by the user exists in the books table, only then the book_name associated with the enetered book_id gets added to the record table otherwise an alert is issued
>  6) If both issue date and return date fields are left empty (when Rent is selected) then the current_date is added as date_of_issue and the date 3 days after the current date is added as date_of_return to record table
>  7) If issue date is left empty (when Purchase) is selected then current_date is added as date_of_issue (which is date_of_purchase in this case)
 
* **Customers** - On updating a row in customers table, the code 
>  updates all instances of that customer in record table as well. Eg. on updating joel khosla to jenna khosla in customers, all rows in record table having name joel khosla will be updated to jenna khosla

* **Books** - On updating a row in books table, the code 
>  updates all instances of that book in record table as well. 

## How to run the project in Eclipse?
**Step1:** Open **JK-Library-Management-System-jk7889** on Github > Code> Copy URL <br>

**Step2:** Open Eclipse: File > Import > Git > Projects from Git > Clone URI > Paste copied URL as `https://github.com/jk7889/JK-Library-Management-System-jk7889.git` > Next <br>

**Step3:** After the above steps, Eclipse will ask for your GitHub login details if you are importing a project from GitHub for the first time <br>

**Step4:** User: `Your GitHub Username`, Password: `Your Personal Access Token for GitHub` <br>

**Step5:** Follow the import prompts and finally click finish 

## What to do after the project gets successfully imported in Eclipse?
**Step1:** Open any MySQL DBMS > run **"JK Library Management System.sql"** <br>

**Step2:** Open Access.java in Eclipse > Username = `Enter Your MySQL DBMS Username`, Password = `Enter Your MySQL DBMS Password` <br>
```
public class Access {
static public String Username = "Your MySQL Username";
static public String Password = "Your MySQL Password";
}
```

**Step3:** Open Firstpage.java in Eclipse > Run > Administrator Login > Administrator ID: `137691`, Password: `password` > Submit <br>

<img src="screenshots/interface screenshots/Admin_Login.PNG" align="center" />

**Step4:** Click Users > Table, then complete system_users table will be displayed <br>

<p><img alt="gif" src="https://github.com/jk7889/JK-Library-Management-System-jk7889/blob/main/screenshots/Table.gif" /></p>

**Step5:** Similarly you can click Table button in `Records`, `Customers` and `Books` Panels to display their respective tables <br>

**Step6:** Then you can add values shown in the screenshots using the `Add` button 

## How to Add values?

<p><img alt="gif" src="https://github.com/jk7889/JK-Library-Management-System-jk7889/blob/main/screenshots/Add.gif" /></p>

## How to Delete values?

<p><img alt="gif" src="https://github.com/jk7889/JK-Library-Management-System-jk7889/blob/main/screenshots/Delete.gif" /></p>

## How to View a particular value?

<p><img alt="gif" src="https://github.com/jk7889/JK-Library-Management-System-jk7889/blob/main/screenshots/View.gif" /></p>

## How to update a value?

<p><img alt="gif" src="https://github.com/jk7889/JK-Library-Management-System-jk7889/blob/main/screenshots/Save.gif" /></p>

## How to search a table?

<p><img alt="gif" src="https://github.com/jk7889/JK-Library-Management-System-jk7889/blob/main/screenshots/Search.gif" /></p>

## Exercise
Try to add some values shown in the screenshots to any table in this project using **JK Library Management System** <br><br><br>

### "Suggestions and project improvements are invited!"	:grinning:
