# object-oriented-programming-week-8

8.1. Change the BottleDispenser so taht it uses the Singleton design pattern meaning that you can only create one object at a time.

8.2. Create a graphical user interface for the BottleDispenser. Use the functionality that has already been made so the only change you have to do is change the console prints to a graphical user interface. Additionally, change the Bottle list to an ArrayList if you haven't already done that.

Instructions: 

There should be a button that is used to add money to the machine. Additionally you need a button that buys the bottles and a button that returns money. Note that console prints are not an option so you need a text field where the prints are shown.

8.3. Modify the user interface in such a way that it is possible to change the amount of money you put to the BottleDispenser. It is recommended to use SeekBar-component that works as a slider to change the amount of money given. You will still need a button to that adds the money and resets SeekBar.

8.4. Add a possibility to buy different sodas in different sizes. One possiblity is to use drop-down list for buying the bottles. This means the user chooses from the drop-down list the bottle they want to buy and its size. Afterwards the BottleDispenser either sells the product or says that they are out (you can use Spinner component for example).

8.5. Add a functionality that makes it possible to print receipt of the last purchase for the user. The receipt should contain information that it is a receipt and what was purchased (name and price at least). The receipt is not printed to the user interface but instead, written to a file (that is defined in the program).
