package SistemaNotas;
import java.util.*;

public class SistemaNotas {
	int libreta;
	String nombre;
	String apellido;
	
	int nota;
	String materia,notaS;
	private static  ArrayList<Tupla<String, String>> elementos;
	 static HashMap<String, ArrayList<Tupla<String, String>>> SistNotas;
	
	public SistemaNotas() {
		
		elementos = new ArrayList<>();
		SistNotas = new HashMap<>();
	}
	
	/**
	public static void main(String []args) {
		elementos = new ArrayList<>();
		System.out.println(SistNotas);
		agregarAlumno("42861287/2016","Frodo", "Baggins");
		System.out.println(SistNotas);
		agregarNota("42861287/2016", "prog1", 6);
		System.out.println(SistNotas);
		agregarNota("42861287/2016", "prog2", 10);
		System.out.println(SistNotas);
		System.out.println(obtenerPromedio("42861287/2016") + " pomedio");
		System.out.println(cantMateriasAprobadas("42861287/2016"));
	}**/

	public void agregarAlumno(String libreta, String nombre, String apellido) {
		Tupla<String,String> TuplaAlumno = new Tupla<String, String>(nombre, apellido);
		if(!SistNotas.containsKey(libreta)) {
			elementos.add(TuplaAlumno);
			SistNotas.put(libreta, elementos);
		}else {
			System.out.print("so boludo? ya agregaste es alumno");
		}
	}

	public void agregarNota(String libreta, String materia, int nota) {
		Tupla<String,String> TuplaAlumno = new Tupla<String, String>(materia, String.valueOf(nota));
		if(!(elementos.contains(new Tupla<String, String>(materia, String.valueOf(nota))))){
			elementos.add(TuplaAlumno);
			SistNotas.put(libreta, elementos);
		}		
	}

	public Integer obtenerPromedio(String libreta) {
		int cantMaterias = 0, promedio=0;
		ArrayList<Tupla<String, String>> aux = new ArrayList<>();
		if(SistNotas.containsKey(libreta)) {
			aux = SistNotas.get(libreta);
			for (int i=1;i<aux.size();i++) {
				cantMaterias +=1;
				//TuplaAuxiliar = aux.get(i);
				promedio += Integer.parseInt(aux.get(i).getNota());
			}
		}
		return promedio/cantMaterias;
	}

	public Integer cantMateriasAprobadas(String libreta) {
		int cantMateriasAprobadas = 0;
		ArrayList<Tupla<String, String>> aux = new ArrayList<>();
		if(SistNotas.containsKey(libreta)) {
			aux = SistNotas.get(libreta);
			for (int i=1;i<aux.size();i++) {
				if(Integer.parseInt(aux.get(i).getNota())>=4) {
					cantMateriasAprobadas +=1;
				}
			}
		}
		return cantMateriasAprobadas;
	}
	
	
}

