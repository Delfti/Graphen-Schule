public class Vertex{
  private String id;
  private boolean mark;
  
  public Vertex(String pID){
    id = pID;
    mark = false;
  }
  
  public String getID(){
    return new String(id);
  }
  
  public void setMark(boolean pMark){
    mark = pMark;
  }
  
  public boolean isMarked(){
    return mark;
  }
}