package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAOJDBC implements SellerDAO {

	private Connection connection;

	public SellerDAOJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			statement = connection.prepareStatement(
					"SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?");
			statement.setInt(1, id);

			result = statement.executeQuery();

			if (result.next()) {
				Department department = instantiateDepartment(result);
				Seller seller = instantiateSeller(result, department);
				return seller;
			}
			return null;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(statement);
			DB.closeResultSet(result);
		}
	}

	private Seller instantiateSeller(ResultSet result, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(result.getInt("Id"));
		seller.setName(result.getString("Name"));
		seller.setEmail(result.getString("Email"));
		seller.setBaseSalary(result.getDouble("BaseSalary"));
		seller.setBirthdate(result.getDate("BirthDate"));
		seller.setDepartment(department);
		return seller;
	}

	private Department instantiateDepartment(ResultSet result) throws SQLException {
		Department department = new Department();
		department.setId(result.getInt("DepartmentId"));
		department.setName(result.getString("DepName"));
		return department;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
