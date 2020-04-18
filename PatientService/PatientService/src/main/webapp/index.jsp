<html>
<head>
<title>Patient Service | API</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	marging: 50px;
	padding: 50px;
}

input[type=text] {
  font-family: Arial, Helvetica, sans-serif;
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid red;
  border-radius: 4px;
}

button {
  background-color: red;
  border: none;
  color: white;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  border-radius: 4px;
}

.button3 {
  background-color: white; 
  color: black; 
  border: 2px solid red;
}

.button3:hover {
  background-color: #f44336;
  color: white;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}
</style>

</head>
<body>
		
	<table>
		<tr>
			<td>GET</td>
			<td>View all the patient list - (Administrator)</td>
			<td><input type="text" value="http://localhost:8080/PatientService/webapi/patients" id="myInput1"></td>
			<td><button class="button button3" onclick="myFunction1()">Get Link</button></td>
		</tr>
		<tr>
			<td>POST</td>
			<td>New patient creation - (Patient)</td>
			<td><input type="text" value="http://localhost:8080/PatientService/webapi/patients/create" id="myInput2"></td>
			<td><button class="button button3" onclick="myFunction2()">Get Link</button></td>
		</tr>
		<tr>
			<td>GET</td>
			<td>Search Patients by patient.id 1 - (Administrator)</td>
			<td><input type="text" value="http://localhost:8080/PatientService/webapi/patients/search/1" id="myInput3"></td>
			<td><button class="button button3" onclick="myFunction3()">Get Link</button></td>
		</tr>
		<tr>
			<td>DELETE</td>
			<td>Deactivate Patient account by patient.id 1 - (Administrator)</td>
			<td><input type="text" value="http://localhost:8080/PatientService/webapi/patients/deactivate/1" id="myInput4"></td>
			<td><button class="button button3" onclick="myFunction4()">Get Link</button></td>
		</tr>
		<tr>
			<td>PUT</td>
			<td>Update patient details - (Patient)</td>
			<td><input type="text" value="http://localhost:8080/PatientService/webapi/patients/update" id="myInput5"></td>
			<td><button class="button button3" onclick="myFunction5()">Get Link</button></td>
		</tr>
		<tr>
			<td>POST</td>
			<td>Create Appointment - (Patient)</td>
			<td><input type="text" value="http://localhost:8080/PatientService/webapi/patients/createappointment" id="myInput6"></td>
			<td><button class="button button3" onclick="myFunction6()">Get Link</button></td>
		</tr>
		<tr>
			<td>PUT</td>
			<td>Update appointment details - (Patient)</td>
			<td><input type="text" value="http://localhost:8080/AppointmentService/webapi/appointments/update" id="myInput7"></td>
			<td><button class="button button3" onclick="myFunction7()">Get Link</button></td>
		</tr>
		<tr>
			<td>GET</td>
			<td>Search Patients' appointments by appontment.id 1 - (Administrator)</td>
			<td><input type="text" value="http://localhost:8080/AppointmentService/webapi/appointments/search/1" id="myInput8"></td>
			<td><button class="button button3" onclick="myFunction8()">Get Link</button></td>
		</tr>
		<tr>
			<td>DELETE</td>
			<td>Delete Patient appointments by patient.id 1 appointment.id 1 - (patient)</td>
			<td><input type="text" value="http://localhost:8080/AppointmentService/webapi/appointments/delete/1/1" id="myInput9"></td>
			<td><button class="button button3" onclick="myFunction9()">Get Link</button></td>
		</tr>
	</table>

	<script>
		function myFunction1() {
			var copyText = document.getElementById("myInput1");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		
		function myFunction2() {
			var copyText = document.getElementById("myInput2");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		
		function myFunction3() {
			var copyText = document.getElementById("myInput3");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		
		function myFunction4() {
			var copyText = document.getElementById("myInput4");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		
		function myFunction5() {
			var copyText = document.getElementById("myInput5");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		
		function myFunction6() {
			var copyText = document.getElementById("myInput6");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		function myFunction7() {
			var copyText = document.getElementById("myInput7");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		function myFunction8() {
			var copyText = document.getElementById("myInput8");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
		function myFunction9() {
			var copyText = document.getElementById("myInput9");
			copyText.select();
			copyText.setSelectionRange(0, 99999)
			document.execCommand("copy");
			alert("Copied the Clipboard");
		}
	</script>

</body>
</html>