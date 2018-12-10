import java.util.ArrayList;

public class Subject 
{
	private static ArrayList<String> subjects;
	String[] availSubjects = 
		{
			"Mathematics", "Biology", "Geography", "Science", "History", "French"
		};
	
	public Subject()
	{
		subjects = new ArrayList<String>();
	}
	
	public void AddSubject(ArrayList<String> mySubjects)
	{
		for(String subject : mySubjects)
			subjects.add(subject);
	}

	public ArrayList<String> GetSubjects() 
	{
		return subjects;
	}
}