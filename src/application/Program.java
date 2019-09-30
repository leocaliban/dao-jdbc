package application;

import java.util.Date;
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

		System.out.println("===== TEST 3: Seller find all =====");
		list = sellerDAO.findAll();
		list.forEach(s -> System.out.println(s));

		System.out.println("===== TEST 4: Seller insert =====");
		Seller newSeller = new Seller(null, "Jack", "jack@gmail.com", new Date(), 4000.0, department);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("===== TEST 5: Seller update =====");
		seller = sellerDAO.findById(7);
		seller.setName("Jack Bauer");
		sellerDAO.update(seller);
		System.out.println("Updated!");
	}

}
