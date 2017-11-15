package shop;
import java.util.List;

public interface shopInterface {
	
	public List<Object> getAllShopsByBDUUID(String BDUUID); 
	
	public Object getShopByUUID(String shop_UUID); 
	
}
