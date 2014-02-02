# abc Player

First of two team projects during 6.005, Fall 2013.

The player only plays a subset of abc notation, which can be found
at [this page](http://web.mit.edu/6.005/www/fa13/projects/abcplayer/abc_subset_description.html).

To play, open the project in [Eclipse](http://www.eclipse.org/). Compile and run `Main.java`.
The default code plays Für Elise by Ludwig van Beethoven.

To play something else, you must change the line 

`public static String fileName = "sample_abc/fur_elise.abc";`

to

`public static String fileName = "sample_abc/FILENAME.abc";`

where `FILENAME.abc` is the file of your choosing, located in
the `sample_abc` directory. Of course, you can use your own
path name string, keeping in mind that a relative pathname is
relative to the root of the **project directory**, not `Main.java`.
