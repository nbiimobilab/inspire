<?php

	// $con=mysqli_connect("localhost","nbii_app","j%8V#9RXDZAHUVm%w^","nbii_app");

	// include db connect class
	require_once __DIR__ . '/db_connect.php';
 
	// connecting to db
	$db = new DB_CONNECT();

	// GEt all news records from the database.
	// $sql = "SELECT * FROM `news`";
	$sql = mysql_query("SELECT * FROM `news`") or die(mysql_error());

	// $result = mysql_query($con,$sql);

	if(mysql_num_rows($sql) > 0){

		//$news_array=mysqli_fetch_assoc($result);
		$rows = array();
		while($r = mysql_fetch_assoc($sql)){			

				$rows[] = array_map('utf8_encode', $r);

				// foreach($r as $key => $value) {
			 //    	$r[$key] = htmlentities($value, ENT_QUOTES);
			 //    	$r[$key] = htmlentities($value, ENT_QUOTES);
				// }
		}

		//print_r($rows);
		//exit();

		/* SEND AS JSON */
		header("Content-Type: application/json", true);
		echo json_encode($rows);
	}
	else {
	    // no news found
	    $response["success"] = 0;
	    $response["message"] = "No news found"; 
	    // echo no news JSON
	    echo json_encode($rows);
	}
?>