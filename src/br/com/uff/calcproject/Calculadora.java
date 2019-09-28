package br.com.uff.calcproject;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/operacao")
public class Calculadora {
	
	@Path("{o}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response operacao(@PathParam("o") String o, @QueryParam("n1") float n1, @QueryParam("n2") float n2) {
		
		float calc;
		String op;
		if (o.equals("sub")) {
			calc = n1 - n2;
			op = "-";
		}
		else if (o.equals("soma")) {
			calc = n1 + n2;
			op = "+";
		}
		else if (o.equals("mult")) {
			calc = n1 * n2;
			op = "*";
		}
		else if (o.equals("div")) {
			calc = n1 / n2;
			op = "/";
		}
		else {
			calc = 0;
			op = " ";
		}
		
		String r = "A operacao de " + Float.toString(n1) + " " + op + " " + Float.toString(n2) + " tera " + Float.toString(calc);
		return Response.status(200).entity(r).build();
	}
}
