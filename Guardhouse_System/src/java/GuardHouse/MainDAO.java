/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuardHouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariff
 */
public class MainDAO {

    private final Connection con;

    public MainDAO() throws ClassNotFoundException {
        con = DBConnection.getConnection();
    }

    public User SearchUser(String Identification) {
        User user = new User();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `visitor` WHERE Identification = ?");
            ps.setString(1, Identification);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setCounter(1);
            } else {
                user.setCounter(0);
            }
            while (rs.next()) {
                user.setIdentification(rs.getString("Identification"));
                user.setFullName("FullName");
                user.setIdentificationType("IdentificationType");
                user.setVisitorType("VisitorType");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void AddUser(User user) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `visitor` (`Identification`, `FullName`, `BriefingDateStart`, `BriefingDateEnd`, `VisitorType`, `Company`, `IdentificationType`) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, user.getIdentification());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getBriefingDateStart());
            ps.setString(4, user.getBriefingDateEnd());
            ps.setString(5, user.getVisitorType());
            ps.setString(6, user.getCompany());
            ps.setString(7, user.getIdentificationType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int CheckIn(String Identification) {
        int output = 0;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `checkin` (`Identification`) VALUES (?)");
            PreparedStatement ps2 = con.prepareStatement("SELECT * FROM `checkin` WHERE Identification = ?");
            ps.setString(1, Identification);
            ps2.setString(1, Identification);
            ps.execute();
            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {
                output = 1;
            } else {
                output = 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void CheckOut(String Identification, String CheckIn) {
        System.out.println(Identification);
        CheckIn CI = new CheckIn();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `checkin` WHERE Identification = ?");
            ps.setString(1, Identification);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CI.setIdentification(rs.getString("Identification"));
                CI.setDate(rs.getString("Date"));
                CI.setCheckInTime(rs.getString("CheckInTime"));
                CI.setCheckInDate(rs.getString("CheckIn"));
                PreparedStatement ps3 = con.prepareStatement("INSERT INTO `checkout` (`Identification`,`CheckInTime`,`CheckInDate`,`CheckIn`) VALUES (?,?,?,?)");
                ps3.setString(1, CI.getIdentification());
                ps3.setString(2, CI.getCheckInTime());
                ps3.setString(4, CI.getCheckInDate());
                ps3.setString(3, CI.getDate());
                ps3.execute();
                PreparedStatement ps2 = con.prepareStatement("DELETE FROM checkin WHERE `checkin`.`Identification` = ?");
                ps2.setString(1, Identification);
                ps2.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> SearchVisitor(String QueryResult) {
        List<User> user1 = new ArrayList<>();
        User user = new User();
        Set<User> uniqueUsers = new HashSet<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `visitor` WHERE Identification = ? OR FullName = ? OR IdentificationType = ? OR VisitorType = ? OR Company = ?");
            ps.setString(1, QueryResult);
            ps.setString(2, QueryResult);
            ps.setString(3, QueryResult);
            ps.setString(4, QueryResult);
            ps.setString(5, QueryResult);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setIdentification(rs.getString("Identification"));
                user.setFullName(rs.getString("FullName"));
                user.setIdentificationType(rs.getString("IdentificationType"));
                user.setVisitorType(rs.getString("VisitorType"));
                user.setCompany(rs.getString("Company"));
                user.setBriefingDateStart(rs.getString("BriefingDateStart"));
                user.setBriefingDateEnd(rs.getString("BriefingDateEnd"));
                uniqueUsers.add(user);
            }
            user1.addAll(uniqueUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (User user2 : user1) {
            System.out.println("Identification: " + user2.getIdentification());
            System.out.println("Full Name: " + user2.getFullName());
            System.out.println("Identification Type: " + user2.getIdentificationType());
            System.out.println("Visitor Type: " + user2.getVisitorType());
            System.out.println("Company: " + user2.getCompany());
            System.out.println("Briefing Date Start: " + user2.getBriefingDateStart());
            System.out.println("Briefing Date End: " + user2.getBriefingDateEnd());
            System.out.println("--------------------------------------");
        }
        return user1;
    }
}
