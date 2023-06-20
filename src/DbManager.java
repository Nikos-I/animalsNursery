import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class DbManager {

    Connection conn;
    Statement stmt;
    ResultSet rs;

    private void getConnection() throws SQLException, IOException {
        Properties props=new Properties();
        try (InputStream in=Files.newInputStream(Paths.get("data/database.properties"))) {
            props.load(in);
        }
        String url=props.getProperty("url");
        String username=props.getProperty("username");
        String password=props.getProperty("password");
        conn=DriverManager.getConnection(url, username, password);
    }

    private ResultSet execSQL(String query) throws SQLException, IOException {
        getConnection();
        stmt=conn.createStatement();
        return stmt.executeQuery(query);
    }

    private void closeSQL() {
        //close connection ,stmt and resultset here
        try {
            conn.close();
        } catch (SQLException se) { /*can't do anything */ }
        try {
            stmt.close();
        } catch (SQLException se) { /*can't do anything */ }
//        try {
//            rs.close();
//        } catch (SQLException se) { /*can't do anything */ }

    }

    Animal addAnimalToDB(Animal newAnimal) {
        return newAnimal;
    }

    Animal editAnimalToDB(Animal eAnimal) {
        return eAnimal;
    }

    boolean delAnimalToDB(int idAnimal) {
        boolean res=false;
        return res;
    }
	ArrayList<Animal> listAnimalsFromDB(int id) throws SQLException, IOException {
		String query = ""; //
		if (id >= 0) query = "select * from fullanimal where idanimal = " + Integer.toString(id);
		else  query = "select * from fullanimal";

        getConnection();
		ResultSet rsLocal = execSQL(query);
		ArrayList<Animal> listAni = new ArrayList();

		try {
			while (rsLocal.next()) {
				Animal ani=new Animal();
				ani.idAnimal=rsLocal.getInt(1);
				ani.nameAnimal=rsLocal.getString(2);
				ani.typeAnimal=rsLocal.getString(3);
				ani.usingAnimal=rsLocal.getString(4);
				ani.dateOfBirth=rsLocal.getDate(5);
				listAni.add(ani);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
            closeSQL();
		}
		return listAni;
	}

    ArrayList<String> listCommandFromDB(int id) throws SQLException, IOException {
        String query="select command from commandsanimal where idanimal = " + id;
        getConnection();

        ResultSet rsLocal=execSQL(query);
        ArrayList<String> listCom=new ArrayList();

        try {
            while (rsLocal.next()) {
                String com=rsLocal.getString(1);
                listCom.add(com);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeSQL();
        }
        return listCom;
    }

}
