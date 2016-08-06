# Task 0

Clone this repository (well done!)

# Task 1

Take a look a the two repositories:
  
  * (A) https://bitbucket.org/farleyknight/ruby-git
  * (B) https://bitbucket.org/kennethendfinger/git-repo

And answer the following questions about them:

  * Who made the last commit to repository A?
  * Who made the first commit to repository A?
  * Who made the last and first commits to repository B?
  * Who has been the most active recent contributor on repository A?  How about repository B?
  * Are either/both of these projects active at the moment?  🤔 If not, what do you think happened?
  * 🤔 Which file in each project has had the most activity?

# Task 2

Setup a new eclipse project with a main method that will print the following message to the console when run:

~~~~~
Sheep and Wolves
~~~~~ 

🤔 Now setup a new bitbucket repository and have this project pushed to that repository.  You will first need to `commit`, then `push`.  Ensure you have setup an appropriate `.gitignore` file.  The one we have in this repository is a very good start.

# Task 3

Draw a 20 by 20 grid on a 1280x720 window, have the grid take up the 720x720 square on the left of the window.  Each cell should be 35 pixels high and wide and the grid should be drawn 10 pixels off the top and left borders of the screen.  Useful resources:
  
  * [Simple example to get started](http://ynonperek.com/course/java/java-2d.html)
  * [Java2D API](https://docs.oracle.com/javase/tutorial/2d/overview/)
  * [The Graphics2D class](https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html)
  * [Getting the frame size just right](http://stackoverflow.com/questions/5916226/java-swing-set-actual-frame-size-inside)

# ☆ Task 4

Create a 2D array to represent the grid and connect the drawn grid to the array in some way.

# Task 5

Modify your program so that mousing over a cell will "highlight" it.  Highlighted cells should be drawn in grey.

# Task 6

Ensure your program, if it does not already, has a `Cell` class and that your grid array is an array of `Cell` objects.  It should still display as before.  What are reasonable methods and fields for the `Cell` class?  Now create a `Grid` class to subsume your 2D array of `Cell`s.  What fields and methods should this class have?