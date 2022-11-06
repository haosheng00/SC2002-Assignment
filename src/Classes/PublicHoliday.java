package Classes;

import java.time.LocalDate;

public class PublicHoliday {
    private String name;
    private String stringdate;
    private LocalDate date;

    public PublicHoliday(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    public String getPublicHolidayName(){
        return name;
    }

    public LocalDate getPublicHolidayDate(){
        return date;
    }

    public void setPublicHolidayName(String name){
        this.name = name;
    }

    public void setPublicHolidayDate(String stringdate){
        this.stringdate = stringdate;
    }

}
