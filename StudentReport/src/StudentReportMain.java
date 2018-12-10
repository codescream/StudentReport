import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentReportMain 
{

	private static Student student;
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> mySubjects = new ArrayList<String>();
	private static int studentCount = 0;
	private static boolean exit = false;
	private static Print print = new Print();
	private static int choice = 0;
	private static int highGrade = 100;//highest grade percentage
	public static void main(String[] args) 
	{
		while(!exit) 
		{		
			while(choice == 0)
				Options();
			
			switch(choice)
			{
				case 1:
				{
					String studentFName = "";
					String studentLName = "";
					
					while(studentFName == "")
					{
						System.out.println("Enter student's First name: ");
						studentFName = StringInput();// input validation method
					}
					
					while(studentLName == "")
					{
						System.out.println("Enter student's Last name: ");
						studentLName = StringInput();
					}

					boolean moreSubject = true;
					
					student = new Student();
					System.out.println("Enter student's Subjects: ");
					while(moreSubject)
					{
						student.printer.AvailableSubjects();
						
						//Print.AvailableSubjects();
						String subject = StringInput();
						
						String[] availSubjects = student.subject.availSubjects;
						
						while(!InSubjectList(subject, availSubjects))
						{
							System.out.println("Please pick subject from list!\n");
							
							subject = StringInput();
							
							availSubjects = student.subject.availSubjects;
						}
						
						if(mySubjects.contains(subject))
						{
							System.out.println("You have already entered that subject for student\n");
						}
						else
							mySubjects.add(subject);
						
						System.out.println("Add another subject? Y/N ");
							String addSubj = input.next();
						if(addSubj.equals("Y") || addSubj.equals("y"))
						{
							moreSubject = true;
							System.out.println("Enter Subject ");
						}
						else
							moreSubject = false;
					}
					
					System.out.println("Create new Student?");
					student.printer.StudentPreview(studentFName, studentLName, mySubjects);
					String createStudent = input.next();
					if(createStudent.equals("Y") || createStudent.equals("y"))
					{
						student.subject.AddSubject(mySubjects);
						student.AddNewStudent(studentFName, studentLName);
						studentCount = student.GetStudentCount();
						mySubjects.clear();
						
						Options();
						input.nextLine();
					}
					else
					{
						mySubjects.clear();
						Options();
					}	
					break;
				}
				
				case 2:
				{
					if(studentCount != 0)
					{
						ArrayList<Integer> grades = new ArrayList<Integer>();
						//input.nextLine();
						System.out.println("Please choose student to add grade for;");
						student.printer.GetAllStudents(student.GetAllStudents());
						
						choice = 0;
						
						while(choice == 0)
						{
							 choice = IntInput(studentCount);
						}
						
						int studentID = 1;
						for(String name : student.GetAllStudents())
						{
							if(studentID == choice)
							{
								System.out.println("Enter Grade(1-100) per subject:");

								System.out.printf("%s\n", name);
								
								ArrayList<String> studentSubjects = student.GetAllSubjects().get(studentID-1);
								
								for(String subjectName : studentSubjects)
								{
									//System.out.printf("%s: \n", subjectName);
									int grade = 0;
									
									while(grade == 0)
									{
										//System.out.println("Enter Grade(1-100) per subject:");
										System.out.printf("%s: \n", subjectName);
										grade = IntInput(highGrade);//input validation for numbers and option selection
									}
									
									grades.add(grade);
								}
								student.grade.AddGrade(grades);
								student.AddGrade(studentID);
								System.out.println("Grade(s) Added!");
								
								grades.clear();
								input.nextLine();
							}// end if(studentID == choice)
								studentID++;
						}//end for
						Options();
					}
					else
					{
						input.nextLine();
						System.out.println("no student to add grade for, please add a student\n");
						
						Options();
					}
					
					break;
				}
				
				case 3:
				{
					if(studentCount != 0)
					{
						//input.nextLine();
						System.out.println("Select student to display record for:\n");
						student.printer.GetAllStudents(student.GetAllStudents());
						
						int studentID = 0;
						
						while(studentID == 0)
						{
							studentID = IntInput(studentCount);
						}
						student.GetRecord(studentID);
						
						Options();
					}
					else
					{
						input.nextLine();
						System.out.println("no student to display record for, please add a student\n");
						
						Options();
					}
					break;
				}
				
				case 4:
				{
					input.nextLine();
					exit = true;
				}
			}
		}	
	}
	
	private static void Options() 
	{
		System.out.println("What do you want to do?");
		Print.PrintOptions();
		
		choice = 0;
		
		while(choice == 0)
		{
			 choice = IntInput(print.optionCount);
		}
	}

	private static boolean InSubjectList(String entry, String[] availSubjects) 
	{
		int count = 0;
		for(String subject : availSubjects)
		{
			if((subject.toLowerCase()).equals(entry.toLowerCase()))
				count++;
		}
		if(count > 0)
			return true;
		else
			return false;
	}

	private static int IntInput(int delimiter) 
	{
				try 
				{
					int choice = input.nextInt();
					if(choice < 1 || choice > delimiter)
					{
						throw new InputMismatchException();
					}
					return choice;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter an approriate option");
					input.nextLine();
					return 0;
				}
	}
	
	private static String StringInput() 
	{	
				try 
				{
					String[] illegalChars = 
						{
							"1", "2", "3", "4", "5", "6", "7", "8","9", "!", "\"",
							">", "<", "?", ";", "'", ":", ",", ".", "[", "]", "/",
							"\\", "{", "}", "+", "=", "-", "_", "*", "&", "^", "%",
							"$", "#", "@", "~", "`", ")", "("
						};
					
					String string = input.next();
					
					for(String num : illegalChars)
					{
						if(string.contains(num) || string.length() <= 1)
							throw new InputMismatchException();
					}
					
					return string.toUpperCase();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter an approriate option");
					input.nextLine();
					return "";
				}
	}
}