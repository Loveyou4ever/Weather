<?php
$array=array("tem"=>30,"lig"=>100,"wet"=>30);
header('content-type:application:json;charset=utf8');  
header('Access-Control-Allow-Origin:*');  
header('Access-Control-Allow-Methods:POST');  
header('Access-Control-Allow-Headers:x-requested-with,content-type'); 
echo json_encode($array);
?>