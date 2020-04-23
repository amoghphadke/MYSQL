package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUIEvents {
	
	//Initalize variables
	
	
	
	@FXML
	private Button selectedText;
	
	@FXML
	private Button allText;
	
	@FXML
	private Button sweep;
	
	
	
	
	
	@FXML
	private TextField selectWindow;
	
	@FXML
	private TreeView tree;
	@FXML
	private MenuItem help;
	@FXML
	private TextArea commandWindow;
	@FXML
	private MenuItem openScript;
	@FXML
	private MenuItem runScript;
	
	@FXML
	private TextField logArea = new TextField();
	
	@FXML
	private MenuItem copy;
	@FXML
	private MenuItem paste;
	@FXML
	private MenuItem pref;
	
	@FXML
	private void logArea(ActionEvent e) throws IOException
	{
		
	}
	
	@FXML
	private void selectWindow(ActionEvent e ) throws IOException
	{
		
	}
	
	@FXML
	private void treeArea(ActionEvent e ) throws IOException
	{
		
	}
	
	//takes selected text and runs it through the database class
	@FXML
	private void whenSelectedText(ActionEvent e) throws IOException
	{
		
		
		String someThing = "";
		someThing = commandWindow.getSelectedText().trim();
		if(someThing == null)
		{
			System.out.println("is null");
		}
		System.out.println(someThing);
		Database dat = new Database();
		dat.function(someThing);
		
		
		//logArea.appendText("hey");
		File f = new File("status.txt");
		Scanner scan = new Scanner(f);
		
		while(scan.hasNextLine())
		{
			logArea.setText(scan.nextLine());
			System.out.println("");
		}
		
		File err = new File("error.txt");
		Scanner scan2 = new Scanner(err);
		
		while(scan2.hasNextLine())
		{
			logArea.setText(scan2.nextLine());
			System.out.println("");
		}
	}
	
	
	
	//splits text by line and runs them all at once
	@FXML
	private void whenAllText(ActionEvent e) throws IOException
	{
		
	
		Database dat = new Database();
		String str = commandWindow.getText();
		//System.out.println(str);
		String [] arr;
		arr = str.split("\\n");
		//System.out.println(arr[0]);
		//System.out.println(arr.length);
		for(int i = 0; i < arr.length; i++)
		{
			
			String s = arr[i];
			System.out.println(s);
			dat.function(s);
		}
		
		File f = new File("status.txt");
		Scanner scan = new Scanner(f);
		
		while(scan.hasNextLine())
		{
			logArea.appendText(scan.nextLine());
			logArea.appendText(" , ");
			
			
		}
		
		File err = new File("error.txt");
		Scanner scan2 = new Scanner(err);
		
		while(scan2.hasNextLine())
		{
			logArea.appendText(scan2.nextLine());
			logArea.appendText(" , ");
			
			
		}

	}
	
	//removes all text from the editor window
	@FXML
	private void removeText(ActionEvent e) throws IOException
	{
		commandWindow.clear();
	}
	
	//opens a popup describing the project
	@FXML
	private void aboutProject(ActionEvent e) throws IOException
	{
		//System.out.println("about reached");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setContentText("The purpose of this project is to create a database management system."
				+ " Each command should be typed into the editor and the correct button should be selected."
				+ " This will run the appropriate commands. The GUI aspect helped us learn the foundations"
				+ " of GUI creation in Java.");
		alert.showAndWait();
	}
	
	//copies selected text to the clipboard
	@FXML
	private void copyEdit(ActionEvent e) throws IOException
	{
		
		String copyText = commandWindow.getSelectedText().trim();
		Clipboard clipboard = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		content.putString(copyText);
		clipboard.setContent(content);
		//System.out.println("copied");
		
		//commandWindow.copy();
	}
	
	//pastes the clipboard content onto the location of the cursor
	@FXML
	private void pasteEdit(ActionEvent e) throws IOException
	{
		//System.out.println("I am pasting");
		String s = Clipboard.getSystemClipboard().getString();
		//System.out.println(s);
		
		commandWindow.paste();
		
	}
	
	//opens up a preferences window to change settings
	@FXML
	private void prefEdit(ActionEvent e) throws IOException
	{
		Stage dialog = new Stage();
		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();
		
		Label label1 = new Label();
		Label label2 = new Label();
		Label label3 = new Label();
		Label label4 = new Label();
		Label label5 = new Label();
		Label label6 = new Label();
		
		TextField box1 = new TextField();
		TextField box2 = new TextField();
		TextField box3 = new TextField();
		
		CheckBox check1 = new CheckBox();
		CheckBox check2 = new CheckBox();
		CheckBox check3 = new CheckBox();
		
		dialog.setTitle("Preferences");
		button1.setText("Font");		
		button2.setText("Font Size");		
		button3.setText("Font Color");		
		
		label1.setText("Click for a list of fonts");
		label2.setText("Click to adjust font size");
		label3.setText("Click to adjust font color");
		label4.setText("Bolded font");
		label5.setText("Italicized font");
		label6.setText("Underlined font");
	
		box1.setText("Answer question 1 here");
		box1.setMinSize(20, 75);
		box2.setText("Answer question 2 here");
		box2.setMinSize(20, 75);
		box3.setText("Answer question 3 here");
		box3.setMinSize(20, 75);
		
		StackPane newLayout = new StackPane();
		newLayout.getChildren().add(button1);
		button1.setTranslateX(-150);
		button1.setTranslateY(-200);
		
		newLayout.getChildren().add(label1);
		label1.setTranslateX(-150);
		label1.setTranslateY(-175);
		
		newLayout.getChildren().add(box1);
		box1.setTranslateY(-100);		
		
		newLayout.getChildren().add(check1);
		check1.setTranslateX(-150);
		check1.setTranslateY(185);
		
		newLayout.getChildren().add(label4);
		label4.setTranslateX(-150);
		label4.setTranslateY(200);
		
		newLayout.getChildren().add(button2);
		button2.setTranslateX(0);
		button2.setTranslateY(-200);
		
		newLayout.getChildren().add(label2);
		label2.setTranslateX(0);
		label2.setTranslateY(-175);
		
		newLayout.getChildren().add(box2);
		box2.setTranslateY(0);		
		
		newLayout.getChildren().add(check2);
		check2.setTranslateX(0);
		check2.setTranslateY(185);
		
		newLayout.getChildren().add(label5);
		label5.setTranslateX(0);
		label5.setTranslateY(200);
				
		newLayout.getChildren().add(button3);
		button3.setTranslateX(150);
		button3.setTranslateY(-200);
		
		newLayout.getChildren().add(label3);
		label3.setTranslateX(150);
		label3.setTranslateY(-175);
		
		newLayout.getChildren().add(box3);
		box3.setTranslateY(100);		
		
		newLayout.getChildren().add(check3);
		check3.setTranslateX(150);
		check3.setTranslateY(185);
		
		newLayout.getChildren().add(label6);
		label6.setTranslateX(150);
		label6.setTranslateY(200);
				
		Scene newScene = new Scene(newLayout, 500, 500);
		dialog.setScene(newScene);
		dialog.show();
		
	}
	
	//opens a file and puts that file's text into the editor
	@FXML 
	private void openScript(ActionEvent e) throws IOException
	{
		JFileChooser choose = new JFileChooser();
		
		choose.showOpenDialog(null);
		//choose.getSelectedFile();
		File f = choose.getSelectedFile();
		Scanner scan = new Scanner(f);
		String str2 = "";
		//System.out.println("hey");
		System.out.println(scan.hasNextLine());
		while(scan.hasNextLine())
		{
			//System.out.println("made it ");
			String str = scan.nextLine();
			
			str2 = str2.concat(str + ";" + "\n");
			
		}
		//System.out.println(str2);
		
		commandWindow.clear();
		commandWindow.setText(str2);
	}
	
	//same thing as openScript but it runs the commands as well
	@FXML
	private void runScript(ActionEvent e) throws IOException
	{
JFileChooser choose = new JFileChooser();
		
		choose.showOpenDialog(null);
		//choose.getSelectedFile();
		File f = choose.getSelectedFile();
		Scanner scan = new Scanner(f);
		String str2 = "";
		//System.out.println("hey");
		System.out.println(scan.hasNextLine());
		while(scan.hasNextLine())
		{
			//System.out.println("made it ");
			String str = scan.nextLine();
			
			str2 = str2.concat(str  + "\n");
			
		}
		//System.out.println(str2);
		
		commandWindow.clear();
		commandWindow.setText(str2);
		
		Database dat = new Database();
		String str = commandWindow.getText();
		//System.out.println(str);
		String [] arr;
		arr = str.split("\\n");
		//System.out.println(arr[0]);
		//System.out.println(arr.length);
		for(int i = 0; i < arr.length; i++)
		{
			
			String s = arr[i];
			System.out.println(s);
			dat.function(s);
		}
		
	}
	
	//saves the contents of the editor into a file that is chosen
	@FXML
	private void saveScript(ActionEvent e ) throws IOException
	{
		String s = commandWindow.getText();
		System.out.println(s);
		JFileChooser choose = new JFileChooser();
		choose.showSaveDialog(null);
		
		File f  = choose.getSelectedFile();
		//System.out.println(test);
		FileWriter fw = new FileWriter(f,true);
		
		
		fw.write(s);
		fw.close();
	}
	
	
	@FXML
	private void initialize()
	{
		
	}

}
