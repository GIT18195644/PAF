package resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
//	//View own account details
//	@GET
//	@Path("bio/{current_patient_id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Patient> getPatientDetails() {
//		System.out.println("get patients...");
//		Patient p = prepo.getPatient(current_patient_id);
//		
//		
//		return prepo.getPatients();
//	}
	
	//Search patient using patient id
	@GET
	@Path("search/{Patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("Patient_id") int Patient_id) {
		
		return prepo.getPatient(Patient_id);
		
	}
	
	//Create patient
	@POST
	@Path("create")
	public Patient createPatient(Patient p1) {
		System.out.println(p1);
		prepo.create(p1);
			
		return p1;
	}
	
		
	//Update Patient
	//@PUT
	//@Path("update")
	//public Patient updatePatient(Patient p1) {
		//System.out.println(p1);
			
	//if (prepo.getPatient(p1.getPatient_id()).getPatient_id()==0) {
	//System.out.println("DB have no details in this patient id");
	//}
	//else {
		//prepo.update(p1);
		//}
			
		//return p1;
	//}
	
	//Deactivate account
	//@DELETE
	//@Path("deactivate/{Patient_id}")
	//public Patient deactivateAccount(@PathParam("Patient_id") int Patient_id) {
		//Patient p = prepo.getPatient(Patient_id);
		
		//if (p.getPatient_id() !=0) {
			//prepo.delete(Patient_id);
		//}
		
		//return p;
		
	//}
	
}


















