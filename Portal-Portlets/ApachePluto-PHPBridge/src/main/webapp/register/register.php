<?php 
$actionUrl = "?";
$renderUrl = "?";

foreach($_GET as $key=>$val){
	if($key == "actionUrl"){
		$actionUrl = $val;
	}
}
?>
<html>
	<body>
		<form action="<?php echo $actionUrl?>" method="POST">
			<table>
				<tr>
					<td>Enter ID:</td>
					<td><input name="employeeID"/></td>
				</tr>
				<tr>
					<td>Enter name:</td>
					<td><input name="employeeName"/></td>
				</tr>
				<tr>
					<td>Enter job:</td>
					<td><input name="employeeJob"/></td>
				</tr>
				<tr>
					<td>Enter salary:</td>
					<td><input name="employeeSalary"/></td>
				</tr>		
				<tr>
					<td colspan="2">
						<input type="submit" value="Register"/>
					</td>
				</tr>							
			</table>
		</form>
	</body>
</html>
