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

import model.Appointment;
import model.Patient;
import repository.PatientRepository;

@Path("patients")
public class PatientResource {

	PatientRepository prepo = new PatientRepository();

	// View Patient details
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getPatients() {
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

	// Search patient using patient id
	@GET
	@Path("search/{Patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("Patient_id") int Patient_id) {

		return prepo.getPatient(Patient_id);

	}

	// Create patient
	@POST
	@Path("create")
	public Patient createPatient(Patient p1) {
		System.out.println(p1);
		prepo.create(p1);

		return p1;
	}

	
	// Update Patient
	@PUT
	@Path("update")
	public Patient updatePatient(Patient p1) {
		System.out.println(p1);

		if (prepo.getPatient(p1.getPatient_id()).getPatient_id() == 0) {
			System.out.println("DB have no details in this patient id");
		} else {
			prepo.update(p1);
		}

		return p1;
	}

	

	// Deactivate account
	@DELETE
	@Path("deactivate/{Patient_id}")
	public Patient deactivateAccount(@PathParam("Patient_id") int Patient_id) {
		Patient p = prepo.getPatient(Patient_id);

		if (p.getPatient_id() != 0) {
			prepo.delete(Patient_id);
		}

		return p;

	}
	
	// create Appointment
		@POST
		@Path("createappointment")
		public Appointment createAppointment(Appointment a1) {
			System.out.println(a1);
			prepo.createAppointment(a1);

			return a1;
		}

		// create payment for appointment
		@POST
		@Path("createpayment")
		public Appointment createPaymentAppointment(Appointment a1) {
			System.out.println(a1);
			prepo.createPaymentAppointment(a1);

			return a1;
		}

	
	
	// Update Appointment
		@PUT
		@Path("updateAppointment")
		public Appointment updateAppointment(Appointment a1) {
			System.out.println(a1);

			if (prepo.getAppointmentAdmin(a1.getAppointment_id()).getAppointment_id() == 0) {
				System.out.println("DB have no details in this id");
			} else {
				prepo.updateAppointment(a1);
			}

			return a1;
		}
		

	// Search appointments using appointment id
	@GET
	@Path("searchappointment/{appointment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointmentAdmin(@PathParam("appointment_id") int appointment_id) {

		return prepo.getAppointmentAdmin(appointment_id);

	}

	 //Delete Appointment
	@DELETE
	@Path("deleteappointment/{Patient_id}/{appointment_id}")
	public Appointment deleteAppointmentPatient(@PathParam("Patient_id") int Patient_id,
			@PathParam("appointment_id") int appointment_id) {

		Appointment a = prepo.getAppointmentAdmin(appointment_id);

		if (a.getPatient_id() != 0 && a.getAppointment_id() != 0) {
			prepo.deleteAppointment(Patient_id, appointment_id);
		}

		return a;
	}

}
