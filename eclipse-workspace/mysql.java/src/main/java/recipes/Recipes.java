package recipes;

import recipes.dao.DbConnection;

public class Recipes {

	public static void main(String[] args) {
		// Test getting a connection
		DbConnection.getConnection();
	}

}
