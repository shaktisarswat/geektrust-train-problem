# geektrust-train-problem
Problem Link : https://www.geektrust.com/coding/detailed/train

There are 2 super fast trains, Train A and Train B. Train A travels from Chennai to New Delhi. Train B travels from Trivandrum to Guwahati.
 
 * Passengers can board these trains only at the source station. 
 * The trains have only reserved bogies and each bogie will only have passengers to a specific station. 
 * When the train arrives at a station, the entire bogie with passengers is detached from the train, and the train continues its journey.
   
 The routes with station code and distances of each station from originating station are as follows: (STATION (CODE) - DISTANCE ): 

 ![image](https://github.com/shaktisarswat/geektrust-train-problem/assets/111270536/7e8cbc2c-8e6b-43ad-81bc-2e0f92e3c4d2)

 # The Merger
 During a part of their journey, these trains follow the same route and travel as one train - Train AB. 
 * Trains start from their respective source stations and meet at Hyderabad. 
 * Trains travel as Train AB from Hyderabad till Bhopal as a single train. 
 * From Bhopal the trains travel again as two independent trains, Train A and Train B. 
 * Train A can have passengers in the route for Train B and vice versa.
 * Eg: People can board from Chennai in Train A and travel to Guwahati.
   
# Merging Rules
* First, both the engines are attached. 
* The remaining bogies from Hyderabad are attached in the descending order of distances they have to travel further from Hyderabad. 
* When the merged train reaches a station, the bogie for that station will be the last one and it can be detached quickly.

# Goal
Given the initial bogie order of both trains, your program should print :
* The bogie order of arrival of Train A and Train B at Hyderabad 
* Train AB's departure bogie order from Hyderabad

# Assumptions
* The passengers board only from the source station. 
* If there are no passenger bogies to travel from Hyderabad station, then train should stop there. In such a case it should print JOURNEY_ENDED 
* The distances are in kilometers. 
* If there are multiple bogies with same station as its destination, then they can be arranged next to each other when the Train AB leaves Hyderabad. 
