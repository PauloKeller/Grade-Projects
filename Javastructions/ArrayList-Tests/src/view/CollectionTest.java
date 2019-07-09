package view;
import java.util.*;

public class CollectionTest 
{
	public static void main(String[] args)
	{
		String[] colors = {"MAGENTA", "VERMELHO", "AZUL", "ROXO", "PRETO"};
		List < String > list = new ArrayList< String >();
		
		for( String color : colors)
		{
			list.add(color);
		}
		
		String[] removeColors = {"VERMELHO", "AZUL", "ROXO"};
		List < String > removeList = new ArrayList< String >();
		
		for( String color : removeColors )
		{
			removeList.add(color);
		}
		
		System.out.println("ArrayList: ");
		
		for ( int count = 0; count < list.size(); count++)
		{
			System.out.printf("%s.", list.get(count));
		}
		
		removeColors( list, removeList);
		
		System.out.println("\n\nArrayList after calling removeColors: ");
		
		for ( String color: list)
			System.out.printf("%s.", color);
	}

	private static void removeColors(Collection< String > collection1, Collection< String > collection2) 
	{
		Iterator< String > iterator = collection1.iterator();
		
		while (iterator.hasNext())
		{
			if(collection2.contains(iterator.next()))
			{
				iterator.remove();
			}
		}
		
	} 

}
