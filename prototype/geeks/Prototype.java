// A Java program to demonstrate working of
// Prototype Design Pattern with example
// of a ColorStore class to store existing objects.

import java.util.HashMap;
import java.util.Map;


abstract class Color implements Cloneable
{
	
	protected String colorName;
	
	abstract void addColor();
	
	public Object clone()
	{
		Object clone = null;
		try
		{
			clone = super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return clone;
	}
}

class blueColor extends Color
{
	public blueColor()
	{
		this.colorName = "blue";
	}

	@Override
	void addColor()
	{
		System.out.println("Blue color added"+this);
	}
	
}

class blackColor extends Color{

	public blackColor()
	{
		this.colorName = "black";
	}

	@Override
	void addColor()
	{
		System.out.println("Black color added" + this);
	}
    String colorname(){
    	return this.colorName;
    }
}

class ColorStore {

	private static Map<String, Color> colorMap = new HashMap<String, Color>();
	
	static
	{
		colorMap.put("blue", new blueColor());
		colorMap.put("black", new blackColor());
	}
	
	public static Color getColorClone(String colorName)
	{
		return (Color) colorMap.get(colorName).clone();
	}
	public static Color getColor(String colorName){
		
		return (Color) colorMap.get(colorName);

	}
}


// Driver class
class Prototype
{
	public static void main (String[] args)
	{
		ColorStore.getColor("blue").addColor();
		ColorStore.getColor("black").addColor();
		ColorStore.getColor("black").addColor();
		ColorStore.getColor("blue").addColor();

      Color c1_clone = ColorStore.getColorClone("black");
	  Color c1_notClone = ColorStore.getColor("black");
      System.out.println("This is clone .. so the ref hash value will not match with any of the added color object in the map"+c1_clone); // succesfully cloned 
	  System.out.println("This is clone .. so the ref hash value will match with any one of the added color object in the map"+c1_notClone);
	  
	}
  
}
