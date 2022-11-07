package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.*;
import java.text.SimpleDateFormat;

public class DateTime{

    //return formatted data for TID (in payment)
    public String paymentDateTime() {
        //get current time
        LocalDateTime myDateObj = LocalDateTime.now();
        //XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes
        //change format of the datetime
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        //change date time obj to string 
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public String reviewDateTime() {
        //get current time
        LocalDateTime myDateObj = LocalDateTime.now();
        //change format of the datetime
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //change date time obj to string 
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public String stringToDate(String stringdate){

        // TODO: convert string format to date format
    }
    
}