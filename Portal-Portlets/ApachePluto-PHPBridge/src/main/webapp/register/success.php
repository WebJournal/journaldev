<?php 

$renderUrl = "?";

foreach($_GET as $key=>$val){
	if($key == "renderUrl"){
		$renderUrl = $val;
	}
}
?>
<html>
	<body>
		<table>
			<tr>
				<td>
					Congratulations, employee registration operation has been finished successfully !
				</td>
			</tr>						
		</table>
		<a href="<?php echo $renderUrl?>">Register Another</a>
	</body>
</html>
