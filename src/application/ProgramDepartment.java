package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

		System.out.println("===== TEST 1: Department find by id =====");
		Department department = departmentDAO.findById(1);
		System.out.println(department);

		System.out.println("===== TEST 2: Department find all =====");
		List<Department> list = departmentDAO.findAll();
		list.forEach(s -> System.out.println(s));

		System.out.println("===== TEST 3: Department insert =====");
		Department newDepartment = new Department(null, "TESTE");
		departmentDAO.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("===== TEST 4: Department update =====");
		department = departmentDAO.findById(5);
		department.setName("Food");
		departmentDAO.update(department);
		System.out.println("Updated!");

		System.out.println("===== TEST 5: Department delete =====");
		departmentDAO.deleteById(5);
		System.out.println("Deleted!");
	}

}
