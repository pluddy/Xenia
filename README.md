# Xenia

Overview:
CSCE 464/864 Spring 2016 Homework One: Introduction to Servlets and JSP Assigned: January 20, 2016
Due: 5.00 PM, February 9, 2016
Points: 100 (464) & 125 (864)
This assignment is intended to familiarize students with web application design, basic servlet functionality, and application deployment with a focus on servlet HTML generation and page navigation.
The goal is to create an MVC-based online hotel management and reservation application. The assignment assumes student’s familiarity with static HTML design and will involve use of JSP pages for the presentation and servlets for the business logic.
This assignment is to be done by a team of two students.
Assignment Description:
Create a hotel management web application that can be used by two types of users: customers and clients. A customer is a user who intends to search for hotels and make reservations. A client is user who manages its hotels, rooms and reservations. Please see the page navigation diagram to get a high-level understanding of the structure of the application.
The client side pages are optional for 464 level students while mandatory for 864 level students. Following pages and the Users class must be implement by both 464 and 864 level students:
• A jsp page (Login.jsp) and java servlet (Login.java) for user login
• A jsp page (Registration.jsp) and java servlet (Registration.java) for new user registration
• A Users java class for managing user accounts
Customer Side Pages (must be implemented by both 464 and 864 level students):
• A jsp page (CustomerHomePage.jsp) for the customer homepage
• A jsp page (ReservationSearchResults.jsp) for viewing the results of a reservation search
query
• A jsp page (View&BookReservations.jsp) for viewing and booking reservations
• A jsp page (ReservationTransaction.jsp) for reservation transaction
• A jsp page (ReservationTransactionConfirmation.jsp) for reservation transaction
confirmation
• A jsp page (ManageReservations.jsp) for managing reservations
• A jsp page (CancelReservations.jsp) for canceling reservations
• A jsp page (ReservationCancellationConfirmation.jsp) for reservation cancellation
confirmation
1
Client Side Pages (must be implemented by 864 level students and optional for 464 level students):
• A jsp page (ClientHomePage.jsp) for the client homepage
• A jsp page (ViewCurrentReservations.jsp) for viewing all the reservations made under
hotels managed by the client
• A jsp page (ClientCreateReservation.jsp) for manually adding a reservation by the client
• A jsp page (ClientReservationTransaction.jsp) for reservation transaction
• A jsp page (ClientReservationTransactionConfirmation.jsp) for manual reservation
transaction confirmation
• A jsp page (ManageHotels.jsp) for managing a client’s hotels
• A jsp page (EditHotelDetails.jsp) for editing a hotel’s details
Detail description of the above mentioned pages are provided below:
• Login jsp page
o Clicking the submit button on the form should call the login servlet. o No session generation of the fields is required for this assignment. o Clicking the registration link should lead to the registration page
• Login servlet
o The set of user names and passwords are saved in a Java Properties file managed
by a java class Users.
o The servlet will validate user login/password through the Users class.
o With a valid user login/password the servlet redirects the user to the Customer
homepage.
o With an invalid user login/password, the servlet redirects the user to the
Registration page. • Registration jsp page
o The page checks if the password and confirmation password match. (client side validation using JavaScript)
o Clicking the submit button on the form should call the Registration servlet.
o No session generation of the fields is required for this assignment. • Registration servlet
o Each registered user’s login/password info will be kept in the Java Properties file used by the login servlet.
o The servlet will save the users’ records through the Users class.
o After inserting the record, the servlet redirects the user to the Login jsp page. • Customer Homepage jsp page
o The page is the welcome page for the customers and can be designed as per the student’s wish.
o It must have accessible links, menus or buttons for navigating to the Manage Reservations page.
2
o It should have logout option upon clicking that takes to the Login page.
o The page must also provide a section where the user can search for reservations.
Description of this section is provided below:
This section contains a set of fields a user can fill before clicking the search button. The fields are:
! Check in date
! Check out date
! Location city
! Number of rooms
! Room type - The room type must be a drop down box with the following
values – Standard, Family, Suite
! Checkbox type controls for selecting amenities consisting of:
! Bathtub in room ! Free breakfast
! Free Wi-Fi
! Gym
! Paid Internet access ! Pool
! Pet friendly
o The section must have a search button which when clicked must lead to the Reservation search results page
• Reservation Search Results jsp page
o This page displays a list of hotels that satisfy the Reservation search query
o For Assignment 1, you should only display random results since no actual query
is being executed
o The random data you generate could be of tabular format with the following
columns:
! Hotel name
! Hotel address
! Hotel description
! Room type
! Hotel rating
! Price per night
! Amenities available
o Each result must have a “View and Book” button to view more details and reserve the rooms
o For this assignment, use placeholder values for all variables
o This page should have a link to the Manage Reservations page
o It should have logout option upon clicking that takes to the Login page.
• View and Book Reservations jsp page
o This page contains more detailed information about the hotel and the room, such
as a full description, user ratings and reviews, distance from nearest ports etc. o The page must have the option to re-select the number of rooms
o For this assignment, use placeholder values for all variables.
3
o Three buttons must appear on this page: the “Select” or “Book” button, the “Back” button and the “Home” button.
o Clicking the “Select” or “Book” button should lead to the Reservation Transaction page.
o This page should have a link to the Manage Reservations page
o It should have logout option upon clicking that takes to the Login page. • Reservation Transaction jsp page
o The selected room information must be displayed. Use placeholder values for this assignment.
o No validation is required for this assignment.
o The page contains the total cost and should allow for entry of credit card
information. Fields must include account holder first name, last name, card type (drop down menu), card number, security code, expiration date (drop down menu) and billing address.
o For this assignment, use placeholder values for all variables.
o This page should have two buttons: “Confirm Reservation” and “Cancel”.
o Clicking the “Confirm Reservation” button should lead to the Reservation
Transaction Confirmation page.
o Clicking the “Cancel” button should lead to the Reservation Search Results page. o This page should have a link to the Manage Reservations page.
o It should have logout option upon clicking that takes to the Login page.
• Reservation Transaction Confirmation jsp page
o The page must display all the information from the transaction page except for the
credit card information
o The page must display a message “Your reservation has been confirmed”.
o The page has a “Home” button that when clicked leads to the Customer Home
page
o This page should have a link to the Manage Reservations page.
o It should have logout option upon clicking that takes to the Login page.
• Manage Reservations jsp page
o This page must display the user’s reservation history
o Use placeholder values for this assignment.
o The page has a “Home” button that when clicked leads to the Customer Home
page.
o Existing reservations (i.e., reservations in the future), must have a “Cancel
Reservation” button which leads to the Cancel Reservations Page.
• Cancel
o This page must display the information regarding the reservation.
o There must be two buttons here: “Confirm Cancellation” and “Cancel”
o The Confirm Cancellation button should lead to the Reservation Cancellation
Confirmation page.
o The Cancel button should lead to the Home page.
o This page should have a link to the Manage Reservations page.
o It should have logout option upon clicking that takes to the Login page.
• Reservation Cancellation Confirmation jsp page
Reservations jsp page
4
o o
o o o
The following as necessary.
This page must display information regarding the reservation, with a status update showing that the reservation has been cancelled.
The equivalent amount of the reservation must be refunded (credited) back to the credit card account that was used to make the reservation.
The page must have a home button that leads to the Home page.
This page should have a link to the Manage Reservations page.
It should have logout option upon clicking that takes to the Login page.
points add information about the client pages. You need to implement the servlets
• Client Home Page jsp page
o The page serves as the welcome page for the clients (or business partners) and can
be designed as per the student’s wish.
o It must have accessible links, menus or buttons for navigating to the Manage
Hotels, View Current Reservations and optionally to the Create Reservations.
o It must provide with a logout option upon clicking that redirects to the Login
page.
• View Current Reservations jsp page
o This page must display all the reservations for all the hotels managed by this client.
o The student can decide how the information is displayed.
o The following data must be clearly visible: Hotel name, room type, number of
rooms, name of the customer, check-in and check-out dates. o Use placeholder values for this assignment.
• Client Create Reservation jsp page
o This page must contain the fields required to select the hotel, number of rooms,
check in and check out dates, room type, first name and last name for the
reservation, phone number and optional email address.
o The student can decide how the field contents are selected (e.g., The hotel name
can be a drop down or search result). • Client Reservation Transaction jsp page
o This page should display the selected room and reservation information.
o The page also contains the total cost and should allow for entry of credit card information. Fields must include account holder first name, last name, card type,
card number, security code, expiration date and billing address.
o For this assignment, use placeholder values for all variables.
o The page should have two buttons: “Create Reservation” and “Cancel”.
o Clicking the “Create Reservation” button should lead to the Client Reservation
Transaction Confirmation page.
o Clicking the “Cancel” button should lead back to the Client Create Reservation
page.
• Client Reservation Transaction Confirmation jsp page
o The page must display all the information from the transaction page except for the credit card information.
5
o The page must display a message “The reservation has been confirmed” and then also display the reservation number.
o The page has a “Home” button that redirects the user back to the Client Home Page and a “Logout” button.
• Manage Hotels jsp page
o This page must display all the hotels managed by the client.
o The student may decide how and what information is displayed. The following
are required: Hotel name, description, number of rooms available (unreserved),
number of reservations.
o Each hotel should have a button “Edit” that takes the user to the Edit Hotel
Details page.
• Edit Hotel Details jsp page
o This page should allow the client to edit certain details about the selected hotel: ! Name
! Description
! Total number of rooms and room types ! Amenities available:
• Bathtub in room
• Free breakfast
• Free Wi-Fi
• Gym
• Paid Internet access
• Pool
• Pet friendly
! Location city
! Room type and price per night (per room)
o The page must have two buttons: “Save” and “Cancel”. The “Save” button must
update all the information about the hotel and then redirect the user back to the Manage Hotels page. The “Cancel” button must discard all changes made (no changes to the database) and redirect back to the Manage Hotels page.
General Requirements:
• Navigation links should lead to appropriate pages (logout should lead to Login page,
etc.).
• Proper HTML form elements and function must be employed for input areas.
• Use CSS to manage the style of the pages.
• Make a suitable use of the INIT servlet method.
• Servlets should be able to handle both HTTP GET and POST methods.
• Implement at least one HTTP request and response headers.
6
Assignment Submissions:
What to submit using Webhandin (Email submissions will NOT be accepted):
1. An archive of the entire web application (project) stored in a standard war file. When creating the war file you must include your java source files. This war file will be imported into Eclipse for grading.
2. Grading rubric
3. A programmer’s manual
4. A user’s manual
You MUST use the following naming convention for your WAR file, grading rubric and manuals:
• team name-HW1.war (e.g., Team1-HW1.war)
• team name-HW1-Rubric.pdf (e.g., Team1-HW1-Rubric.pdf)
• team name-HW1-ProgrammersManual.pdf (e.g., Team1-HW1-ProgrammersManual.pdf)
• team name-HW1-UsersManual.pdf (e.g., Team1-HW1-UsersManual.pdf)
7
