package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import modelo.entidades.Interes;
import modelo.entidades.Sexo;
import modelo.entidades.Usuario;
import modelo.negocio.GestorUsuarios;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet -> Entrando");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String[] intereses = request.getParameterValues("intereses");
		String sSexo = request.getParameter("sexo");
		
		System.out.println(email+" , "+password+" , "+Arrays.toString(intereses)+" , "+sSexo);
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		
		List<Interes> listaIntereses = new ArrayList<>();
		for(String s : intereses){
			int indice = Integer.parseInt(s);
			Interes interes = Interes.values()[indice];
			listaIntereses.add(interes);
		}
		
		int indice = Integer.parseInt(sSexo);
		Sexo sexo = Sexo.values()[indice];
		
		usuario.setListaInteres(listaIntereses);
		usuario.setSexo(sexo);
		
		GestorUsuarios gu = new GestorUsuarios();
		boolean registrado = gu.registrar(usuario);
		
		PrintWriter pw = response.getWriter();
		if(registrado){
			pw.println("Usuario dado de alta");
		}else{
			pw.println("Usuario NO se ha dado de alta");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
