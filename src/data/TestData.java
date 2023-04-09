package data;
import java.util.Arrays;

public class TestData {
	 /**
     * The main method of the class, which creates 
     * a new instance of the Data class and performs some operations on it.
     * @param args the command line arguments, which are expected to contain 
     * the minimum and maximum values of the data range, followed by the data values themselves
     */
public static void main(String[] args) {
	try {
		double min=Double.parseDouble(args[0]);
		double max=Double.parseDouble(args[1]);
		Data data =new Data(Arrays.copyOfRange(args, 2,args.length), min, max);
		System.out.println(data);
		data.setRange("0;4");
		data.setRange("15 25");
	}
	catch(DataException e) {
		System.out.println(e.getMessage());
	}
	catch(IndexOutOfBoundsException e) {
		System.out.println("Error, the data is insuficienr");
	}
	catch (NumberFormatException e) {
		System.out.println("Error,this is not a real number ("+e.getMessage()+")");
		}
	}
}
