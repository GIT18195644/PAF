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
import model.Hospital;
import model.Payment;
import repository.HospitalRepository;

@Path("hospitals")
public class HospitalResource {

	HospitalRepository hrepo = new HospitalRepository();

	// For Administrator
	// View all the hospital list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getHospitals() {
		System.out.println("View all the hospital list....");

		return hrepo.getHospitals();
	}

	// For Administrator
	// Search hospital using hospital id
	@GET
	@Path("search/{Hospital_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getHospital(@PathParam("Hospital_id") int Hospital_id) {
		System.out.println("Search hospital using hospital id....");

		return hrepo.getHospital(Hospital_id);
	}

	// For Administrator
	// Create Hospital Record
	@POST
	@Path("create")
	public Hospital createHospital(Hospital h1) {
		System.out.println("Create Hospital Record....");

		System.out.println(h1);
		hrepo.create(h1);

		return h1;
	}

	// For Administrator
	// Update Hospital Details
	@PUT
	@Path("update")
	public Hospital updateHospital(Hospital h1) {
		System.out.println("Update Hospital Details....");

		System.out.println(h1);

		if (hrepo.getHospital(h1.getHospital_id()).getHospital_id() == 0) {
			System.out.println("DB have no details in this id");
		} else {
			hrepo.update(h1);
		}

		return h1;
	}

	// For Administrator
	// Delete Hospital Record
	@DELETE
	@Path("delete/{Hospital_id}")
	public Hospital deleteHospital(@PathParam("Hospital_id") int Hospital_id) {
		System.out.println("Delete Hospital Record....");

		Hospital h = hrepo.getHospital(Hospital_id);

		if (h.getHospital_id() != 0) {
			hrepo.delete(Hospital_id);
		}

		return h;
	}

	// For Administrator
	// View all the Appointments list in Hospital
	@GET
	@Path("viewappointments/{Hospital_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAppointments(@PathParam("Hospital_id") int Hospital_id) {
		System.out.println("View all the hospital list....");

		return hrepo.getAppointments(Hospital_id);
	}

	// For Hospital Manager
	// View all the Payments list in Hospital
	@GET
	@Path("viewpayments/{Hospital_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPayments(@PathParam("Hospital_id") int Hospital_id) {
		System.out.println("View all the hospital payment list....");

		return hrepo.getPayments(Hospital_id);
	}

	// For Administrator
	// View all the Payments list on our service
	@GET
	@Path("viewsystempayments/{Hospital_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPaymentsSystem(@PathParam("Hospital_id") int Hospital_id) {
		System.out.println("View all the Our service payment list in hospital appointments....");

		return hrepo.getPaymentsSystem(Hospital_id);
	}
}
