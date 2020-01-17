var rentAcarApp = angular.module("rentAcarApp");
rentAcarApp.controller("editCtrl", function($scope,$routeParams, $http, $location){
	
	var baseUrl = "/api/automobili/" + $routeParams.id;
	var kompanijaUrl = "/api/kompanije";
	
	
	$scope.kompanije = [];
	$scope.automobil = {};
	$scope.automobil.model = "";
	$scope.automobil.registracija = "";
	$scope.automobil.godiste = "";
	$scope.automobil.potrosnja = "";
	$scope.automobil.kompanijaId = "";
	
var getKompanije = function(){
		
		var promise = $http.get(kompanijaUrl);
		
		promise.then(
			function success(res){
				$scope.kompanije = res.data;
				
			},
			function error(){
				alert("Unsuccessful fetch!")
			}
		);

	}

getKompanije();

var getAuto = function(){
	
	var promise = $http.get(baseUrl);
	promise.then(
		function uspeh(odg){
			$scope.automobil = odg.data;
		},
		function neuspeh(){
			console.log("Something went wrong!");
		}
	);
	
}

getAuto();


$scope.doEdit = function() {
	$http.put(baseUrl, $scope.automobil).then(function success() {
		$location.path("/automobili");
	}, function error() {
		alert("Something went wrong.");
	});
}

	

	
});