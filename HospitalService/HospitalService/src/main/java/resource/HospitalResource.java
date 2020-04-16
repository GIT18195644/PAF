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
import model.Hospital;
import repository.HospitalRepository;

@Path("hospitals")
public class HospitalResource {

	HospitalRepository hrepo = new HospitalRepository();

	// View all the hospital list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getHospitals() {
		System.out.println("View Hospital List....");

		return hrepo.getHospitals();
	}

	// Search hospital using hospital
	@GET
	@Path("search/{Hospital_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getHospital(@PathParam("Hospital_id") int Hospital_id) {

		return hrepo.getHospital(Hospital_id);

	}

	// Create Hospital
	@POST
	@Path("create")
	public Hospital createHospital(Hospital h1) {
		System.out.println(h1);
		hrepo.create(h1);

		return h1;
	}

	// Update Hospital
	@PUT
	@Path("update")
	public Hospital updateHospital(Hospital h1) {
		System.out.println(h1);

		if (hrepo.getHospital(h1.getHospital_id()).getHospital_id() == 0) {
			System.out.println("DB have no details in this id");
		} else {
			hrepo.update(h1);
		}

		return h1;
	}

	// Delete Hospital
	@DELETE
	@Path("delete/{Hospital_id}")
	public Hospital deleteHospital(@PathParam("Hospital_id") int Hospital_id) {
		Hospital h = hrepo.getHospital(Hospital_id);

		if (h.getHospital_id() != 0) {
			hrepo.delete(Hospital_id);
		}

		return h;
	}
}
