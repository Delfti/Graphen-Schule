import java.util.*;

public class Dijkstra {
  Vertex aktuell, Endziel, zwischen;
  
  public void dijkstra(Graph graph, Vertex start, Vertex target) {
    Map<Vertex, Double> distances = new HashMap<>();
    Map<Vertex, Vertex> predecessors = new HashMap<>();
    PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
    
    List<Vertex> vertices = graph.getVertices();
    for (int i = 0; i < vertices.size(); i++) {
      Vertex vertex = vertices.get(i);
      distances.put(vertex, Double.POSITIVE_INFINITY);
    }
    
    distances.put(start, 0.0);
    queue.add(start);
    
    while (!queue.isEmpty()) {
      Vertex current = queue.poll();
      if (current.equals(target)) break;
      
      List<Edge> edges = graph.getEdges(current);
      for (int i = 0; i < edges.size(); i++) {
        Edge edge = edges.get(i);
        Vertex neighbor = null;
        Vertex[] vertexPair = edge.getVertices();
        
        if (vertexPair[0].equals(current)) {
          neighbor = vertexPair[1];
        } else if (vertexPair[1].equals(current)) {
          neighbor = vertexPair[0];
        }
        
        double newDist = distances.get(current) + edge.getWeight();
        
        if (newDist < distances.get(neighbor)) {
          distances.put(neighbor, newDist);
          predecessors.put(neighbor, current);
          queue.add(neighbor);
        }
      }
    }
    
    printPath(start, target, predecessors, distances);
  }
  
  public void Algorithmus(Graph g, Knoten start, Knoten ziel){
    System.out.println("Algorithmus startet:");
    List<Vertex> Vertices = new List<Vertex>();
    List<Vertex> erreichbar = new List<Vertex>();
    List<Vertex> nachbarn = new List<Vertex>();
    double kantenlange;
    String Ergebnis = "Die schnellste Route ist: ";
    
    g.setAllVertexMarks(false);
    Vertices.concat(g.getVertices());
    Vertices.toFirst();
    
    while (Vertices.hasAccess()) { 
      ((Knoten)Vertices.getContent()).setlange(Double.POSITIVE_INFINITY, null);
      ((Knoten)Vertices.getContent()).setBesucht(false);
      Vertices.next();
    }
    
    start.setlange(0.0, null);
    erreichbar.append(start);
 
    while (!erreichbar.isEmpty()) { 
      erreichbar.toFirst();
      aktuell = erreichbar.getContent();
      
      while (erreichbar.hasAccess()) { 
        if (((Knoten)erreichbar.getContent()).getlange() < ((Knoten)aktuell).getlange() && ((Knoten)erreichbar.getContent()).isBesucht() == true) {
          aktuell = erreichbar.getContent();
        }
        erreichbar.next();
      }
      
      aktuell.setMark(true);
      
      erreichbar.toFirst();
      while (erreichbar.hasAccess()) {
        if (erreichbar.getContent() == aktuell) {
          erreichbar.remove();
          break; 
        }
        erreichbar.next();
      }
      
      nachbarn.concat(g.getNeighbours(aktuell));
      nachbarn.toFirst();
      erreichbar.toFirst();
      
      while (nachbarn.hasAccess()) {
        if (nachbarn.getContent().isMarked() == false && ((Knoten)nachbarn.getContent()).isBesucht() == false) {
          erreichbar.append(nachbarn.getContent());
          ((Knoten)nachbarn.getContent()).setBesucht(true);
          kantenlange = g.getEdge(aktuell, nachbarn.getContent()).getWeight();
          
          if ((((Knoten)aktuell).getlange() + kantenlange) < ((Knoten)nachbarn.getContent()).getlange()) {
            ((Knoten)nachbarn.getContent()).setlange((((Knoten)aktuell).getlange() + kantenlange), (Knoten)aktuell);
          }
          
          if (((Knoten)nachbarn.getContent()).getlange() == Double.POSITIVE_INFINITY) {
            ((Knoten)nachbarn.getContent()).setlange((((Knoten)aktuell).getlange() + kantenlange), (Knoten)aktuell);
          }
        } 
        nachbarn.next();
      }
    }
    
    Vertices.toFirst();
    
    while (Vertices.hasAccess()) { 
      if (Vertices.getContent().getID().equals(ziel.getID())) {
        Endziel = Vertices.getContent();
        break;
      } else {
        Vertices.next();
      }
    }
    
    if (Endziel == null) {
      System.out.println("Kein gültiges Ziel eingegeben. ");
    }
    
    zwischen = Endziel;
    Ergebnis = Ergebnis + zwischen.getID();
    
    while (((Knoten)zwischen).getVorganger() != start) { 
      zwischen = ((Knoten)zwischen).getVorganger();
      Ergebnis = Ergebnis + zwischen.getID();
    }
    
    System.out.println(Ergebnis + start.getID());
  }
  
  private void printPath(Vertex start, Vertex target, Map<Vertex, Vertex> predecessors, Map<Vertex, Double> distances) {
    if (!predecessors.containsKey(target)) {
      System.out.println("Kein Pfad gefunden.");
      return;
    }
    
    List<Vertex> path = new List<>();
    List<Vertex> r_path = new List<>();
    for (Vertex at = target; at != null; at = predecessors.get(at)) {
      path.append(at);
    }
    
    for (int i = 0; i < path.size(); i++) {
      r_path.append(path.get(path.size()-1-i));
    }
    
    for (int i = 0; i < r_path.size(); i++) {
      System.out.print(r_path.get(i).getID());
      if (i <r_path.size() - 1) System.out.print(" -> ");
    }
    System.out.println("\nGesamtentfernung: " + distances.get(target));
  }
}