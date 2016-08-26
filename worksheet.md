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

# ☆ Task 7

Define a `Stage` object that can contain one `Grid` object and many `Characters` objects.  There must be three separate characters, each a subclass of a `Character` interface and each must have its own `paint` method.  A `paint` method must take a mouse position parameter plus a `Graphics2D` parameter and draw the character on that graphic. 

~~~~
public void paint(java.awt.Graphics2D g2, java.awt.Point mouseLoc);
~~~~

The return type of `paint` is `void`.  To work out where a character is drawn, it must have, as a field (`location`) that is set in its constructor, a `Cell` object.

Have the program start with 1 grid and 3 characters:

  * Sheep (drawn white)
  * Wolf (drawn red)
  * Shepherd (drawn green)

# Task 8

Have a close look at your `Shepherd`, `Sheep` and `Wolf` classes.  If they are anything like mine they are _all the same except for the colour they use_.  This repetition is "a bad thing" because if the same thing is done in three different places, we need to remember that updating one requires us to update all three.

Is there a place that you could put all the common parts?

🤔 Will this work given what you currently have?  If not, what would we need to change?

# Task 9

Draw a picture of the inheritance heirarchy you have created.  You should (losely) use [UML notation](http://www.csci.csusb.edu/dick/cs201/uml.html) for your diagram.  You are using UML In this case, and all through this course, only for "a rough sketch of an idea".

# Task 10

Assume we are working for a man who hates arrays (lets not go into why).  He has demanded that the 2D array you have (probably) in your `Grid` class be converted to a "proper" object.  You look around and find Java has no good alternative to arrays for 2D structures.  There are lots of people online telling you to use something like `List<List<int>>` but you have tried nested lists before and have still not fully recovered.  Looking around for some other alternative, the best suggestion you can find is to use a `List` and to ["flatten" the 2D array](http://stackoverflow.com/a/10785908).  

You don't want to have to do the flattening arithmetic all through your code so you resolve to create your own `Array2D` class.  It will have a constructor that sets the width and height of the array, a method to put new elements in at a particular index (`addAt(int i, int j, E element)`) and an method to get elements out (`getFrom(int i, int y`).

Finally, you will make this `Array2D` class _generic_ so it can hold objects of any type, just like normal arrays.

Create such a class and use it in your `Grid` class in place of the 2D array that you had in there before.

# Task 11

You should start this task from the solution to last week's work (which we will call "checkpoint").  We have included this in the master branch this week so everyone can start from the same solution.  You will find solution code in the folder `checkpoint_one`.  It's not an eclipse project, its just the `.java` files.  It is up to you to import it into eclipse and get it running.

Notice the following things about the checkpoint:

  * The `Main.java` file has a `Main` class the extends `Canvas`.  This class drives the whole display loop via an infinite loop in `gameLoop`.
  * This game loop will loop as fast as it possibly can.  It heat up your laptop by working the CPU super hard to no end at all.
  * All the actual drawing and game logic is done by the `Stage` class but we pass from `Main` the mouse location so `Stage` has all the information it needs to do its job.
  * `Stage` passes that information on to other objects when they need it.

Your task is to "fix" the framerate so we are not pointlessly burning CPU power.  You can do this by asking the current thread to sleep for a period of time using [`Thread.sleep`](https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html).  We want the framerate to be about 50 frames per second, that means we need the loop to take 20ms to complete. Notice that checkpoint will already calculate how long the painting took.  Your job is to work out how much time on top of that is needed to get to 20ms and then to have the thread sleep that long.

Sleeping a thread throws an `InterruptedException` so you will need to catch that.  In fact, we don't care about the thread being interrupted so the catch block should just report the fact it was interrupted

~~~~~
System.out.println("thread was interrupted, but really, who cares?");
~~~~~

and continue on as normal.
