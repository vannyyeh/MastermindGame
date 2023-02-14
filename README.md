# MastermindGame
EE422C


<b>Description</b><br>
The purpose of this assignment is to design and implement a program to play a text-based
version of the board game Mastermind. You are free to use whatever classes and methods from
the Java 8 library you wish.
The first thing you should do is read the Wikipedia article on the game of Mastermind.
Here is a good example of what an interactive GUI for Mastermind would look like: https://www.webgamesonline.com/mastermind/

<br>

<b>Implementation Requirements</b><br>
The version of the game you implement must have the following properties.
The computer will randomly generate the secret code.
The player will try to guess the secret code.
The player has a maximum number of attempts to guess the code correctly. If the player
runs out of guesses, they lose the game.
The secret code consists of some number of colored pegs in a specific order.
Capital letters will be used to indicate colors: B for blue, R for red, and so forth.
The maximum number of guesses, the number of pegs in the secret code, and the available
peg colors should be changeable by passing different instances of the provided
GameConfiguration class into the start method of Driver .
The results of a guess are displayed with black and white pegs. The Wikipedia article refers to
the results as feedback.
A peg in the guess will generate feedback of either: 1 black peg, 1 white peg, or no pegs. A
single peg in the guess cannot generate more than 1 feedback peg.
The order of the feedback does not give any information about which pegs in the guess
generated which feedback pegs. In your feedback, you must give the number of black pegs
(if any) first, and then the number of white ones, if any.
The player's guesses must be error checked to ensure that they are of the correct length and
only contain valid characters. The output of the game should be a simple text-based display
on the console. See the Sample User Dialogue below.

<br>
<b>Input/Output</b><br>
Print the greeting message before getting any input and before running any game. For each
game, print a single line asking the user if he wants to play a new game. Then, if and only if you
are in testing mode, print the secret code.
Next is the part of the program asking for user guess inputs. Before asking for user input, print a
blank line, then print the number of remaining guesses. Process the user's guess and print the
number of black/white pegs. If the guess is not valid, print INVALID_GUESS. There is a special
guess: “HISTORY”. In that case, print all previous valid guesses and their resulting pegs. If the
game ends (losing or winning), print a blank line, then ask again whether the user wants to play a
new game. If user does not want to continue, print nothing and exit the program.
Input and outputs are case-sensitive. If you see any space in the sample dialogue below, it
means a single space character, and not any other form of white space (e.g. tabs, multiple
spaces).
Do not use an end-of-line character explicitly (no \n or \r\n etc.) as its interpretation depends
on the underlying platform. Always use println() ; whenever you want to explicitly use the endof-
line character, try System.getProperty(“line.separator”) , or simply use println() with
no input.
Each line of output should have exactly one line separator. This means that no other blank line is
allowed (except what we said about each guess and each result). Also, the last line of output
should have an ending line separator as well. We will try to ignore newline differences and
ignore blank lines, but do the best you can to follow the directions.
You can assume that, except for invalid guesses, the player will not give you erroneous inputs. For
example, when you are expecting the user’s response for a new game, the player will always input
Y or N. Invalid guesses also will only be erroneous in the content; they won’t have whitespaces or
special characters.
Please carefully make your program output like the following sample user dialogue. Any failure to
obey the rules may cause loss of points.
