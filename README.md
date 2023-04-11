# Lucky_Hotel

Fundamental of Programming Group Project

Requirements and Explanation of the assigned project
Our project requires us to do a hotel system that allows users to book the room and admin to manage the room.<br>
In the booking system, the user should be able to:<br>
● Register an account<br>
● Login to the account<br>
● Reset password<br>
● View the rooms<br>
● Sort the rooms<br>
● Book the room if the date selected is available<br>
● Make transactions<br>
● Review the room<br>

In the management system, the administrator should be able to:<br>
● Login to admin account<br>
● Edit the details of the room<br>
● Add new rooms<br>

Description for the solution<br>
Login<br>
signUp<br>
Users are required to enter their personal information which are name, gender, birthdate, phone number, email, password, password reconfirmation, security question and the answer to sign up a new account.
<br>
<img width="460" alt="Lucky Hotel Sign Up" src="https://user-images.githubusercontent.com/77392505/231104115-8b1c5f00-d6c7-4afe-b6c4-3c3d8bba3a3e.png">
<img width="458" alt="Lucky Hotel Sign Up 3" src="https://user-images.githubusercontent.com/77392505/231104410-3ec42a5e-257d-4021-9454-5b2d75ab636e.png">
<img width="460" alt="Lucky Hotel Sign Up 1" src="https://user-images.githubusercontent.com/77392505/231104134-753796b4-9119-4905-a8cc-20af6f2af2e7.png">
<img width="461" alt="Lucky Hotel Sign Up 2" src="https://user-images.githubusercontent.com/77392505/231104142-4e89306c-aa8e-4993-a4d9-56afe4fb81f4.png">

Login
<br>
Users need to enter their email and password and choose the user type which consists of customer and admin. Users are not able to proceed to the next page if the email, password or user type entered are incorrect.
<br>
<img width="461" alt="image" src="https://user-images.githubusercontent.com/77392505/231104941-d6d9ee5f-60d6-4553-8684-332b9d62adb0.png">

ForgotPassword
<br>
This class allows the user to reset their password by answering the security question they chose during the sign up process.
<br><br>
EmailReset
<br>
If the users have forgotten their answer for the security question, they can reset their password by using email. In this class, users need to enter their email address and a confirmation code will be sent to their email.
<br><br>
EmailReset2
<br>
After users enter the confirmation code, they are allowed to reset their password.
<br>
<img width="460" alt="image" src="https://user-images.githubusercontent.com/77392505/231105367-b2e5a1b6-d0c9-420b-9eda-17519bbe4663.png">
<img width="458" alt="image" src="https://user-images.githubusercontent.com/77392505/231105404-6ae6ff13-801f-4a83-8310-60fba5a7c39d.png">
<img width="460" alt="image" src="https://user-images.githubusercontent.com/77392505/231105491-65ca6c16-cb8a-468e-a40b-3a4807010ac1.png">

User
<br>
AdminPage
<br>
Admin can choose to manage the rooms and check the check in or check out records.
<br>
<img width="456" alt="image" src="https://user-images.githubusercontent.com/77392505/231108441-49e09a4b-4584-4f8b-8ca2-fd0f0d1d5f86.png">

ChangePassword<br>
The users can change their existing passwords by entering their old passwords for confirmation purposes and then key in their new passwords.
<br>
<img width="459" alt="image" src="https://user-images.githubusercontent.com/77392505/231107251-f5ced19d-74ed-4497-b874-b68c0f29d6b9.png">

customerPage<br>
This class accumulates all functions which the users can choose to change their profiles or password, view the room list and history(check their previous booking room and give reviews), search and book available rooms.
<br>
<img width="459" alt="image" src="https://user-images.githubusercontent.com/77392505/231107135-09cee17b-ef49-490e-be86-6b7597b7586f.png">

UpdateProfile<br>
The users can update and save their personal details, including their names, genders, birthdates and phone numbers after logging into their accounts.
<br>
<img width="459" alt="image" src="https://user-images.githubusercontent.com/77392505/231107197-045a7edd-5027-4ca7-8ab6-d58584e8eef9.png">

Rooms<br>
CheckinRoom<br>
This class used to check in the room when the customer came to the hotel.<br><br>
<img width="458" alt="image" src="https://user-images.githubusercontent.com/77392505/231108574-e2ff345a-edc7-46e2-93ee-9e2b8e95b865.png">

