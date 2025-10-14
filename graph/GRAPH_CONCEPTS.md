# Graph Implementation Concepts

This document explains the graph implementation concepts used in the Java code.

## Overview

The code implements three main types of graphs:
1. Base Graph (Abstract)
2. Directed Graph
3. Weighted Graph

## Core Concepts

### 1. Graph Representation

The graphs are represented using an **Adjacency Matrix**:
- Size: `n × n` where n is the number of vertices
- For basic graphs: Matrix contains 0s and 1s
  - `adj[i][j] = 1` means there's an edge from vertex i to vertex j
  - `adj[i][j] = 0` means no edge exists

### 2. Base Graph Class

The abstract `Graph` class provides:
- Basic graph structure with adjacency matrix
- Abstract method for reading graph data
- Display method for the adjacency matrix
- Basic connectivity checking using BFS (Breadth-First Search)

### 3. Directed Graph

`DirectedGraph` extends the base `Graph` class and adds:

- **Direction-specific features:**
  - Indegree calculation (incoming edges to a vertex)
  - Outdegree calculation (outgoing edges from a vertex)
  - Strong connectivity check using a simplified version of Kosaraju's algorithm

#### Key Concepts:
- **Indegree**: Number of edges coming into a vertex
- **Outdegree**: Number of edges going out from a vertex
- **Strong Connectivity**: Every vertex is reachable from every other vertex

### 4. Weighted Graph

`WeightedGraph` extends the base `Graph` class and implements:

- Weight matrix to store edge weights
- Dijkstra's shortest path algorithm
- Modified connectivity check considering weighted edges

#### Key Features:
- **Edge Weights**: Non-zero values represent edge weights
- **Shortest Path**: Uses Dijkstra's algorithm to find minimum weight path
- **Path Reconstruction**: Tracks and displays the actual shortest path

### 5. Algorithms Implemented

1. **Breadth-First Search (BFS)**
   - Used for basic connectivity checking
   - Time Complexity: O(V + E)

2. **Dijkstra's Algorithm**
   - Finds shortest path in weighted graphs
   - Time Complexity: O(V²)
   - Uses:
     - Priority queue (implicit)
     - Distance array
     - Previous vertex tracking for path reconstruction

## Usage Example

```java
// Create a directed graph with 4 vertices
DirectedGraph dg = new DirectedGraph(4);
dg.getGraph(scanner);  // Input adjacency matrix
dg.displayDegrees();   // Show in/out degrees

// Create a weighted graph with 4 vertices
WeightedGraph wg = new WeightedGraph(4);
wg.getGraph(scanner);  // Input weight matrix
wg.dijkstra(0, 3);    // Find shortest path from vertex 0 to 3
```

## Implementation Notes

1. **Memory Usage**: 
   - Space Complexity: O(V²) for adjacency matrix
   - Suitable for dense graphs
   - Not optimal for sparse graphs

2. **Performance Characteristics**:
   - Edge lookup: O(1)
   - Vertex degree calculation: O(V)
   - Path finding: O(V²) with current implementation

3. **Extensibility**:
   - Abstract base class allows for easy addition of new graph types
   - Common operations are inherited from base class
   - Specific operations can be overridden as needed