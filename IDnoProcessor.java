import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class IDNoProcessor
{
    private String idNo ;

    public IDNoProcessor(String idNumber)
    {
		idNo = idNumber;
	}
	
	private boolean isIDNoLengthValid()
	{
	    boolean figure = false;
		int length = 13;
		
		
		 if (length == idNo.length())
		 {
			 figure = true;
		 }
		 else
		 {
			 figure = false;
		 }
			 
		return figure ;
	}
	
	private boolean isIdNoLetterFree()
	{
		boolean check = false;
           
        for(int x=0;x<idNo.length();x++)
		{
			
			if(Character.isLetter(idNo.charAt(x)))
			{
				check = false;
				break;
			}
			else
			{
				check = true;
			}
			
		}			
		
		return check;
	}
	
	private boolean isIdNoSpecialCharacterFree()
	{
		Pattern pat = Pattern.compile("[^a-zA-Z0-9]");
	    Matcher mat = pat.matcher(idNo);
		
		boolean special = mat.find();
        
        if(special)
		{
			special = false;
		}			
		else
		{
			special = true;
		}
           
		
		
		return special;
	}
	
	public boolean isIdNoValid()
	{
		boolean isValid = false;
		
		
		if(isIDNoLengthValid() && isIdNoLetterFree() && isIdNoSpecialCharacterFree())
		{
			isValid = true;			
		}
		else
		{
			isValid = false;
		}
		
		return isValid;
	}
	
	public String extractDateOfBirth()
	{
		String extract = " ";
		
		for(int x=0;x<6;x++)
		{
			extract += idNo.charAt(x);
		}
		
		return extract;
	}
   
    public char extractGender()
	{
		char gender = ' ';
		String genderType = idNo.substring(6,7);
		int determine = Integer.parseInt(genderType);
		
		if(determine >= 0 && determine <=4 )
		{
		   gender = 'F';
		}
        else 
            if(determine >= 5 && determine <= 9)
			{
				gender = 'M';
			}				
		
		return gender;
	}

    public int extractRegistrationNo()
	{
		String regNo = idNo.substring(7,10);
		int det = Integer.parseInt(regNo);
		
		
		return det;
	}

   public String extractCitizenShipStatus()
	{
		String citizen = " ";
		String cStatus = idNo.substring(10,11);
		int myStatus = Integer.parseInt(cStatus);
		
		if(myStatus == 0)
		{
			citizen = "South African Citizen";
		}
		else
			if(myStatus == 1)
			{
				citizen = "Non South African Citizen";
			}else
				if(myStatus == 2)
				{
					citizen = "Refugee";
				}
		
		return citizen;
	}

     public int extractCheckSum()
	{
		String security = idNo.substring(12,14);
		int capture = Integer.parseInt(security);
		
		return capture;
	}


}