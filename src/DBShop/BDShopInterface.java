package DBShop;

import java.util.List;

public interface BDShopInterface {

	public void addShop(Object data);
	
	public void updateShop(Object data);
	
	public List<Object> getShopsByBD(String BD_UUID);
}
