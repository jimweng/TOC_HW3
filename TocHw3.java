/*
	Name       : ¿¿¿
	Student ID : F74019041
	Description: This code is used for parse the average real price information
				 from the website of government supplied.
				 
*/
import java.lang.Object;
import org.json.*;
import java.util.regex.*;
import java.net.*;
import java.io.*;
public class TocHw3{

	
	public static void main(String[] args)throws Exception,JSONException
	{
		String uRL,county,roadName;
		int year;		
		try
		{

			//Read Command Line
			//
			uRL=args[0];
			URL website = new URL(uRL);
			BufferedReader in= new BufferedReader(new InputStreamReader(website.openStream(),"UTF-8"));
			county=args[1];
			roadName=args[2];
			year=Integer.parseInt(args[3])*100;
		
			//Read JSON file
			//
			JSONObject json = new JSONObject();
			JSONTokener realPrice= new JSONTokener(in);
			JSONArray findAnswer = new JSONArray(realPrice);
			//Start
			//
			String area,location;
			int month,totalPrice,result=0,counter=0,answer=0;
			for(int i=0;i<findAnswer.length();i++)
			{
				json=findAnswer.getJSONObject(i);
				area=json.getString("¿¿¿¿");
				location=json.getString("¿¿¿¿¿¿¿¿¿¿¿¿");
				month=json.getInt("¿¿¿¿");
				totalPrice=json.getInt("¿¿¿");
				if(area.contains(county)&&location.contains(roadName))
				{
					if(month>=year)
					{
						counter++;
						result+=totalPrice;
					}
				}
			}
			if(counter!=0)
			{	
				answer=result/counter;
				System.out.println(answer);
			}
			//Handle search never match, which makes denominator be zero.
			//
			//
			else
				System.out.println("No Data match");
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("Somewhere be error");
			System.exit(1);
		}
		
		
		
	}
}
