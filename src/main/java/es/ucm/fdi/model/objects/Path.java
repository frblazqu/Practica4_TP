package es.ucm.fdi.model.objects;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.util.MultiTreeMap;

public class Path extends Road
{
	
	
	
	
	public Path()
	{
		
	}
	public Path(String id, int maxSpeed, int size, RoadMap map)
	{
		super(id, maxSpeed, size, map);				
	}
	public void fillSectionDetails(IniSection s)
	{
		super.fillSectionDetails(s);
		s.setValue("type", "dirt");
	}
	public void avanza(RoadMap mapa)
	{
		if(vehiculos.sizeOfValues() > 0)
		{
			MultiTreeMap<Integer,Vehicle> aux = new MultiTreeMap<>((a, b) -> (b-a)); 
			int velocidadBase = maxVelocidad;
			int numAveriados = 0;
			
			
			for(Vehicle v: vehiculos.innerValues())
			{
				if(v.averiado())	numAveriados++;
				else
					v.setVelocidadActual(velocidadBase/(1 + numAveriados));
				
				v.avanza(mapa);
				
				if(v.getLocalizacion() != this.longitud)
				{
					aux.putValue(v.getLocalizacion(), v);
				}
			}
			vehiculos = aux;
		}
	}
}
