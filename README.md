# AllStarWrestlingFestival2023
Single-elimination format pro-wrestling tournament, with 64 participant wrestlers taking on action, written on Java (the idea was inspired by All Star Junior Festival 2023 Event that took place in March 1st, 2023 at Tokyo - Korakuen Hall)

Introduction:
This project is a simple command-line simulation of a wrestling match between two wrestlers, simulating a single-elimination tournament experience with 64 participants in total. It is written in Java and serves as a fun way to practice Java programming skills.

How to Use
To use this simulator, simply run the Main.java file in your Java compiler or IDE of choice. The program will generate 64 wrestlers by reading their information from the "Wrestlers.txt" file, and then it will simulate a match between randomly assigned two wrestlers (on the first round). Each wrestler will perform a random move each turn, and the damage dealt will be determined randomly.

How It Works
The program works by creating two Wrestler objects with a fixed generated health value of 50. The wrestlers take turns performing random moves and dealing random amounts of damage to each other. The match continues until one of the wrestlers' health falls below 0, at which point the other wrestler is declared the winner, and getting their health replenished for the next round.

Credits
This project was created by Isa Berk Geriler.
