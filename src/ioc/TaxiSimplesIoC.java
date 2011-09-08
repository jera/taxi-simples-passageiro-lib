package ioc;

import java.util.HashMap;
import java.util.Map;

public class TaxiSimplesIoC {

	@SuppressWarnings("rawtypes")
	private static Map<Class, Object> objects = new HashMap<Class, Object>();
	
	@SuppressWarnings("rawtypes")
	public static void register(Class clazz, Object object){
		objects.put(clazz, object);
	}
	
	public static Object lookup(Class clazz) {
		return objects.containsKey(clazz)?objects.get(clazz):null;
	}
}
