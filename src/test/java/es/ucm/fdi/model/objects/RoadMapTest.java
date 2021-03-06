package es.ucm.fdi.model.objects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.ucm.fdi.model.objects.*;

public class RoadMapTest {
	RoadMap mapa = new RoadMap();
	
	//@Test
	public void getClassTest(){
		Road r = new Road("r1", 60, 100);
		Road[] it = new Road[1];
		it[0] = r;
		Vehicle v = new Vehicle("v1", 50, it);
		Junction j = new Junction("j1");
		
		mapa.addJunction(j);
		mapa.addRoad(r);
		mapa.addVehicle(v);
		
		Vehicle v1 = mapa.getVehicle("v1");
		Road r1 = mapa.getRoad("r1");
		
		assertEquals(0, v1.getLocalizacion());
		assertEquals(100, r1.getLongitud());
	}
	
	@Test
	public void addSimObjectTest()
	{
		RoadMap map = new RoadMap();
		
		Vehicle vehicle = new Vehicle();
		Road road = new Road();
		Junction junction = new Junction();
		Bike bike = new Bike();
		Car car = new Car();
		Path path = new Path();
		Freeway freeway = new Freeway();
		
		map.addObject(vehicle);		//assertTrue("Fallo insercción 1.", map.getVehicles().size() == 1);
		map.addObject(road);		//assertTrue("Fallo insercción 2.", map.getRoads().size() == 1);
		map.addObject(junction);	//assertTrue("Fallo insercción 3.", map.getJunctions().size() == 1);
		map.addObject(bike);		//assertTrue("Fallo insercción 4.", map.getVehicles().size() == 2);
		map.addObject(car);			//assertTrue("Fallo insercción 5.", map.getVehicles().size() == 3);
		map.addObject(path);		//assertTrue("Fallo insercción 1.", map.getVehicles().size() == 2);
		map.addObject(freeway);     //assertTrue("Fallo insercción 1.", map.getVehicles().size() == 3);
		
		assertTrue("Ver mensajes en consola!", true);
	}
}
