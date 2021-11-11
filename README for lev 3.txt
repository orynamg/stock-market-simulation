Student name: Oryna Goichuk


Please complete this README file for your level 3 mini-project submission.

If your level 1/2 submission did not get full marks you MUST complete the second part of this template describing how and where your have improved your code so that it now meets the level 1 and 2 requirements. If your code still does not meet level 1 and 2 requirements then you will get 0 for level 3.

LEVEL THREE

GUI

In the StocksInterface class, I used Gui to display the constant change in stock prices every half a second, making the Gui very dynamic. The buttons for sell and buy stocks and add credit update the portfolio dashboard on click, without needing to restart the program, creating a dynamic Gui. Additionally, the prices are also displayed above the graph, and are updated every half a second.
The code that corresponds to the texboxeds in the StocksInterface class on lines 40 and 52 (textboxes for company name and number of stocks input) and the button are coded on lines 62, 68 and 73 and 78, that all use a separate unique class for their functions.


Exceptions

Exceptions are handled throughout the program, for example, on line 235, I am using a try catch during file input (when saving the file with the current prices). The catch uses 2 exceptions, the IOException and a general Exception. The exception is needed if the program could not find or create the correct file or append data needed, or if any other error (eg. incorrect type or loop problems elsewhere in the program) affected the file input.

Collections

I used the Collectiosn class for Map() and ArrayList(). For example I used a Map() of Strings and Arraylists,. The string would be the name of the company and the arrayList contained a pair of values: the current stock price and time (of this price). This is the main Map of strings and arrayLists I used to store the prices for each stock company at different times. Line 18. I also used an arrayList on line 17 that stored the names of 3 companies in it (company being an object type of array list). I used it to loop through the different companies to display the prices in a textbook, and other uses.


File I/O

When you click the save prices button, it goes to the code on line 235 where a new file is created called "stock-prices.txt" that gets the last price of each stock and then writes it next to company name (company.getCompanyName) company being an arrayList of companies. It then saves the file.


'Something impressive'

My code uses an impressive dynamic Gui that uses a lineChart and Canvas class (has not been taught). I had to calculate quite complicated calculations to correctly display a graph of the price fluctuations. This required me to work with coordinates and line drawing. Additionally, I used a timer import that allowed me calculate prices in real time every x seconds. I also used for-each for loops and Map() throughout the program, which has not been taught, to help me improve my application.


LEVELS 1 AND 2

(ONLY complete this if you did not get full marks for your level 1/2 submission.)

LEVEL ONE

[Briefly (three sentences) explain the changes you have made to your code so that it fully meets the level one requirements.]

My code demonstrates inheritance in the following way...

I have a superclass called [Insert name of superclass here]

This superclass is extended into at least two subclasses called [Insert names of the subclasses here]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Insert name of subclass] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Insert names of properties here.]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]

Subclass 2.

Subclass [Insert name of subclass] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Insert names of properties here.]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]


LEVEL TWO

[Briefly (three sentences) explain the changes you have made to your code so that it fully meets the level two requirements.]

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]

Example 2.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]

