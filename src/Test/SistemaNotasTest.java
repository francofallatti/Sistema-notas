package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import SistemaNotas.SistemaNotas;
/*   Enunciado Tarea Entregable TAD  2021C2
	Subir al campus hasta el 7 de septiembre de 2021

Se desea implementar el problema de mantener las materias aprobadas
por alumno. TAD Sistema Notas.

En el sistema se deben poder ingresar nuevos alumnos, los datos que se registran son
numero de libreta, nombre, apellido.

Ademas, se ingresan las notas de cada materia aprobada por un alumno, se conoce el
nombre de la materia y la nota.

El sistema debe permitir obtener el promedio de un alumno, asi como tambien la
cantidad de materias aprobadas.

La universidad tenia un sistema anterior, el viejo sistema permit�a el ingreso del mismo alumno
dos o mas veces, lo que luego generaba registros de alumnos con distintas materias
Por ejemplo:

Se agregan los alumnos Martin dos veces (es el mismo alumno)
Martin: {prog1:5; prog2: 9} 
Martin: {ip:7; prog2: 10}

promedio("Martin") -> (5 + 9 + 7 + 10) / 4 -> 8 //No
promedio("Martin") -> (5 + 10 + 7) / 3 -> 7     //Ok

Luego cuando se solicitaba el promedio, este era incorrecto.
El promedio del primer Martin es 7 y el del segundo Martin es 8
Es necesario garantizar que en el nuevo sistema no sucedera esto.

1) Implementar los TAD necesarios, pensar el IREP y compararlo con el propuesto
en el codigo.
Luego de finalizada esta etapa, la universidad detecta que necesita generar el promedio de cada
alumno de forma lo mas eficiente posible, dado que es una consulta recurrente 

2) Modificar la parte 1) para que obtener el promedio quede en O(1) y explicar que cambio del IREP con esta modificacion

Entregar un zip con los archivos java solamente, explicando el punto 2 debajo de este enunciado

Respueta:

*/

class SistemaNotasTest {


	SistemaNotas SistNotas = new SistemaNotas();
	
	@Before
	public void setUp() {
	
	    
	    
	    
		
	}

	@Test
	public void happyPathTest() {	
		SistNotas.agregarAlumno("42861287/2016","Frodo", "Baggins");
		//SistNotas.agregarAlumno(libreta, nombre, apellido);
	
	    SistNotas.agregarNota("42861287/2016", "prog1", 6);
	    SistNotas.agregarNota("42861287/2016", "prog2", 10);
		assertEquals(Integer.valueOf(8), SistNotas.obtenerPromedio("42861287/2016"));
		assertEquals(Integer.valueOf(2), SistNotas.cantMateriasAprobadas("42861287/2016"));
	}
	
	@Test
	public void alumnoRepetidoTest() {		
		SistNotas.agregarAlumno("42861287/2016","Frodo", "Baggins");
		SistNotas.agregarNota("42861287/2016", "ip", 7);
		SistNotas.agregarNota("42861287/2016", "prog2", 8);
		// ip:7, p1:6, p2:8;  21/3
		
		System.out.println(SistNotas.cantMateriasAprobadas("42861287/2016"));
		System.out.println(SistNotas.obtenerPromedio("42861287/2016"));
		
		//Decision de diseno: queda la ultima nota
	
		assertEquals(Integer.valueOf(7), SistNotas.obtenerPromedio("42861287/2016"));
	}

}
