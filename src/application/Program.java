package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao=DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1:seller findById ===");
		
		Seller seller= sellerDao.findById(3);
		
		System.out.println(seller);

		System.out.println("\n=== Teste 2:seller findByDepartment ===");
		Department dep = new Department(2,null);
		List<Seller> list =sellerDao.findByDepartment(dep);
		for(Seller obj :list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3:seller findall ===");
		list =sellerDao.findall();
		for(Seller obj :list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 4:seller insert: ===");
		Seller newSeller=new Seller(null,"Greg yellow","greg@gmail.com",new Date(),4000.0,dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted!new id = "+newSeller.getId());
		
		System.out.println("\n=== Teste 4:seller update: ===");		
		seller=sellerDao.findById(9);
		seller.setName("Sarah Black");
		sellerDao.update(seller);
		System.out.println("Update done!Name= " +seller.getName()+",ID= "+seller.getId());
		
	}
}
