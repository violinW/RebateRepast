package member;

import java.util.List;

public interface memberInterface {
	
	public void addMember(Object data);
	
	public void updateMember(String UUID, Object data);
	
	public void deleteMember(String UUID);
	
	public Object queryMember(String UUID);
	
	public List<Object> getAllMember();
	
	public List<Object> getMemberByBD(String BD_UUID);
}
