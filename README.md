# OrdersManagementSystem
# To run application please download .zip file and run compile.bat followed by run.bat
To build you need to have Maven

Example of correct .csv order file:
Client_Id,Request_id,Name,Quantity,Price
1,1,Gulasz,1,10.00
1,1,Ser,2,15.00
1,2,Kotlet, 5,15.00
2,1,Pieczarki,1,10.00

Example of correct .xml order file:
<requests>
	<request>
		<clientId>1</clientId>
		<requestId>1</requestId>
		<name>Gulasz</name>
		<quantity>1</quantity>
		<price>10.00</price>
	</request>
	<request>
		<clientId>1</clientId>
		<requestId>2</requestId>
		<name>Chleb</name>
		<quantity>2</quantity>
		<price>15.00</price>
	</request>
	<request>
		<clientId>1</clientId>
		<requestId>2</requestId>
		<name>Chleb</name>
		<quantity>5</quantity>
		<price>15.00</price>
	</request>
	<request>
		<clientId>2</clientId>
		<requestId>1</requestId>
		<name>Chleb</name>
		<quantity>1</quantity>
		<price>10.00</price>
	</request>
	<request>
		<clientId>20</clientId>
		<requestId>10</requestId>
		<name>Pieczywo</name>
		<price>10.00</price>
	</request>
</requests>
