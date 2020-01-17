var rentAcarApp = angular.module("rentAcarApp");
rentAcarApp.controller("autoCtrl", function($scope,$routeParams, $http, $location){
	
	$scope.automobili = [];
	$scope.kompanije = [];
	
	$scope.automobil = {};
	$scope.automobil.model = "";
	$scope.automobil.registracija = "";
	$scope.automobil.godiste = "";
	$scope.automobil.potrosnja = "";
	$scope.automobil.kompanijaId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.model = $location.search().model != undefined ? $location.search().model  : "";
	$scope.searchParams.godiste = $location.search().godiste != undefined ? $location.search().godiste : "";
	$scope.searchParams.potrosnja = $location.search().potrosnja != undefined ? $location.search().potrosnja : "";

	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	
	var baseUrl = "/api/automobili";
	var kompanijaUrl = "/api/kompanije";
	
var getKompanije = function(){
		
		var promise = $http.get(kompanijaUrl);
		
		promise.then(
			function success(res){
				$scope.kompanije = res.data;
				getAutomobili();
				
			},
			function error(){
				alert("Unsuccessful fetch!")
			}
		);

	}


var getAutomobili = function(){
	
var config = { params: {} };
	
	//Dakle, polja config.params objekta moraju da se zovu kako back-end ocekuje
	if($scope.searchParams.model != ""){
		$location.search("model", $scope.searchParams.model);
		config.params.model = $scope.searchParams.model;
	}
	
	if($scope.searchParams.godiste != ""){
		config.params.godiste = $scope.searchParams.godiste;
	}
	
	if($scope.searchParams.potrosnja != ""){
		config.params.potrosnja = $scope.searchParams.potrosnja;
	}

	config.params.pageNum = $scope.pageNum;
	
	$http.get(baseUrl, config).then(
		function success(res){
			$scope.automobili = res.data;
			$scope.totalPages = res.headers("totalPages");
		},
		function error(){
			alert("Something went wrong.");
		}
	);
}
getKompanije();

	
	$scope.doAdd = function(){
		$http.post(baseUrl, $scope.automobil).then(
			function success(){
				getAutomobili();
				$scope.automobil = {};
				
			},
			function error(){
				alert("Couldn't add activity!");
			}
		);
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getAutomobili();
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/automobili/edit/" + id);
	}
	
	$scope.doSearch = function(){

		var params =  {};
		
		if($scope.searchParams.model != ""){
			params.model = $scope.searchParams.model;
		}
		
		if($scope.searchParams.godiste != ""){
			params.godiste = $scope.searchParams.godiste;
		}
		
		if($scope.searchParams.potrosnja != ""){
			params.potrosnja = $scope.searchParams.potrosnja;
		}
		
		$location.search(params);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getAutomobili();
	}
	
	$scope.doIznajmi = function(id){
		var promise = $http.post(baseUrl + "/" + id);
		promise.then(
			function success(){
				alert("Uspešno iznajmljen automobil.")
				getAutomobili();
			},
			function error(){
				alert("Neuspešno iznajmljivanje.");
				getAutomobili();
			}
		);
			
	}
	
});