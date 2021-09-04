package SistemaNotas;
import java.util.*;

public class SistemaNotas {
	int libreta;
	String nombre;
	String apellido;
	
	int nota;
	String materia,notaS;
	private static ArrayList<Tupla<String, String>> elementos;
	static HashMap<String, ArrayList<Tupla<String, String>>> SistemaNotas = new HashMap<>();
	
	//public SistemaNotas() {
		
		
	//}
	
	public static void main(String []args) {
		elementos = new ArrayList<>();
		System.out.println(SistemaNotas);
		agregarAlumno("42861287/2016","Frodo", "Baggins");
		System.out.println(SistemaNotas);
		agregarNota("42861287/2016", "prog1", 6);
		System.out.println(SistemaNotas);
		agregarNota("42861287/2016", "prog2", 10);
		System.out.println(SistemaNotas);
		System.out.println(obtenerPromedio("42861287/2016") + " pomedio");
		System.out.println(cantMateriasAprobadas("42861287/2016"));
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

	public static Integer obtenerPromedio(String libreta) {
		int cantMaterias = 0, promedio=0;
		ArrayList<Tupla<String, String>> aux = new ArrayList<>();
		//Tupla<String,String> TuplaAuxiliar = new Tupla<String, String>(materia, notaS);
		if(SistemaNotas.containsKey(libreta)) {
			aux = SistemaNotas.get(libreta);
			for (int i=1;i<aux.size();i++) {
				cantMaterias +=1;
				//TuplaAuxiliar = aux.get(i);
				promedio += Integer.parseInt(aux.get(i).getNota());
			}
		}
		return promedio/cantMaterias;
	}

	public static Integer cantMateriasAprobadas(String libreta) {
		int cantMateriasAprobadas = 0;
		ArrayList<Tupla<String, String>> aux = new ArrayList<>();
		if(SistemaNotas.containsKey(libreta)) {
			aux = SistemaNotas.get(libreta);
			for (int i=1;i<aux.size();i++) {
				if(Integer.parseInt(aux.get(i).getNota())>=4) {
					cantMateriasAprobadas +=1;
				}
			}
		}
		return cantMateriasAprobadas;
	}
	
	
}

