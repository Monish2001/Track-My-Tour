package utils;
import java.util.UUID;

public class UUIDGenerator{
	public String uuid(){
		UUID uuid = UUID.randomUUID();
	    String uuidAsString = uuid.toString();
	    
	    //System.out.println(uuidAsString);
	    return uuidAsString;
	}
}
