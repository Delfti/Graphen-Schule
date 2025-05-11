public class Graph{
  private List<Vertex> vertices;
  private List<Edge> edges;
  
  public Graph(){
    vertices = new List<Vertex>();
    edges = new List<Edge>();
  }
  
  public List<Vertex> getVertices(){
    List<Vertex> result = new List<Vertex>();
    vertices.toFirst();
    while (vertices.hasAccess()){
      result.append(vertices.getContent());
      vertices.next();
    }
    result.toFirst();
    return result;
  }
  
  public List<Edge> getEdges(){
    List<Edge> result = new List<Edge>();
    edges.toFirst();
    while (edges.hasAccess()){
      result.append(edges.getContent());
      edges.next();
    }
    result.toFirst();
    return result;
  }
  
  public Vertex getVertex(String pID){
    Vertex result = null;
    vertices.toFirst();
    while (vertices.hasAccess() && result == null){
      if (vertices.getContent().getID().equals(pID)){
        result = vertices.getContent();
      }
      vertices.next();
    }
    return result;
  }

  public void addVertex(Vertex pVertex){
    if (pVertex != null && pVertex.getID() != null) {
      boolean freeID = true;
      vertices.toFirst();
      while (vertices.hasAccess() && freeID){
        if (vertices.getContent().getID().equals(pVertex.getID())){
          freeID = false;
        }
        vertices.next();
      }
      if (freeID) {
        vertices.append(pVertex);      
      }
    }
  }

  public void addEdge(Edge pEdge){ 
    if (pEdge != null){  
      Vertex[] vertexPair = pEdge.getVertices();
      if (vertexPair[0] != null && vertexPair[1] != null && 
      this.getVertex(vertexPair[0].getID()) == vertexPair[0] && 
      this.getVertex(vertexPair[1].getID()) == vertexPair[1] &&
      this.getEdge(vertexPair[0], vertexPair[1]) == null && 
      vertexPair[0] != vertexPair[1]){
        edges.append(pEdge); 
      }
    }
  }

  public void removeVertex(Vertex pVertex){
    edges.toFirst();
    while (edges.hasAccess()){
      Vertex[] akt = edges.getContent().getVertices();
      if (akt[0] == pVertex || akt[1] == pVertex){
        edges.remove();
      } else {
        edges.next();
      }
    }
    
    vertices.toFirst();
    while (vertices.hasAccess() && vertices.getContent() != pVertex){
      vertices.next();
    }
    if (vertices.hasAccess()){
      vertices.remove();
    }
  }
  
  public void removeEdge(Edge pEdge){
    edges.toFirst();
    while (edges.hasAccess()){
      if (edges.getContent() == pEdge){
        edges.remove();
      } else {
        edges.next();
      }
    }
  }

  public void setAllVertexMarks(boolean pMark){
    vertices.toFirst();
    while (vertices.hasAccess()){
      vertices.getContent().setMark(pMark);
      vertices.next();
    }
  }

  public void setAllEdgeMarks(boolean pMark){
    edges.toFirst();
    while (edges.hasAccess()){
      edges.getContent().setMark(pMark);
      edges.next();
    }
  }

  public boolean allVerticesMarked(){
    boolean result = true;
    vertices.toFirst();
    while (vertices.hasAccess()){
      if (!vertices.getContent().isMarked()){
        result = false;
      }
      vertices.next();
    }
    return result;
  }

  public boolean allEdgesMarked(){
    boolean result = true;
    edges.toFirst();
    while (edges.hasAccess()){
      if (!edges.getContent().isMarked()){
        result = false;
      }
      edges.next();
    }
    return result;
  }

  public List<Vertex> getNeighbours(Vertex pVertex){
    List<Vertex> result = new List<Vertex>();
    edges.toFirst();
    while (edges.hasAccess()){
      Vertex[] vertexPair = edges.getContent().getVertices();
      if (vertexPair[0] == pVertex) {
        result.append(vertexPair[1]);
      } else { 
        if (vertexPair[1] == pVertex){
          result.append(vertexPair[0]);
        }
      }
      edges.next();
    }    
    return result;
  }

  public List<Edge> getEdges(Vertex pVertex){
    List<Edge> result = new List<Edge>();
    edges.toFirst();
    while (edges.hasAccess()){
      Vertex[] vertexPair = edges.getContent().getVertices();
      if (vertexPair[0] == pVertex) {
        result.append(edges.getContent());
      } else{ 
        if (vertexPair[1] == pVertex){
          result.append(edges.getContent());
        }
      }
      edges.next();
    }    
    return result;
  }

  public Edge getEdge(Vertex pVertex, Vertex pAnotherVertex){
    Edge result = null;
    edges.toFirst();
    while (edges.hasAccess() && result == null){
      Vertex[] vertexPair = edges.getContent().getVertices();
      if ((vertexPair[0] == pVertex && vertexPair[1] == pAnotherVertex) ||
      (vertexPair[0] == pAnotherVertex && vertexPair[1] == pVertex)) {
        result = edges.getContent();
      } 
      edges.next();
    }    
    return result;
  }

  public boolean isEmpty(){
    return vertices.isEmpty();
  }
}