CheckOutRoom<br>
This class used to check out the room when the customer returned the key of the room.<br>
<img width="461" alt="image" src="https://user-images.githubusercontent.com/77392505/231108636-777de7cb-9d9e-4253-9ac2-2cece176e8d6.png">

ConfirmBooking<br>
After customer chose the room, this class showe all the details and calculate the total amount should be paid by the customer.<br>
<img width="458" alt="image" src="https://user-images.githubusercontent.com/77392505/231107802-87e67fa9-60c1-4285-af0b-246f2c3732bb.png">

lists<br>
This class gets the information using methods from the RoomAvailable class and adds it to the ArrayList.<br><br>
Room<br>
The administrators can add, update and delete room(s). To add a room, they should at least insert Room ID and price, choose the room type and upload the image to add the room successfully. To prevent the admin upload something else which is not picture, we use:
● FileNameExtensionFilter("*.IMAGE","jpg","gif","png")<br>
● addChoosableFileFilter(filter)<br>
So that others file types will not be recognized.<br>
There is also a jTable to show all the rooms in Lucky Hotel using:<br>
● (DefaultTableModel) jTable1.getModel()<br>
● addRow(new Object[]{rs.getString(1)});<br>
Using these methods, jTable will get data from the database and show it row by row.<br>
<img width="457" alt="image" src="https://user-images.githubusercontent.com/77392505/231108515-d96dd264-0a3a-448c-b28f-07e8f153b98a.png">

RoomAvailable<br>
This class consists of instance variables, constructor and getter methods. The class is used to get the room information for the Roomlist class and SearchRoom class, so that we do not have to have the similar code in two different classes.<br><br>
Roomlist<br>
This class shows all the rooms in Lucky Hotel using jTable, the customers are allowed to sort ascending and descending according to the condition they choose, which are Amount of Guests, Amount of Bed, Price and Rating.<br>
<img width="460" alt="Lucky Hotel Sample" src="https://user-images.githubusercontent.com/77392505/231101964-a7d9e424-6f10-44b4-865e-adfb694756ed.png">
<br>
SearchRoomCondition<br>
Let the customers type in the room id which was previously shown in the Roomlist. Customers are also required to choose the check in and check out date before viewing the details of the room.<br>
<img width="419" alt="image" src="https://user-images.githubusercontent.com/77392505/231107545-09fc5f04-fece-45da-a8a2-9e83f2270925.png">

SearchRoom<br>
This class shows the details or information of the room and checks the availability of the room so that duplicate appointments will not occur. If the room is not available during the date the customers chose, then they are not allowed to press the BOOK button.<br>
<img width="458" alt="image" src="https://user-images.githubusercontent.com/77392505/231107630-98859abe-fbc7-47a2-8b74-5fa6bc4496ff.png">

TheModel<br>
This TheModel class is created with a few methods, such as getter methods to reduce the duplicated code when showing the data extracted from the database to the jTable<br><br>
Transaction<br>
transactionList<br>
A class that contain all the variables needed for transaction which are String roomid, String roomtype, double total_pay, int noOfDay, Date checkindate, Date checkoutdate, Timestamp datetimeTransaction.<br><br>
transactionHistory<br>
This class shows all the transactions information in Lucky Hotel using jTable, the information are based on transactionList class and admin are allow to generate invoice to customers.<br>
<img width="461" alt="image" src="https://user-images.githubusercontent.com/77392505/231108244-ee623eb8-05d5-4ba5-b4f1-96b9d9759c03.png">
Transaction<br>
This class will show a page for users to enter the information for the transaction which are their credit card numbers, name on cards, credit card types, CCV numbers and expiration date of the cards as proof for the transaction. User should also enter the amount of the transaction for booking. If the amount is enough, the transaction is successful and the room will reserve for the customer and will not available for booking between the date.<br>
<img width="457" alt="image" src="https://user-images.githubusercontent.com/77392505/231108119-0933db8b-a73d-432b-907a-d1cfbab3130d.png">


Review<br>
Rating<br>
Users are required to rate from 1 to 5 and write a comment for the room. The data input by the users will be saved in the online database. The average rating and comments of each room will be shown in the roomlist.<br><br>
Service<br>
All the java files in this package assisting in updating the database, used to reduce the code reusability and also help in setting up the whole database.<br><br>

We also use Online Database for this projects.<br>
<img width="460" alt="image" src="https://user-images.githubusercontent.com/77392505/231108799-14af8caf-a7cb-462c-9ae8-6ea55744d210.png">
