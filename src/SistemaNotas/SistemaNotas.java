package SistemaNotas;
import java.util.*;

public class SistemaNotas {
	int libreta;
	String nombre;
	String apellido;
	
	int nota;
	String materia,notaS;
	//notas +=notas/materias.lenght;
	//cont += 1 => nota>7
	private static ArrayList<Tupla<String, String>> elementos;
	static HashMap<String, ArrayList<Tupla<String, String>>> SistemaNotas = new HashMap<>();
	
	//public SistemaNotas() {
		//Tupla<String,String> TuplaAlumno = new Tupla<String, String>(nombre, apellido);
		//Tupla<String,Integer> TuplaMaterias = new Tupla<String, Integer>(materia, nota);
		//HashMap<String,Tupla<K,V>> SistNotas = new HashMap<String, Tupla<K,V>>();
		//ArrayList<Tupla<String, String>> SistemaNotas = new ArrayList<Tupla<String, String>>();
		
		
	//}
	
	public static void main(String []args) {
		elementos = new ArrayList<>();
		System.out.println(SistemaNotas);
		agregarAlumno("42861287/2016","Frodo", "Baggins");
		System.out.println(SistemaNotas);
		agregarNota("42861287/2016", "prog1", 6);
		System.out.println(SistemaNotas);
	}

	public static void agregarAlumno(String libreta, String nombre, String apellido) {
		Tupla<String,String> TuplaAlumno = new Tupla<String, String>(nombre, apellido);
		//ArrayList<Tupla<String, String>> elementos=new ArrayList<>();
		//HashMap<String, ArrayList<Tupla<String, String>>> SistemaNotas = new HashMap<>();
		if(!SistemaNotas.containsKey(libreta)) {
			elementos.add(TuplaAlumno);
			SistemaNotas.put(libreta, elementos);
		}
	}

	public static int agregarNota(String libreta, String materia, int nota) {
		Tupla<String,String> TuplaAlumno = new Tupla<String, String>(materia, String.valueOf(nota));
		//ArrayList<Tupla<String, String>> elementos=new ArrayList<>();
		if(!(elementos.contains(new Tupla<String, String>(materia, String.valueOf(nota))))){
			elementos.add(TuplaAlumno);
			SistemaNotas.put(libreta, elementos);
			return 2;
		}
		//HashMap<String, ArrayList<Tupla<String, String>>> SistemaNotas = new HashMap<>();
	
			//elementos.add(TuplaAlumno);
			//SistemaNotas.put(libreta, elementos);
		
		return 0;
	}

	public Integer obtenerPromedio(String libreta) {
		int cantMaterias = 0, promedio=0;
		ArrayList<Tupla<String, String>> aux = new ArrayList<>();
		Tupla<String,String> TuplaAuxiliar = new Tupla<String, String>(materia, notaS);
		if(!SistemaNotas.containsKey(libreta)) {
			aux = SistemaNotas.get(libreta);
			for (int i=1;i<aux.size();i++) {
				cantMaterias +=1;
				TuplaAuxiliar = aux.get(i);
				promedio += Integer.parseInt(TuplaAuxiliar.getNota());
			}
		}
		return promedio/cantMaterias;
	}

	public Integer cantMateriasAprobadas(String libreta) {
		// ...
		return  0;
	}
	
	
}
//Metodos utiles de HashMap:
	// Insertar -> put
	// Pertenece -> containsKey
	// Obtener -> get
	// Borrar -> remove
	// Obtener todas las keys -> keySet
	// Obtener todos los values -> values
	// Recorrer por key
	// HashMap<String, Integer> dicc
	// for(String k: dicc.keySet())
	// 	hago algo con el k..
	// for(Tipo de dato de la key nombreVariable: diccionario.keySet())
	// Recorrer por value
	// for(Tipo de dato del value nombreVariable: diccionario.values())
class Alumno{
	String nombre; 
	String apellido;
	
	//Trupla<String, Integer>;
	public Alumno(String n, String a) {
		nombre=n;
		apellido=a;
		
		
		
		//Tupla tupla = new Tupla<String, Integer>();
	}
	
	public void materia (String materia, int nota) {
		
		
	}
}