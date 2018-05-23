package src.code;

import java.util.Scanner;
import java.util.ArrayList;


public class main{

	public static void printList(ArrayList<Class> list){

	int i = 0;

	for(Class theClass : list){

		System.out.println(i + ". " + theClass.getName());

		i++;

		}

	}

	public static void main(String[] main){
		
		Scanner sc = new Scanner(System.in);

		int option = 0;

		ArrayList<Class> classes = new ArrayList<Class>();

		while(option != 3){

			System.out.println("Please choose an option!\n");

			System.out.println("0: Add a class");

			System.out.println("1: Modify Classes");

			System.out.println("2: Print Classes");

			System.out.println("3: Quit");

			option = sc.nextInt();

			switch(option){

				case 0:

					System.out.print("\n");

					System.out.println("Please enter the class name: ");

					String className = new String();

					className = sc.next();

					classes.add(new Class(className));

					break;

				case 1:

					if(!classes.isEmpty()){

						System.out.println("\nSelect a class you want to modify!");

						printList(classes);

						int classToModify = sc.nextInt();

						if(Math.abs(classToModify) < classes.size()){

							Class theClass = classes.get(classToModify);

							System.out.println(theClass.getName());

							System.out.println("\nWould you like to... ");

							System.out.println("0. Delete this class");
							System.out.println("1. Add a category to this class");
							System.out.println("2. Print the current categorys");

							int modification = sc.nextInt();

							switch(modification){

								case 0:

									classes.remove(classToModify);

									break;

                                case 1:

                                    System.out.println("\nPlease enter the name of the category. (i.e. \"Homework\")");
                                    String temp = sc.nextLine();
                                    System.out.println("Please enter the weight this category holds on your grade. (i.e. 20.00)");
                                    double wtemp = sc.nextDouble();
                                    classes.get(classToModify).addCategory(temp, wtemp);

                                case 2:

                                    for(String categories: classes.get(classToModify).getCategories()){
                                        System.out.println(categories);
                                    }

								default:

									System.out.println("Feature not available");

									break;
							}

						}

						else{

							System.out.println("\nThats not a valid index dummy!");

						}

					}

					else{

						System.out.println("\nYou have no classes to modify!");

					}

					break;

				case 2:

					System.out.print("\n");

					if(!classes.isEmpty()){

						printList(classes);
					}

					else{

						System.out.println("You have no classes to print!");

					}
				
					break;

				case 3:

					System.out.print("\n");


					System.out.println("Thanks for using!");

					break;

				default:

					System.out.print("\n");

					System.out.println("Please choose a valid option!");

					break;
			}

			System.out.print("\n");

		}

	}
}