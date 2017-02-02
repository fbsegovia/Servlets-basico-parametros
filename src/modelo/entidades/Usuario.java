package modelo.entidades;

import java.util.List;

public class Usuario {
	private String email;
	private String password;
	private List<Interes> listaInteres;/*Es una lista por poder ser varios valores*/
	private Sexo sexo;/*al solo poder ser un valor se llama desde su clase*/
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Interes> getListaInteres() {
		return listaInteres;
	}
	public void setListaInteres(List<Interes> listaInteres) {
		this.listaInteres = listaInteres;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", password=" + password + ", listaInteres=" + listaInteres + ", sexo="
				+ sexo + "]";
	}
	
	
	
}
