<?php 

$renderUrl = "?";
$exception = "?";

foreach($_GET as $key=>$val){
	if($key == "renderUrl"){
		$renderUrl = $val;
	}
	else if($key == "exception"){
		$exception = $val;
	}
}
?>
<html>
	<body>
		<table>
			<tr>
				<td>
					<span style="color: red;">
						Unfortunately, employee registration operation hasn't been finished successfully !
					</span>
				</td>
			</tr>	
			<tr>
				<td>For cause:<?php echo $exception?></td>
			</tr>					
		</table>
		<a href="<?php echo $renderUrl?>">Try Again</a>
	</body>
</html>
