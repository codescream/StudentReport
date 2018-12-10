import java.util.ArrayList;

public class Grade 
{
	private static ArrayList<Integer> myGrades;
	
	public Grade()
	{
		myGrades = new ArrayList<Integer>();
	}

	public void AddGrade(ArrayList<Integer> grade) 
	{
		for(int myGrade : grade)
			myGrades.add(myGrade);
	}
	
	public ArrayList<Integer> GetGrade()
	{
		return myGrades;
	}

	public void ClearGrade() 
	{
		myGrades.clear();
	}
}