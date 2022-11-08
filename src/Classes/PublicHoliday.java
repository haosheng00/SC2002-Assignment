package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class PublicHoliday implements Serializable{
    private String name;
    private String stringdate;
    private LocalDate date;

    public PublicHoliday(String name, String stringdate){
        this.name = name;
        this.stringdate = stringdate;
    }

    public String getPublicHolidayName(){
        return name;
    }

    public String getPublicHolidayDate(){
        return stringdate;
    }

    public void setPublicHolidayName(String name){
        this.name = name;
    }

    public void setPublicHolidayDate(String stringdate){
        this.stringdate = stringdate;
    }

}
