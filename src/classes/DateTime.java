package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents the Date Time class that handle that date and time in MOBLIMA
 */
public class DateTime {
    /**
     * Converts current date and time of format yyyyMMddHHmm
     * @return formatted date for TID (in payment)
     */
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

    /**
     * Converts current date and time of format yyyy-MM-dd HH:mm:ss
     * @return formatted date for reviews
     */
    public String reviewDateTime() {
        //get current time
        LocalDateTime myDateObj = LocalDateTime.now();
        //change format of the datetime
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //change date time obj to string 
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    /**
     * Converts an input date in String to Date
     * @param stringDate date in String type of format YYYYMMDD
     * @return date in Date type of format dd-MM-yyyy
     * @throws ParseException
     */
    public static Date stringToDate(String stringDate) throws ParseException{

        String year = stringDate.substring(0,4);
        String month = stringDate.substring(4, 6);
        String day = stringDate.substring(6, 8);
        String newStringDate = day + '-' + month + '-' + year;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date stringToDate = dateFormat.parse(newStringDate);

        return stringToDate;
    }

    /**
     * Converts an input date to formatted date in string
     * @param stringDate date in String type of format YYYYMMDD
     * @return date in String type of format dd-MM-yyyy
     */
    public static String dateFormatter(String stringDate){
       
        String year = stringDate.substring(0,4);
        String month = stringDate.substring(4, 6);
        String day = stringDate.substring(6, 8);
        String newStringDate = day + '-' + month + '-' + year;
        
        return newStringDate;
    }

    /**
     * Converts an input date to formatted date in string
     * @param stringTime time in String type of format HHmmss
     * @return time in String type of format HH:mm:ss
     */
    public static String timeFormatter(String stringTime){

        String hours = stringTime.substring(0,2);
        String minutes = stringTime.substring(2, 4);
        String seconds = stringTime.substring(4, 6);
        String newStringTime = hours + ':' + minutes + ':' + seconds;

        return newStringTime;
    }

    /**
     *  Converts an input date in String to Date
     * @param stringDate date in String type of format YYYYMMDD
     * @param stringTime stringTime time in the string type of HHmmss
     * @return date in Date type of format dd-MM-yyyy HH:mm:ss
     * @throws ParseException
     */
    public static Date stringToDateTime(String stringDate, String stringTime) throws ParseException{

        String year = stringDate.substring(0,4);
        String month = stringDate.substring(4, 6);
        String day = stringDate.substring(6, 8);
        String newStringDate = day + '-' + month + '-' + year;

        String hours = stringTime.substring(0,2);
        String minutes = stringTime.substring(2, 4);
        String seconds = stringTime.substring(4, 6);
        String newStringTime = hours + ':' + minutes + ':' + seconds;

        String newStringDateTime = newStringDate + ' ' + newStringTime;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date stringToDateTime = dateFormat.parse(newStringDateTime);

        return stringToDateTime;
    }
    
}