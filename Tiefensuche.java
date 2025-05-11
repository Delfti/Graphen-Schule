public class Tiefensuche {
  
  public Tiefensuche() {
  }
  
  public List<Vertex> DFS(Graph pGraph, Vertex pStart) {
    List<Vertex> result = new List<>();
    Stack<Vertex> stack = new Stack<>();
    
    pGraph.setAllVertexMarks(false);
    stack.push(pStart);
    
    while (!stack.isEmpty()) {
      Vertex current = stack.top();
      stack.pop();
      
      if (!current.isMarked()) {
        current.setMark(true);
        result.append(current);
        
        List<Vertex> neighbours = pGraph.getNeighbours(current);
        neighbours.toFirst();
        
        // Nachbarn rückwärts einfügen, um DFS-Reihenfolge zu erhalten
        List<Vertex> reverse = new List<>();
        while (neighbours.hasAccess()) {
          reverse.insert(neighbours.getContent());
          neighbours.next();
        }
        
        reverse.toFirst();
        while (reverse.hasAccess()) {
          Vertex neighbour = reverse.getContent();
          if (!neighbour.isMarked()) {
            stack.push(neighbour);
          }
          reverse.next();
        }
      }
    }
    
    return result;
  }
  
  public Graph DFS_graph(Graph pGraph, Vertex pStart) {
    Graph dfsTree = new Graph();
    Stack<Vertex> stack = new Stack<>();
    
    pGraph.setAllVertexMarks(false);
    stack.push(pStart);
    dfsTree.addVertex(pStart);
    
    while (!stack.isEmpty()) {
      Vertex current = stack.top();
      stack.pop();
      
      if (!current.isMarked()) {
        current.setMark(true);
        
        List<Vertex> neighbours = pGraph.getNeighbours(current);
        neighbours.toFirst();
        
        List<Vertex> reverse = new List<>();
        while (neighbours.hasAccess()) {
          reverse.insert(neighbours.getContent());
          neighbours.next();
        }
        
        reverse.toFirst();
        while (reverse.hasAccess()) {
          Vertex neighbour = reverse.getContent();
          if (!neighbour.isMarked()) {
            stack.push(neighbour);
            dfsTree.addVertex(neighbour);
            dfsTree.addEdge(new Edge(current, neighbour, 1));
          }
          reverse.next();
        }
      }
    }
    return dfsTree;
  }
}