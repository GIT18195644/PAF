package resource;
import java.util.List;

import javax.annotation.Generated;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Appointment;
import model.Doctor;
import repository.DoctorRepository;


@Path("doctor")
public class DoctorResource {
	
	DoctorRepository dr = new DoctorRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Doctor> viewDoctor(){
		return dr.viewDoctor();
	}
	
	@GET
	@Path("search/{doctorID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor searchDoctor(@PathParam("doctorID")int doctorID) {
		System.out.println("View....");
		return dr.searchDoctor(doctorID);
	}
	
	@POST
	@Path("create")
	public Doctor addDoctor(Doctor d) {
		dr.create(d);
		return d;
	}
	
	@PUT
	@Path("update")
	public Doctor updateDoctor(Doctor d) {
		System.out.println(d);
		if(dr.searchDoctor(d.getDoctor_id()).getDoctor_id() == 0) {
			System.out.println("DB have no details in this id");
		}
		else {
			dr.update(d);
		}
		return d;
	}
	
	@DELETE
	@Path("delete/{doctorID}")
	public Doctor deleteDoctor(@PathParam("doctorID") int doctorID) {
		Doctor d = dr.searchDoctor(doctorID);
		
		if(d.getDoctor_id() != 0) {
			dr.delete(doctorID);
		}
		return d;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("appointment/{doctorID}")
	public List<Appointment> viewAppointment(@PathParam("doctorID")int doctorID) {
		
		return dr.viewAppointment(doctorID);
	}
	
}
