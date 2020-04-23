// *************************
// Note: the following code will compile on nike, however you must run
//     javac *.java  from your project1 directory
// *************************
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;
public class DBCommands
{ 
// DBCOmmands()  constructor


public static boolean CreateDatabase(String dbName)
{
   try
   {
    
     
     // create File object for dbName
	   File fc = new File("/home/ugrads/phadke/Project1/" + dbName);
	   fc.mkdir();
     // call mkdir(); method to create directory
     // return true; if it works
     //message = "Database "+dbName+" created.";
     return true;
     
   }
   catch (Exception e)   // catch error
   {
     // return true; if it works
	 
     //message = "Database "+dbName+" could not be created."+e.getMessage();
     return false;
   } // end catch
} // end createDatabase
	
  //  DROP DATABASE method
public static boolean DropDatabase(String dbName)
{

	try
	{
		File fd = new File(dbName);
		if (fd.isDirectory())
		{
			File[] fileList = fd.listFiles();
			for(int i = 0; i < fileList.length; i++)
			{
				fileList[i].delete();
			}
			
			fd.delete();
			return true;
		}
		else
		{
			return false;
		}
	}
	catch(Exception e)
	{
		//message = "Database "+dbName+" could not be deleted."+e.getMessage();
		return false;
	}
}
  //  CREATE TABLE method

public static boolean CreateTable(String dbName, String tabName)
{
	try
	{
		
	
	File table = new File("/home/ugrads/phadke/Project1/" + dbName + "/" + tabName);
	table.createNewFile();
	return true;
	
	}
	catch(Exception e)
	{
		return false;
	}

}
  
  //  DROP TABLE method
public static boolean DropTable(String dbName, String tabName)
{
	try
	{
		
		File table = new File("/home/ugrads/phadke/Project1/" + dbName + "/" + tabName);	
		table.delete();
		return true;
	
	}
	catch(Exception e)
	{
		return false;
	}
}

  //  INSERT method
public static boolean Insert(String insert, String dbName, String tabName)
{
	try
	{
		
		FileWriter fw = new FileWriter("/home/ugrads/phadke/Project1/" + dbName + "/" + tabName,true);
		PrintWriter pw = new PrintWriter(fw);
		fw.write(insert);
		pw.println();
		
		fw.close();
		return true;
	}
	
	catch(Exception e)
	{
		//System.out.println(e.getMessage());
		return false;
	}
	
}
  //  SELECT method (without the where)

public static boolean Select(String dbName, String tabName)
{
	
   try
   {
	   File dir = new File("/home/ugrads/phadke/Project1/" + dbName + "/" + tabName);
	   Scanner scan = new Scanner(dir);
	   FileWriter fw = new FileWriter("/home/ugrads/phadke/Project1/status.txt",true);
	   while(scan.hasNextLine())
	   {
		   String info = scan.nextLine();
		   fw.append(info);
		   
	   }
	   fw.close();
	   return true;
	   
   }
   catch (Exception e)   // catch error
   {
     // return true; if it works
     
     return false;
   } // end catch
} // end

/*//  SELECT method (with the where)
public static boolean SelectWhere(String recordName, String DBName, String TableName, String message)
{
   try
   {
	   // if DBName.TableName exists()  *** use this a lot
	   // SCANNER readline into newrecord from table

	   // while d(hasnextline)
	   //      PRINTWRITER println (newrecord)
	   //      if recordName == newrecord
	   //            PRINTWRITER println ("Row FOUND for colleges.students") to status
	   //            println found it......
	   //            exit loop
	   //      else print error to error log
	   // end while
	   // PRINTWRITER println (SELECT * FROM colleges.students)
   }
   catch (Exception e)   // catch error
   {
     // return true; if it works
     message = "Database "+dbName.getMessage();
     return false;
   } // end catch
} // end	   
  */
  //  DELETE method (without the where)
public static boolean Delete(String dbName, String tabName)
{
   try
   {
	   File f = new File("/home/ugrads/phadke/Project1/" + dbName + "/" + tabName);
	   f.createTempFile(dbName, tabName);
	   f.delete();
	   return true;
   }
   catch (Exception e)   // catch error
   {
     
     return false;
   } // end catch
} // end
}

 // end of class DBCommands
