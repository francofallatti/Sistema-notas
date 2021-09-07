package SistemaNotas;
import java.util.*;

public class SistemaNotas {
	
	private ArrayList<Tupla<String, String>> elementos;
	private HashMap<String, ArrayList<Tupla<String, String>>> SistNotas;
	
	private int promedio, cantMaterias;
	
	public SistemaNotas() {
		
		elementos = new ArrayList<>();
		SistNotas = new HashMap<>();
	}

	public void agregarAlumno(String libreta, String nombre, String apellido) {
		Tupla<String,String> TuplaAlumno = new Tupla<String, String>(nombre, apellido);
		if(!SistNotas.containsKey(libreta)) {
			elementos.add(TuplaAlumno);
			SistNotas.put(libreta, elementos);
		}else {
			System.out.print("Alumno ya ingresado");
		}
	}

	public void agregarNota(String libreta, String materia, int nota) {
		Tupla<String,String> TuplaAlumno = new Tupla<String, String>(materia, String.valueOf(nota));
		if(!(elementos.contains(new Tupla<String, String>(materia, String.valueOf(nota))))){
			elementos.add(TuplaAlumno);
			SistNotas.put(libreta, elementos);
			promedio = promedio + nota;
			cantMaterias = cantMaterias + 1;
		}		
	}
	/**
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
	}*/
	
	
	 //O(1)
	public Integer obtenerPromedio(String libreta) {
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

