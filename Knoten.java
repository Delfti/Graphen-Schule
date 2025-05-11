public class Knoten extends Vertex{
  private String ID;
  private boolean markiert, besucht;
  private double lange;
  Knoten Vorganger;
  
  public Knoten(String pID){
    super(pID);
    ID = pID;
    besucht = false;
    lange = Double.POSITIVE_INFINITY;
  }
  
  public String getID(){
    return ID;
  }
  
  public void setBesucht(boolean pEingabe){
    besucht = pEingabe;
  }
  
  public boolean isBesucht(){
    return besucht;
  }
  
  public double getlange(){
    return lange;
  }
  
  public void setlange(Double pNeu, Knoten pVorganger){
    lange = pNeu;
    Vorganger = pVorganger;
  }
  
  public Knoten getVorganger(){
    return Vorganger;
  }
}