package data;
import java.util.ArrayList;
/**
 * The Data class represents a collection of numeric data, along with a range of
 * valid values. The class provides methods for calculating the average and
 * standard deviation of the data within the specified range.
 */
public class Data {
	private ArrayList <Double>data;
	private ArrayList<String> errors;
	private double min;
	private double max;
	  /**
     * Constructs a new Data object with the specified array of string values,
     * minimum valid value, and maximum valid value.
     * @param dates an array of string values representing the data
     * @param min   the minimum valid value
     * @param max   the maximum valid value
     */
public Data(String[]dates, double min, double max) {
	this.min=min;
	this.max=max;
	data= new ArrayList<>();
	errors= new ArrayList<>();
	for (String d:dates) {
		try {Double.parseDouble(d);
		}
		catch (NumberFormatException e) {
			errors.add(d);		
		}	
	}
}
public double calcAverage() {
	double sum=0;
	int n=0;
	for (double d:data)
		if (min<=d&&d<=max) {
			sum+=d;
			n++;
		}
	if(n==0) {
		throw new DataException("There are no data in the specified range");
	}
	return sum/n;
}
public double calcStandardDeviation() {
	double media=this.calcAverage();
	double sum=0;
	int n=0;
	for(double d:data)
		if(min<=d&&d<=max) {
			sum+=Math.pow(d-media,2);
		}
	return Math.sqrt(sum/n);
}
/**
 * Sets the range of valid values for the numeric data.
 * @param minmax a string representing the new minimum and maximum values,
 * separated by a semicolon (e.g., "0;10")
 * @throws DataException if the specified string is not in the correct format
 */
public void setRange(String minmax) {
	try {
		int index=minmax.indexOf(';');
	if (index==-1) {
		throw new DataException("Data error setting range");
	}
	Double.parseDouble(minmax.substring(0,index));
	Double.parseDouble(minmax.substring(index+1));
	}
	catch (NumberFormatException e) {
		throw new DataException("Data error setting range");
	}
}
public ArrayList<Double>getData(){
	return data;
}
public ArrayList<String>getErrors(){
	return errors;
}
@Override
public String toString() {
	String str="Min:"+min+","+" Max:"+max+" ,\n";
		str+=data.toString();
		str+=",\n";
		str+=errors.toString();
		str+=",\n Average:";
	try {
		str+=calcAverage();
	}
	catch (DataException e) {
		str+="Error";
	}
		str+=",StandDeviacion: ";
	try {
		str+=calcStandardDeviation();
	}
	catch(DataException e) {
		str+="Error";
	}
	return str;			
	}
}
