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
import repository.AppointmentRepository;

@Path("appointments")
public class AppointmentResource {

	AppointmentRepository arepo = new AppointmentRepository();

	// ----- 01
	// For Administrator
	// View all the appointment list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAppointmentsAdmin() {
		System.out.println("View all the appointment List....");

		return arepo.getAppointmentsAdmin();
	}

	// ----- 03
	// For Administrator
	// Search appointments using appointment id
	@GET
	@Path("search/{appointment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointmentAdmin(@PathParam("appointment_id") int appointment_id) {

		return arepo.getAppointmentAdmin(appointment_id);

	}

	// ----- 04
	// For Patient
	// Search appointments using appointment id
	@GET
	@Path("search/{Patient_id}/{appointment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointmentPatient(@PathParam("Patient_id") int Patient_id,
			@PathParam("appointment_id") int appointment_id) {
		System.out.println(Patient_id);
		System.out.println(appointment_id);
		return arepo.getAppointmentPatient(Patient_id, appointment_id);

	}

	// ----- 02
	// For Patient
	// View all the appointment list
	@GET
	@Path("appointments/{Patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAppointmentsPatient(@PathParam("Patient_id") int Patient_id) {
		System.out.println("View own patient appointment List....");

		return arepo.getAppointmentsPatient(Patient_id);
	}

	// ----- 05
	// For Patient
	// Create Appointment
	@POST
	@Path("create")
	public Appointment createAppointment(Appointment a1) {
		System.out.println(a1);
		arepo.create1(a1);

		return a1;
	}

	// ----- 06
	// For Patient
	// Update Appointment
	@PUT
	@Path("update")
	public Appointment updateAppointment(Appointment a1) {
		System.out.println(a1);

		if (arepo.getAppointmentAdmin(a1.getAppointment_id()).getAppointment_id() == 0) {
			System.out.println("DB have no details in this id");
		} else {
			arepo.update(a1);
		}

		return a1;
	}

	// ----- 07
	// For Administrator
	// Delete Appointment
	@DELETE
	@Path("delete/{appointment_id}")
	public Appointment deleteAppointmentAdministrator(@PathParam("appointment_id") int appointment_id) {
		Appointment h = arepo.getAppointmentAdmin(appointment_id);

		if (h.getHospital_id() != 0) {
			arepo.deleteAdministrator(appointment_id);
		}

		return h;
	}

	// ----- 08
	// For Patient
	// Delete Appointment
	@DELETE
	@Path("delete/{Patient_id}/{appointment_id}")
	public Appointment deleteAppointmentPatient(@PathParam("Patient_id") int Patient_id, @PathParam("appointment_id") int appointment_id) {
		
		
		Appointment a = arepo.getAppointmentAdmin(appointment_id);
		
		if (a.getPatient_id() != 0 && a.getAppointment_id() != 0) {
			arepo.delete(Patient_id, appointment_id);
		}
		
		return a;
	}
}
