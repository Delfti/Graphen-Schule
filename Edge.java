public class Edge{
  private Vertex[] vertices;
  private double weight;
  private boolean mark;
  
  public Edge(Vertex pVertex, Vertex pAnotherVertex, double pWeight){
    vertices = new Vertex[2];
    vertices[0] = pVertex;
    vertices[1] = pAnotherVertex;
    weight = pWeight;
    mark = false;
  }
  
  public Vertex[] getVertices(){
    Vertex[] result = new Vertex[2];
    result[0] = vertices[0]; 
    result[1] = vertices[1];
    return result;
  }
  
  public void setWeight(double pWeight){
    weight = pWeight;
  } 
  
  public double getWeight(){
    return weight;
  } 
  
  public void setMark(boolean pMark){
    mark = pMark;
  }
  
  public boolean isMarked(){
    return mark;
  }
}