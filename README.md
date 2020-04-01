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

##Phase 4: Task 2
- Implemented a bi-directional association between the Course class and the Grades class
as well as the Course class and the Stats class

The Course class has setStats and setGrades methods that illustrates the bi-directional nature where both the 
Stats/Grades object is modified along with its own field. The pattern is mirrored in both the Stats and Grades classes
where they have setCourse methods that also modify itself and the Course object.

So effectively, every Course must be associated with a specific Grades and Stats object and vice versa.

##Phase 4: Task 3
Cohesion:  The WorkListOptions class initially had multiple responsibilities. It represented the sub-panel that was 
on the WorkListPage, but it was also responsible for generating the GIF animation, and the panel that pops up on the screen
when the "Save" button was pushed. I re-factored my code by splitting the responsibility of generating the GIF image and
creating the panel that pops up when the "Save" button is clicked into a separate class called GifPanel. By doing so,
I increased cohesion by separating responsibilities of a single class into multiple.


Coupling: I did a large amount of re-factoring to reduce coupling in my ui package. I abstracted many similar methods
 in my CourseChooser class such as the add and remove course methods into single methods like editWorklist,
 and many of the methods in my ui classes for creating buttons are abstracted into a single method, so there
 is only one method implementation that needs to be considered when altering code later on. All of this re-factoring helped
 to reduce the coupling in my project. But the most significant change I made was that I created two super-classes called
 MainPanel and SubPanel.
 
- MainPanel represents a single tab on the Toolbar and all of the default set-up of any given
tab in my project is captured in the MainPanel class. The individual differences between tabs are then implemented when
a new tab class is created (which all extend MainPanel). This significantly reduced the code in all of my tab classes
and reduces coupling as I can make a change in all of the tabs by simply altering the implementation of MainPanel. Moreover,
all of the methods in CourseChooser that edit the text areas in my tabs now just need to take in a generic MainPanel
object instead of the specific panel object that it needed before. I created separate packages in my ui folder called
"tabs" and "subpanels" so it is easier to discern the separation between classes.

- SubPanel is an abstract super-class that represents any of the sub-panels that are created on an individual tab or MainPanel.
A SubPanel must be associated with a MainPanel (otherwise it would just be a main panel itself), but a MainPanel
does not necessarily need to be associated with a SubPanel (I did this to limit the coupling between these two classes
as it adds more flexibility to the MainPanel class). Just like MainPanel, all of the default set-up and methods that 
are shared between all of the sub-panels is captured in the SubPanel class and all of the specific components to a sub-panel
(like buttons, fields, labels, etc.) are implemented when a new sub-class of SubPanel is instantiated.
There is one abstract method in SubPanel called setUpGrid which any new instance of a SubPanel subclass must over-ride
 as it represents the method that sets up and places all of the components on the panel which is specific to the new
 sub-panel that is being created.
 
 - This hierarchy implementation significantly reduces coupling as all of the major set-up and methods that are 
 implemented when making new tabs or sub-panels in the GUI is captured in only two classes and can be altered by simply
 altering the implementation of these two classes (which emphasizes the single-point of control principle). By doing this,
 I reduced the number of specific fields that each of my classes have, thereby eliminating needless associations between
 classes.
 Furthermore, I altered the implementation of te Toolbar class in response to these changes and created a list of tabs as
 a field in Toolbar instead of previously, there was a field for every tab that I wanted to have. By doing this, adding a new
 tab is much easier as you simply instantiate a MainPanel and it to the list in order to create a new tab. This reduced coupling
 as well as making changes to the Toolbar as there is only one field to consider compared to many fields representing
 every tab that is created. 