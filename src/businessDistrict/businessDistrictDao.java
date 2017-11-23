package businessDistrict;

import java.util.List;

import com.mysql.jdbc.Statement;

import common.DbAccess;

public class businessDistrictDao implements businessDistrictInterface{

	@Override
	public List<Object> getAllBusinessDistrict() {
		System.out.println("getAllBusinessDistrict 获得所有商圈\n\n");
		
		
		
		return null;
	}

	@Override
	public Object getSingleBusinessDistrict(String UUID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class businessDistrictType{
		String UUID;
		String bd_name;
		String namebd_abstract;
	}

}
