import java.util.ArrayList;

public class Print 
{
	public int optionCount = 4;// this must be changed if extra options are added in printOptions method
	
	public static void PrintOptions() 
	{
		System.out.println("1) Add New Student\n2) Add student Grade(s)\n3) Get student\n4) Exit");
	}

	public void AvailableSubjects() 
	{
		Subject newSubject = new Subject();
		
		String[] subjects = newSubject.availSubjects;
		
		System.out.printf("Choose from available subjects:\n");
		
		int count = 1;
		
		for(String subject: subjects)
		{
			if(count == 1)
				System.out.printf("{%s,", subject);
			else if(count == subjects.length)
				System.out.printf(" %s}\n", subject);
			else
				System.out.printf(" %s,", subject);
			count++;
		}
	}

	public void StudentPreview(String studentFName, String studentLName, ArrayList<String> mySubjects) 
	{
		String name = studentFName + " " + studentLName;
		System.out.printf("Name: %s\n", name);
		System.out.println("SUBJECTS:");
		for(String subject : mySubjects)
			System.out.printf("%s\n", subject);		
	}

	public void GetAllStudents(ArrayList<String> arrayList) 
	{
		int idx = 0;
		for(String name : arrayList)
		{
			idx++;
			System.out.printf("%d) %s\n",idx, name);
		}
	}

/*	public static void AddNewStudent() 
	{
		
		System.out.println("Enter student's Last name: ");
		
	}*/
	

}