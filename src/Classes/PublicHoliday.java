package classes;

import java.io.Serializable;

/**
 * Represents the public holiday class that is recognized by MOBLIMA Athay
 */
public class PublicHoliday implements Serializable{
    /**
     * Represents the name of public holiday
     */
    private String name;
    /**
     * Represents date of public holiday in String type of format YYYYMMDD
     */
    private String stringdate;

    /**
     * Constructs a public holiday initialised with a specific name and date
     * @param name name of public holiday
     * @param stringdate date of public holiday
     */
    public PublicHoliday(String name, String stringdate){
        this.name = name;
        this.stringdate = stringdate;
    }

    /**
     * Returns name of public holiday
     * @return name of the public holiday
     */
    public String getPublicHolidayName(){
        return name;
    }

    /**
     * Returns date of public holiday
     * @return date of the public holiday
     */
    public String getPublicHolidayDate(){
        return stringdate;
    }

    /**
     * Sets the name of the a public holiday
     * @param name name of public holiday
     */
    public void setPublicHolidayName(String name){
        this.name = name;
    }

    /**
     * Sets the date of the public holiday
     * @param stringdate date of public holiday
     */
    public void setPublicHolidayDate(String stringdate){
        this.stringdate = stringdate;
    }

}
