// ******* NOTE: the following code will compile on nike in your project1 
//               directory with the command   javac *.java
// The code that is commented out is pseudo-code only
// Thus, you will have to make any necessary corrects to compile it.
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Database
{
   public static void main(String[] args)
   {
      // *** declare the DBUSER commands file
      String fileName = "DBUSER.txt";
      File dbfile = new File("DBUSER.txt");
            // ** create empty error log file
      
      // ** create empty status log file
      try
      {
      // declare the message string 
      String message;
      // open dbuser file by creating a file object
      Scanner infile = new Scanner(dbfile);
      // declare the status log file
      File statfile = new File("status.txt");	  
      // declare the error log file
      File errfile = new File("error.txt");
      //  *** create an instance of the DBCommands class
      DBCommands DBcomm = new DBCommands();
      //System.out.println("Made it this far...");
      FileWriter statWrite = new FileWriter(statfile,true);
      FileWriter errWrite = new FileWriter(errfile,true);
      PrintWriter pw = new PrintWriter(statWrite);
      PrintWriter pwe = new PrintWriter(errWrite);
	  //  ***  Loop until EOF DBUSER file
	  while (infile.hasNextLine()) 
	  {
	    //  ***  read and parse each command string
		//System.out.println("hi");
	    String command = infile.nextLine();
	    
	    // String command = nextline()
	    //  ***  Finish this conditionals to test each command string
	    if (command.substring(0,15).equals("CREATE DATABASE"))
	    {
	    	
		  // finish call to create database method pass database name
		  if (DBcomm.CreateDatabase(command.substring(16)))
		  {
			  
			  // write success status message as a record to status file
			  
			  statWrite.write("Database " + command.substring(16) + " created");
			  pw.println();
		  }
		  else
		  {
			  
			  // write failure error message as a record to error file
			  
			  errWrite.write("Database " + command.substring(16) + " could not be created");
			  pwe.println();
		  }
	    }
	  

	    
		if(command.substring(0,13).equals("DROP DATABASE"))
		{
			if(DBcomm.DropDatabase(command.substring(14)))
			{
				
				statWrite.write("Database " + command.substring(14) + " deleted");
				pw.println();
			}
			else
			{
				
				errWrite.write("Database " + command.substring(14) + " could not be deleted");
				pwe.println();
			}
		}
		if(command.substring(0,12).equals("CREATE TABLE"))
		{
			if(DBcomm.CreateTable(command.substring(13,command.indexOf(".")), command.substring(command.indexOf("."))))
			{
				
				statWrite.write("Table " + command.substring(command.indexOf(".")) + " created");
				pw.println();
			}
			else
			{
				
				errWrite.write("Table " + command.substring(command.indexOf(".")) + " could not be created");
				pwe.println();
			}
		}
		if(command.substring(0,10).equals("DROP TABLE"))
		{
			if(DBcomm.DropTable(command.substring(11,command.indexOf(".")), command.substring(command.indexOf("."))))
			{
				
				statWrite.write("Table " + command.substring(command.indexOf(".")) + " dropped");
				pw.println();
				
			}
			else
			{
				
				errWrite.write("Table " + command.substring(command.indexOf(".")) + " could not be dropped");
				pwe.println();
			}
		}
		
		if(command.substring(0,6).equals("INSERT"))
		{
			String i = command.substring(command.indexOf("\""),command.lastIndexOf("\"")+1);
			String db = command.substring(command.lastIndexOf("\"")+7 , command.indexOf("."));
			String tab = command.substring(command.indexOf("."));
			
			if(DBcomm.Insert(i,db,tab))
			{
				
				statWrite.write(i + " was successfully inserted");
				pw.println();
				
			}
			else
			{
				
				errWrite.write(i + " was not Inserted");
				pwe.println();
				
			}
		}
		
		if(command.substring(0,6).equals("SELECT"))
		{
			if(DBcomm.Select(command.substring(14, command.indexOf(".")), command.substring(command.indexOf("."))))
			{
				
				
				statWrite.write("Rows selected");
				pw.println();
			}
			else
			{
				
				
				errWrite.write("Rows not selected");
				pwe.println();
			}
			
		}
		
		if(command.substring(0,6).equals("DELETE"))
		{
			if(DBcomm.Delete(command.substring(12, command.indexOf(".")), command.substring(command.indexOf("."))))
			{
				
				
				statWrite.write("Contents deleted");
				pw.println();
			}
			else
			{
				
				
				errWrite.write("Contents not deleted");
				pwe.println();
			}
			
		}
		
		  
	    }
	  statWrite.close();
	  errWrite.close();
	 // end while
	   

         
	    //  create conditionals for all database commands and methods
	    // else if DROP DATABASE
		// else if CREATE TABLE
		// else if DROP TABLE
		// else if ....
	  }//  ***  catch any IO errors
	  
      catch(Exception e)
      {
         System.out.println("Problem with file "+fileName+",error="+e.getMessage());
         
         
       
        	
        	
        }
      
 
      
      
   
}
}

