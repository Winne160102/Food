package Food;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Food {
	private String id;
	private String quantity;
	private String price;
	private String name;

	public Food() {
	}
	
	public Food(String id, String quantity,String name ,String price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setall(String id, String quantity,String name ,String price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public void inputFoodID_Name() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		id = sc.nextLine();
		
		System.out.println("Enter Name: ");
		name = sc.nextLine();
			
	}
	
	public void inputFoodID_Quantity() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		id = sc.nextLine();
		
		System.out.println("Enter Quantity: ");
		quantity = sc.nextLine();
			
	}

	public void inputFoodID_Price() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		id = sc.nextLine();
		
		System.out.println("Enter Price: ");
		price = sc.nextLine();
			
	}
	
	public static boolean Check(String id, ArrayList<Food> list){
		boolean x = true;
		for(Food temp : list) {
			if(temp.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Food> inputCheckID_Name() {
		ArrayList<Food> list = new ArrayList<Food>();
		try {
			 Scanner sc = new Scanner(System.in);
			    boolean exit = false; 
			    while (!exit) {
			        Food food = new Food();
			        food.inputFoodID_Name();
			        
			        while(true) {
			        	if(Check(food.getId(), list) == false) {
			        		System.out.println("ID has been existed");
					        food.inputFoodID_Name();
			        	}
			        	else {		
			        		list.add(food);
			        		break;
			        	}
			        }
			        System.out.println("Do you want to enter more ID and Quantity? (Y/N)");
			        String choice = sc.nextLine();  
			        if (choice.equalsIgnoreCase("N")) {
			            exit = true;
			        }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
}
	    
	public void outputFileID_Name(){
		 ArrayList<Food> list = new ArrayList<Food>();
		 list = inputCheckID_Name();
		try {
			FileWriter fWriter = new FileWriter("D:\\QA\\ID_Name.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Food data : list) {
				bWriter.write(data.getId() + "-" + data.getName());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void outputFileID_Quantity(){
		 ArrayList<Food> list = new ArrayList<Food>();
		    Scanner sc = new Scanner(System.in);
		    boolean exit = false;
		    while (!exit) {
		        Food food = new Food();
		        food.inputFoodID_Quantity();
		        list.add(food); 
		        System.out.println("Do you want to enter more ID and Quantity? (Y/N)");
		        String choice = sc.nextLine();  
		        if (choice.equalsIgnoreCase("N")) {
		            exit = true;
		        }
		    }
		try {
			FileWriter fWriter = new FileWriter("D:\\QA\\ID_Quantity.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Food data : list) {
				bWriter.write(data.getId() + "-" + data.getQuantity());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void outputFileID_Price(){
		ArrayList<Food> list = new ArrayList<Food>();
		    Scanner sc = new Scanner(System.in);
		    boolean exit = false;
		    while (!exit) {
		        Food food = new Food();
		        food.inputFoodID_Quantity();
		        list.add(food); 
		        System.out.println("Do you want to enter more ID and Price? (Y/N)");
		        String choice = sc.nextLine();  
		        if (choice.equalsIgnoreCase("N")) {
		            exit = true;
		        }
		    }
		try {
			FileWriter fWriter = new FileWriter("D:\\QA\\ID_Price.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Food data : list) {
				bWriter.write(data.getId() + "-" + data.getPrice());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void outputMonitor() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Food> list = new ArrayList<Food>();
		boolean exit = false;
		System.out.println("Enter Your Choice: 1 - Out File ID - Name, 2 - Output File ID - Quantity, 3 - Output File ID - Price , 4 - Exit.");
		while (!exit) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				outputFileID_Name();
				System.out.println("Output File ID - Name Created. ");
				break;
			
			case 2:
				outputFileID_Quantity();
				System.out.println("Output File ID - Quantity Created. ");
				break;
				
			case 3:
				outputFileID_Price();
				System.out.println("Output File ID - Price Created. ");
				break;
				
			case 4:
				exit = true;
				System.out.println("Program has been closed.");
				break;
				
			default:
				System.out.println("Invalid Choice!");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Food food = new Food();
		food.outputMonitor();
	}
}
