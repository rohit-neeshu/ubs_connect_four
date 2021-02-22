# Connect Four
Connect Four Game

## Task Description

1) Two players allowed to play the game			
2) Player 1 dice is R and Player 2 dice is G
3) Each player will be allowed to enter the column value between 1 to 7
4) Any player have continuous 4 values in the board either horizontally or vertically or diagonally will be the winner

```
| | | | | | | |
| | |G|G| | | |
| |R|G|R| | | |
| |G|R|R| | | |
|G|G|R|G| | | |
|R|G|R|R| | | |

```

5) In the above sample, Player G is the winner
6) User can quit the game in between by pressing Q
7) After completing the game system will allow user to restart or quit the game.

## Overview

Program can be build using java 8 and Maven

## Assumptions

1) Current game implementation is a 2 player game.
2) Winning strategy is when continuous 4 values of same player are in the board either horizontally, vertically or diagonally then that player will be winner. 
3) At any time user can quit the game by pressing Q.
4) If developer want to change the winning strategy, then can do it by implementing Winner interface. 
5) If developer want to implement the 4 player game then he can implement that by extending  Connectfour abstract class.
6) I tried to design the problem that can be extensible and reusable. There can be some area which need to be implemented such as factory class as per the new Implementation.
7) Current implementation support a board size of 6x7.

## Commands
```
From source:
	Run: mvn clean install
	Test: mvn test
	Create JAR: mvn package
	Run program: mvn exec:java
using JAR file: java -jar ubs_connect_four-0.0.1.jar
```