import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test2 
{
	public static void main(String[] args) 
	{
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> syncMap = Collections.synchronizedMap(map);
		MapHelper1 mapHelper1 = new MapHelper1(syncMap);
		MapHelper2 mapHelper2 = new MapHelper2(syncMap);
		MapHelper3 mapHelper3 = new MapHelper3(syncMap);
		
		for (Map.Entry<String, Integer> e : syncMap.entrySet()) 
		{
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}
}

class MapHelper1 implements Runnable
{
	Map<String, Integer> map;
	
	public MapHelper1(Map<String, Integer> map) 
	{
		this.map = map;
		new Thread(this, "MapHelper1").start();
	}
	
	@Override
	public void run() 
	{
		map.put("One", 1);
		
		try {
			System.out.println("MapHelper1 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class MapHelper2 implements Runnable
{
	Map<String, Integer> map;
	
	public MapHelper2(Map<String, Integer> map) 
	{
		this.map = map;
		new Thread(this, "MapHelper2").start();
	}
	
	@Override
	public void run() 
	{
		map.put("Two", 2);
		
		try {
			System.out.println("MapHelper2 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class MapHelper3 implements Runnable
{
	Map<String, Integer> map;
	
	public MapHelper3(Map<String, Integer> map) 
	{
		this.map = map;
		new Thread(this, "MapHelper3").start();
	}
	
	@Override
	public void run() 
	{
		map.put("Three", 3);
		
		try {
			System.out.println("MapHelper3 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}