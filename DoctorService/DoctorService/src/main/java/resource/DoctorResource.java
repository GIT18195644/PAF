package resource;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Doctor;
import repository.DoctorRepository;

public class DoctorResource {
	
	DoctorRepository dr = new DoctorRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Doctor> viewDoctor(){
		return dr.viewDoctor();
	}
	public Doctor updateDoctor(Doctor d) {
		
		return d;
	}
	
}
