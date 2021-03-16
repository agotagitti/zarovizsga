package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DogTypes {

    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> getDogsByCountry(String country) {
        List<String> foundDogs;
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select name from dog_types where country = ?")) {
            pstmt.setString(1, country.toUpperCase());
            foundDogs = getNamesByPrepStatement(pstmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot access datasource", se);
        }
        Collections.sort(foundDogs, Collator.getInstance(new Locale("hu", "HU")));
        return foundDogs;
    }

    private List<String>  getNamesByPrepStatement(PreparedStatement pstmt) {
        List<String> foundDogs = new ArrayList<>();
        try (ResultSet rs = pstmt.executeQuery()) {
            while(rs.next()) {
                foundDogs.add(rs.getString("name").toLowerCase());
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Wrong statement", se);
        }
        return foundDogs;
    }


}
