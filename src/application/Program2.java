package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DepartmentDao departmentDao=DaoFactory.createDepartmentDao();
		
		System.out.println("=== Teste 1:Department findById ===");
		Department department= departmentDao.findById(3);
		System.out.println(department);
		
		List<Department> list =new ArrayList<Department>();
		System.out.println("\n=== Teste 2:department findall ===");
		list =departmentDao.findall();
		for(Department obj :list) {
			System.out.println(obj);
		}
		
		//System.out.println("\n=== Teste 3:department insert: ===");
		//Department newDep=new Department(null, "Music");
		//departmentDao.insert(newDep);
		//System.out.println("Inserted!New ID: "+newDep.getId());
		
		System.out.println("\n=== Teste 4:department update: ===");		
		Department dep=departmentDao.findById(1);
		dep.setName("chips");
		departmentDao.update(dep);
		System.out.println("Update done!Name= " +dep.getName()+",ID= "+dep.getId());
		
		System.out.println("\n=== Teste 5:department delete: ===");
		System.out.println("Id for delete:");
		int id=sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
