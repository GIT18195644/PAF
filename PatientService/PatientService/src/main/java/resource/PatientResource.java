package resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Patient;
import repository.PatientRepository;

@Path("patients")
public class PatientResource {
	
	PatientRepository prepo = new PatientRepository();
	
	//View Patient details
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getPatients(){
		System.out.println("get patients...");
		
		return prepo.getPatients();
	}
	
}
