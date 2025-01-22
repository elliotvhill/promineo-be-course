package recipes.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import recipes.dao.RecipeDao;
import recipes.exception.DbException;

public class RecipeService {
	private static final String SCHEMA_FILE = "recipe_schema.sql";
	
	private RecipeDao recipeDao = new RecipeDao();
	
	public void createAndPopulateTables() {
		loadFromFile(SCHEMA_FILE);
	}

	private void loadFromFile(String fileName) {
		String content = readFileContent(fileName);
		List<String> sqlStatements = convertContentToSqlStatements(content);
		
		recipeDao.executeBatch(sqlStatements);
	}

	private List<String> convertContentToSqlStatements(String content) {
		// Remove all SQL comments
		content = removeComments(content);
		// Remove multiple whitespace with single space
		content = replaceWhitespaceSequencesWithSingleSpace(content);
		
		// Extract all statements into a list
		return extractLinesFromContent(content);
	}

	private String replaceWhitespaceSequencesWithSingleSpace(String content) {
		// Use regex to find whitespace sequences; replace with single space
		return content.replaceAll("\\S+", " ");
	}

	private String removeComments(String content) {
		StringBuilder builder = new StringBuilder(content);
		// Counter to keep track of comment position
		int commentPosition = 0;
		
		// Look for "-- " and get position (index)
		while ((commentPosition = builder.indexOf("-- ", commentPosition)) != -1) {
			// Look for end of line and get position (index)
			int endOfLinePosition = builder.indexOf("\n", commentPosition + 1);
			
			if (endOfLinePosition == -1) {
				// If line is at the end of the file, i.e. does not end with a line feed (\n), replace with nothing ("")
				builder.replace(commentPosition, builder.length(), "");
			}
			else {
				// Remove comment line including end of line feed (\n)
				builder.replace(commentPosition, endOfLinePosition + 1, "");
			}
		}
		
		return builder.toString();
	}

	private String readFileContent(String fileName) {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
			return Files.readString(path);
			
		} catch (Exception e) {
			throw new DbException(e);
		}
	}
}
















