package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;


public class DateTime {

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

    public static Date stringToDate(String stringdate) throws ParseException{

        String year = stringdate.substring(0,4);
        String month = stringdate.substring(4, 6);
        String day = stringdate.substring(6, 8);
        String newstringdate = day + '-' + month + '-' + year;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date stringToDate = dateFormat.parse(newstringdate);

        return stringToDate;
    }
    
}