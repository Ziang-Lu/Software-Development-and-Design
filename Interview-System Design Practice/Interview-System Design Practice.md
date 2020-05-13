# Interview-System Design Practice

Interviewer is looking for:

* **Handling ambiguity** to restrict the problem breadth

  => Ask questions to <u>restrict the problem breadth</u>, especially <u>the details that the interviewer is purposefully hiding</u>

* **Systemematic approach** to the problem

<br>

## Parking Lot

* **Handling ambiguity** to restrict the problem breadth

  For example, we may ask:

  * How is the parking lot designed?

    * Is it a building, or an open area?

    * Are there multiple entrances?

      (=> Might involve concurrency)

  * How is the accessibility?

    * Are there some parking spots for the disabled, which should be in front of the entrance?

  * Are there different sized parking spots, with different prices?

  ***

  Assumption:

  * There are four sizes of parking spots: S, M, L and XL.

  * There are four types of vehicles: motor cycles (S), cars (M), trucks (L) and buses (XL).

  * For each type of vehicle, it can only be parked in a parking spot of the same size or larger size.

    e.g., A car can be parked in an M, L or XL spot, but not an S spot.

  ***

* **Systematic approach** to the problem

  <img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/Interview-System%20Design%20Practice/Parking%20Lot/Parking%20Lot.png?raw=true">

<br>

## Library Information System

* **Handling ambiguity** to restrict the problem breadth

  Check out `requirements`

* **Systematic approach** to the problem

  <img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/Interview-System%20Design%20Practice/Library%20Information%20System/Library%20Information%20System.png?raw=true">

<br>

## Twitter

* **Handling ambiguity** to restrict the problem breadth

* **Systematic approach** to the problem:

  Based on LeetCode 355-Design Twitter, we add the following considerations:

  - Most of the cases, users tend to get news feed more often than posting new tweets.

    Therefore, we optimize for fetching: cache the news feed for each user.

  - In this way, since we need to cache the news feed for each user, the memory usage may be too large.

    Therefore, we only cache for those active users, like ever logged-in in the past two weeks.

