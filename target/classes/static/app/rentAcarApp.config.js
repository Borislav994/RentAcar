var rentAcarApp = angular.module("rentAcarApp");
rentAcarApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/automobili', {
			templateUrl : '/app/components/automobili/automobili.html'
		})
		.when('/automobili/edit/:id', {
			templateUrl : '/app/components/edit-automobili/edit-automobili.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);