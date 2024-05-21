package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to get random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		return randomInt;	
	}
	/**
	 * This method is used to get system
	 * @return
	 */
	public String getSystemDate()
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String Date = sim.format(dateObj);
		return Date;
	}
	/**
	 * This method is used to get date before and after current system date
	 * @param days
	 * @return
	 */
	public String getRequiredDate(int days)
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String Date = sim.format(dateObj);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String RequiredDate = sim.format(cal.getTime());
		return RequiredDate;
	}

}
