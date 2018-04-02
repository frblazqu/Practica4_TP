package es.ucm.fdi.model.objects;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SimulatedObjectTest
{
	public void escribeInformeTest1() throws IOException
	{
		Vehicle car = new Vehicle();
		
		OutputStream out = new FileOutputStream(new File("src/main/resources/writeStr/out.ini"));
		
		car.escribeInforme(out, 15);
	}
}
