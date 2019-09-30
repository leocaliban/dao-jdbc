package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();

		System.out.println("===== TEST 1: Seller find by id =====");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);

		System.out.println("===== TEST 2: Seller find by Department =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);
		list.forEach(s -> System.out.println(s));
	}

}
