## Kiwiland Rail Pathfinder

# Execution
Compile all source files located in src/main/java/com/kiwiland.
```javac src/main/java/com/kiwiland```
Run the Application
```cd src/main/java```
```java com.kiwiland.Application```

# Design
Per the input data, Kiwiland's railway is modeled as a series of nodes and edges on a directed, weighted graph.
Node, Edge, and Graph are modeled respectively as Java classes.

A Path class is also implemented - it performs various operations on a list of Edges, such as giving total weight of a path.

A PathFinder interface is defined, meant to be extended by classes employing their own respective pathfinding algorithms. Three such pathfinders are defined, targeted toward different problems given in ```requirements.spec```.

The ExactPath class is targeted toward requirements #1 - #5, plotting the exact path given.

The Dijkstra class employs Dijkstra's algorithm to plot the shortest path between given nodes (requirements #8 and #9).

The Constrained class might in the future be extended to cover all requirments, but at this time is employed for requirements #6, #7, and #10. Constrained takes one or two Predicate functions, meant to applied to a Path to test that it meets the given constraints (e.g., Path has weight less than 30).

The Kiwiland class instantiates a Graph with the given test data, and defines 10 requirement functions, each mapping directly to a given requirement.

Finally, the Application class executes each of the 10 Kiwiland requirement methods and prints the result exactly as specified in the requirements.