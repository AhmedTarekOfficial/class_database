import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fetch_elements extends database_connection {

    PreparedStatement psd;
    ResultSet rst;
    String table_name;




    ArrayList<String> columns = new ArrayList<>();

    public Fetch_elements(String table_name, String... col) {

        this.table_name = table_name;
        for (String cl : col) {
            this.columns.add(cl);
        }
    }

    public Fetch_elements(String table_name) {
        this.table_name = table_name;
    }


    public String get_specific_data() {
        StringBuilder queryBuilder = new StringBuilder("SELECT ");

        for (int i = 0; i < columns.size(); i++) {
            queryBuilder.append(columns.get(i));
            if (i < columns.size() - 1) {
                queryBuilder.append(", ");
            }

        }

        queryBuilder.append(" from " + table_name);
        return queryBuilder.toString();

    }



    public String get_specific_data_with_condition(){



return get_specific_data_with_condition();
    }


    public void fetchElementsFromDatabase() {
        connection_data();
        try {
            psd = con.prepareStatement(get_specific_data());
            rst = psd.executeQuery();

            while (rst.next()) {
                for (String column : columns) {
                    String value = rst.getString(column);

                    System.out.print(value + "\t");
                }

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();
    }






}
