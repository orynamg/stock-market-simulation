Student name: Oryna Goichuk

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called Company

This superclass is extended into at least two subclasses called CocaCola, Apple and Tesla

For each of the named subclasses complete the following...

Subclass 1.

Subclass CocaCola extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are ColaDemand, getColaDemand, setColaDemand, globalHealthConcern

These/this new properties/property are used by the subclass in the following way: A further price fluctuation method to create an increasing trend for the price using code/variables tailored to the class. Line 59.

Subclass CocaCola extends the superclass by overriding the following methods (there must be at least one): fluctuation, getStockPrice. Line 18, Line 74

These overridden methods are used in the working code in the following places: Line 107 (fluctuation) in StockInterface file and 208 (getStockPrice) in same file.

Subclass 2.

Subclass Apple extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are AppleDemand, getAppleDemand, setAppleDemand, globalWageIncrease

These/this new properties/property are used by the subclass in the following way: A further price fluctuation method to create an increasing trend for the price using code/variables tailored to the class. Line 67.

Subclass Apple extends the superclass by overriding the following methods (there must be at least one): fluctuation, getStockPrice. Line 18, Line 66

These overridden methods are used in the working code in the following places: Line 107 (fluctuation) in StockInterface file and 208 (getStockPrice) in same file.


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in line 161, StocksInterface. The name of the superclass used in this example is Company and the subclasses used are Apple.

Late dynamic binding can be seen in 107 in StocksInterface

This is because the fluctuation method is called on variable of class Company, however, the code being run when method fluctuation() is called is from one of the subclasses(called by an instance of each subclass: CocaCola, Apple, Tesla), where the fluctuation method is overridded in each subclass. It is only clear at run-time a method of which derived company class is going to be called.

This shows 3 examples of dynamic binding being used.


Example 2.

The substitution principle can be seen in use in line 160, StocksInterface. The name of the superclass used in this example is Company and the subclasses used are CocaCola.

Late dynamic binding can be seen in 108 in StocksInterface

This is because the getStockPrice() method is called on a variable of class Company, however, the code being run when method getStockPrice() is called from one of the subclasses(called by an instance of each subclass from array: CocaCola, Apple, Tesla), where the fluctuation method is overridded in each subclass. It is only clear at run-time a method of which derived company class is going to be called.
