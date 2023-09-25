/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuardHouse;

/**
 *
 * @author ariff
 */
public class User {
    
    private static String Identification;
    private static String FullName;
    private static String BriefingDateStart;
    private static String BriefingDateEnd;
    private static String VisitorType;
    private static String Company;
    private static String IdentificationType;
    private static int Counter;

    
    
    public String getIdentification() {
        return Identification;
    }

    public void setIdentification(String Identification) {
        User.Identification = Identification;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        User.FullName = FullName;
    }

    public String getBriefingDateStart() {
        return BriefingDateStart;
    }

    public void setBriefingDateStart(String BriefingDateStart) {
        User.BriefingDateStart = BriefingDateStart;
    }

    public String getBriefingDateEnd() {
        return BriefingDateEnd;
    }

    public void setBriefingDateEnd(String BriefingDateEnd) {
        User.BriefingDateEnd = BriefingDateEnd;
    }

    public String getVisitorType() {
        return VisitorType;
    }

    public void setVisitorType(String VisitorType) {
        User.VisitorType = VisitorType;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        User.Company = Company;
    }

    public String getIdentificationType() {
        return IdentificationType;
    }

    public void setIdentificationType(String IdentificationType) {
        User.IdentificationType = IdentificationType;
    }

    public int getCounter() {
        return Counter;
    }

    public void setCounter(int Counter) {
        User.Counter = Counter;
    }
    
}
