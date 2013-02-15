package models;
 
import javax.persistence.Entity;
import play.db.jpa.Model;
 
@Entity
public class TransportFile extends Model {

  public String column1;
  public String column2;
  public String column3;

  public TransportFile() {
  }


}