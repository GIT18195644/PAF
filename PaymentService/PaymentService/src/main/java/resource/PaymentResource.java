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
import model.CardDetails;
import model.Payment;
import repository.PaymentRepository;

@Path("payments")
public class PaymentResource {

	PaymentRepository prepo = new PaymentRepository();

	//--01
	// For Administrator
	// View all the payments list
	@GET
	@Path("paymentlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPaymentsAdmin() {
		System.out.println("View all the payment List....");

		return prepo.getPaymentsAdmin();
	}

	//--02
	// For Administrator
	// Search payments using payments id
	@GET
	@Path("paymentsearch/{payment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPaymentAdmin(@PathParam("payment_id") int payment_id) {

		return prepo.getPaymentAdmin(payment_id);

	}

	//--03
	// For Administrator
	// Delete payment record
	@DELETE
	@Path("paymentdelete/{payment_id}")
	public Payment deletePaymentAdministrator(@PathParam("payment_id") int payment_id) {
		Payment h = prepo.getPaymentAdmin(payment_id);

		if (h.getPatient_id() != 0) {
			prepo.deletePaymentAdministrator(payment_id);
		}

		return h;
	}

	//--04
	// For Patient
	// Create payment
	@POST
	@Path("paymentcreate")
	public Payment createPayment(Payment a1) {
		System.out.println(a1);
		prepo.createPayment(a1);

		return a1;
	}

	//--05
	// For Patient
	// Create Card
	@POST
	@Path("creditcardcreate")
	public CardDetails createCard(CardDetails card_id) {
		System.out.println(card_id);
		prepo.createCard(card_id);

		return card_id;
	}

	//--06
	// For Patient
	// Update Card details
	@PUT
	@Path("creditcardupdate")
	public CardDetails updateCardDetails(CardDetails card_id) {
		System.out.println(card_id);

		prepo.updateCardDetails(card_id);

		return card_id;
	}

	//--07
	// For Administrator
	// Search card details using Card_id
	@GET
	@Path("creditcardsearch/{Card_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CardDetails getCardDetailsAdmin(@PathParam("Card_id") int Card_id) {

		return prepo.getCardDetailsAdmin(Card_id);

	}

	//--08
	// For Patient
	// Delete Card Details
	@DELETE
	@Path("creditcarddelete/{Patient_id}/{card_id}")
	public CardDetails deleteAppointmentPatient(@PathParam("Patient_id") int Patient_id,
			@PathParam("card_id") int card_id) {

		CardDetails a = prepo.getCardDetailsAdmin(card_id);

		if (a.getPatient_id() != 0 && a.getCard_id() != 0) {
			prepo.deleteCard(Patient_id, card_id);
		}

		return a;
	}
}
