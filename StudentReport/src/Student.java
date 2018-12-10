import java.util.ArrayList;

public class Student 
{
	private static ArrayList<String> students = new ArrayList<String>();
	private static ArrayList<ArrayList<String>>subjects = new ArrayList<ArrayList<String>>();
	private static ArrayList<ArrayList<Integer>> grades = new ArrayList<ArrayList<Integer>>();
	static int enrolNum = 0;
	public Print printer;
	public Grade grade;
	public Subject subject;
	
	public Student()
	{
		printer = new Print();
		subject = new Subject();
		grade = new Grade();
	}
	public void AddNewStudent(String fName, String lName) 
	{
		//ArrayList<String> studentInfo = new ArrayList<String>();
		students.add(fName + " " + lName);
		
		subjects.add(subject.GetSubjects());
		
		enrolNum++;
		
		System.out.printf("Student Number %d created!\n\n", enrolNum);
		//studentInfo.clear();
	}
	
	public int GetStudentCount()
	{
		return enrolNum;
	}
	public ArrayList<String> GetAllStudents() 
	{
		return students;
	}
	
	public ArrayList<ArrayList<String>> GetAllSubjects() 
	{
		return subjects;
	}
	
	public ArrayList<ArrayList<Integer>> GetAllGrades() //not used but put in for future use
	{
		return grades;
	}
	public void AddGrade(int studentID) 
	{
		if(grades.size() == 0)
		{
			for(int i = 0; i < students.size(); i++)
			{
					if(i == (studentID - 1))
					{
						@SuppressWarnings("unchecked")
						ArrayList<Integer> myGrade = (ArrayList<Integer>)grade.GetGrade().clone();
						grades.add(i, myGrade);
					}
					else
					{
						grades.add(i, null);
					}
			}
			grade.ClearGrade();
		}
		else
		{
			if(grades.size() < subjects.size())
			{
				int count = 0;
				for(int i = 0; i < students.size(); i++)
				{
					count++;
					if(i == (studentID - 1))
					{
						@SuppressWarnings("unchecked")
						ArrayList<Integer> myGrade = (ArrayList<Integer>)grade.GetGrade().clone();
						grades.add(i, myGrade);
					}
					else if(count > grades.size())
					{
						grades.add(i, null);
					}
				}
				grade.ClearGrade();
			}
			else
			{
				for(int i = 0; i < students.size(); i++)
				{
					if(i == (studentID - 1))
					{
						@SuppressWarnings("unchecked")
						ArrayList<Integer> myGrade = (ArrayList<Integer>)grade.GetGrade().clone();
						grades.set(i, myGrade);
					}
				}
				grade.ClearGrade();
			}
		}
	}

	public int GetRecord(int studentID) 
	{
		for(int i = 0; i < students.size(); i++)
		{
			if(i == (studentID - 1))
			{
				System.out.printf("Student Name: %s\n", students.get(i));
			}
		}
		
		for(int j = 0; j < subjects.size(); j++)
		{		
			if(grades.size() == 0 || grades.size() < subjects.size())
			{
				NoGradeDisplay(j, studentID);
			}
			else if(grades.get(j) == null)
			{
				NoGradeDisplay(j, studentID);
			}
			else
			{
				if(j == (studentID - 1))
				{
					int subjectCount = 0;
					int totalGrade = 0;
					ArrayList<String> mySubjects = subjects.get(j);
					for(int k = 0; k < mySubjects.size(); k++)
					{
						System.out.printf("%s%20d", mySubjects.get(k), grades.get(j).get(k));
						totalGrade += grades.get(j).get(k);
						System.out.println();
						subjectCount++;
					}
					System.out.printf("-----------------\n");
					System.out.printf("Average: %20d\n\n", totalGrade/subjectCount);
				}
			}
		}
		return 1;
	}
	
	public void NoGradeDisplay(int index, int studentID)
	{
		if(index == (studentID - 1))
		{
			ArrayList<String> mySubjects = subjects.get(index);
			for(int k = 0; k < mySubjects.size(); k++)
			{
				System.out.printf("%s%20s", mySubjects.get(k), "N/A");
				System.out.println();
			}
			System.out.printf("-----------------\n");
			System.out.printf("Average: %20s\n", "N/A");
		}
	}
}