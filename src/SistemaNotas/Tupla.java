package SistemaNotas;

public class Tupla<K, V> {
	private K materia;
	private V nota;
	
	public Tupla(K m, V n) {
		// TODO Auto-generated constructor stub
		materia = m;
		nota=n;
	}
	
	public void setMateria(K m) {
		this.materia= m;
	}
	
	public void setNota(V n) {
		this.nota= n;
	}
	
	public K getMateria() {
		return materia;
	}
	
	public V getNota() {
		return nota;
	}

}
