package assignment;

import java.util.List;

public class Runclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	StoreDAO sdao = new StoreDAO();
		
		List<StoreEntity> storedata = sdao.getAllData();
		storedata.forEach(se -> {System.out.println(se);
	});
		System.out.println("\n\n\ncategory data\n");
		List<StoreEntity> categorydata = sdao.getCategoryData();
		categorydata.forEach(se -> {System.out.println("category: " + se.getOrderStatus() + " : " + se.getUserId());
		});
	
//		int [] result = sdao.addbatchimages();
//		System.out.println("batch inserting");
//		for(int i=0; i < result.length; i++) {
//			System.out.println("result is : " + result[i]);
//		}
	}

}
