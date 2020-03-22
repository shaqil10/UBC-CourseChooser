# UBC Course Chooser

The UBC Course Chooser application will help UBC students decide which courses they would like
to take in the future based on considering past course grade distributions, statistics, and professor ratings.
The application will allow students to search for courses based on specific parameters like
year level, subject, specific instructors, or any other statistics that they desire in a course they are looking to take.


All of the data on the UBC courses will be provided from the UBC Pair API and also it will make use of the
RateMyProfessor API in order to give students more detailed information about the instructors that teach
the courses they are looking for. Students will be able to save courses into a personalized worklist that they can 
edit and review at any time in order to help them with course registration.

This application would be extremely useful for students trying to find specific courses that suit their needs
to meet graduation requirements. Especially so for those looking into electives or lighter-load courses to balance out
their schedules. 

This project is interesting to me because I have always wanted an application like this for when I am choosing courses.
Especially in my first degree, I would always have UBC Pair and RateMyProfessor open in separate windows when trying
to find courses. However, jumping between the two became quite annoying at times and the user interface
on UBC Pair is quite dull and difficult to use in many cases (especially because of the CAPTCHA).

An application with much more flexible search parameters and one that already contains all of the necessary
information in one platform would be extremely useful for myself and a great deal of students.



##User Stories:

- As a user, I want to be able to search for courses that match my search criteria (Subject, Year Level, and Desired Course Average)
- As a user, I want to be able to add a specific course to my worklist
- As a user, I want to be able to review my worklist entries
- As a user, I want to be able to delete entries from my worklist
- As a user, I want to be able to get in-depth statistics and grade distributions for specific courses

- As a user, I want to have the option to be save my personalized worklist to file when I exit the application
- As a user, I want to be able to re-load my personalized worklist from a saved file and continue working from 
where I left off


##Instructions for Grader:

1. The first tab, which the application begins, is the first of my user stories. The user can
provide the three criteria which they are looking for in the text fields: subject, year level, and 
desired average. Once the criteria are chosen and the "Search!" button is clicked, the application will search through my hard-coded database (UBC Pair API not implemented yet), 
and will display the courses in the database that match those criteria.

2. The second tab is the worklist page which relates to user stories 2-4 and 6-7. The application automatically
loads the worklist that is saved to file and displays the list of courses in the worklist.
The user can then enter a specific course ID (like the example provided in the text field to begin with) into the text
field and can add that course to their worklist or remove the course provided with the ID depending on which button is clicked.
Obviously, clicking the "Add" button will add the course to the worklist, and "Remove" will remove that course from the list.
The add and remove buttons represent the two required events of adding X to Y.
If the grader wants to play around with different courses, just go ahead and use the search function which will provide
some course IDs that you can copy and paste into the text field so that you can add and remove different courses from 
the worklist.
This page also contains a save option so if the user clicks the "Save" button, it will save the worklist to the file.
The application will also prompt the user if they would like to save their worklist when they hit the close button.

3. The last tab relates to user story 5 where a user can input a specific courseID into the text field, and they 
can choose the option to display either the general information, grade distributions, or statistics of a specific course.
When the user hits "Show Me!", the information will be displayed on the text area below depending on the choice.

4. Audiovisual component: For my A/V component, when you hit the save button, a GIF should appear! The thinking man.
Just wanting to let you know that you're smart for saving your work.

5. As mentioned previously, the save functionality is done on the worklist page when you hit the "Save" button
or if the window is closed, the user has the option to save that way as well. There is no specific load button, but the
program automatically loads the worklist saved on the file so if you save your worklist and open it up again, the program
starts where you left off.

