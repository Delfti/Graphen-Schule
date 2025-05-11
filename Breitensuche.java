public class Breitensuche {
  
  public Breitensuche() {
  }
  
  public List<Vertex> BFS(Graph pGraph, Vertex pStart) {
    List<Vertex> result = new List<>();
    Queue<Vertex> queue = new Queue<>();
    
    pGraph.setAllVertexMarks(false);
    queue.enqueue(pStart);
    pStart.setMark(true);
    
    while (!queue.isEmpty()) { 
      Vertex current = queue.front();
      queue.dequeue();
      result.append(current);
      
      List<Vertex> neighbours = pGraph.getNeighbours(current);
      neighbours.toFirst();
      
      while (neighbours.hasAccess()) { 
        Vertex neighbour = neighbours.getContent();
        if (!neighbour.isMarked()) {
          neighbour.setMark(true);
          queue.enqueue(neighbour);
        }
        neighbours.next();
      }
    }
    return result;
  }
  
  public List<Vertex> BFS_maxtiefe(Graph pGraph, Vertex pStart, int maxDepth) {
    List<Vertex> result = new List<>();
    Queue<Vertex> nodeQueue = new Queue<>();
    Queue<Integer> depthQueue = new Queue<>();
    
    pGraph.setAllVertexMarks(false);
    nodeQueue.enqueue(pStart);
    depthQueue.enqueue(0);
    pStart.setMark(true);
    
    while (!nodeQueue.isEmpty()) { 
      Vertex current = nodeQueue.front();
      int currentDepth = depthQueue.front();
      nodeQueue.dequeue();
      depthQueue.dequeue();
      result.append(current);
      
      if (currentDepth < maxDepth) {
        List<Vertex> neighbours = pGraph.getNeighbours(current);
        neighbours.toFirst();
        
        while (neighbours.hasAccess()) { 
          Vertex neighbour = neighbours.getContent();
          if (!neighbour.isMarked()) {
            neighbour.setMark(true);
            nodeQueue.enqueue(neighbour);
            depthQueue.enqueue(currentDepth + 1);
          }
          neighbours.next();
        }
      }
    }
    return result;
  }
  
  public Graph BFS_graph(Graph pGraph, Vertex pStart) {
    Graph bfsTree = new Graph();
    Queue<Vertex> queue = new Queue<>();
    
    pGraph.setAllVertexMarks(false);
    queue.enqueue(pStart);
    pStart.setMark(true);
    
    bfsTree.addVertex(pStart);
    
    while (!queue.isEmpty()) { 
      Vertex current = queue.front();
      queue.dequeue();
      
      List<Vertex> neighbours = pGraph.getNeighbours(current);
      neighbours.toFirst();
      
      while (neighbours.hasAccess()) { 
        Vertex neighbour = neighbours.getContent();
        if (!neighbour.isMarked()) {
          neighbour.setMark(true);
          queue.enqueue(neighbour);
          
          bfsTree.addVertex(neighbour);
          bfsTree.addEdge(new Edge(current, neighbour, 1));
        }
        neighbours.next();
      }
    }
    return bfsTree;
  }
  
  public Graph BFS_maxtiefe_graph(Graph pGraph, Vertex pStart, int maxDepth) {
    Graph bfsTree = new Graph();
    Queue<Vertex> nodeQueue = new Queue<>();
    Queue<Integer> depthQueue = new Queue<>();
    
    pGraph.setAllVertexMarks(false);
    nodeQueue.enqueue(pStart);
    depthQueue.enqueue(0);
    pStart.setMark(true);
    
    bfsTree.addVertex(pStart);
    
    while (!nodeQueue.isEmpty()) { 
      Vertex current = nodeQueue.front();
      int currentDepth = depthQueue.front();
      nodeQueue.dequeue();
      depthQueue.dequeue();
      
      if (currentDepth < maxDepth) {
        List<Vertex> neighbours = pGraph.getNeighbours(current);
        neighbours.toFirst();
        
        while (neighbours.hasAccess()) { 
          Vertex neighbour = neighbours.getContent();
          if (!neighbour.isMarked()) {
            neighbour.setMark(true);
            nodeQueue.enqueue(neighbour);
            depthQueue.enqueue(currentDepth + 1);
            
            bfsTree.addVertex(neighbour);
            bfsTree.addEdge(new Edge(current, neighbour, 1));
          }
          neighbours.next();
        }
      }
    }
    return bfsTree;
  }
}