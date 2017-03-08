var app = angular.module('application', ['ngResource']);

app.controller('ApplicationController', ['$scope', '$resource',function($scope,$resource) {
    
    function fetchAllApplications(){
        $scope.applications = $resource('http://localhost:8080/applications'
        ).query(function(data){return data;});
    };
    fetchAllApplications();
    
    $scope.refresh = function(){
    	fetchAllApplications();
    };
    
    $scope.createapplication = function(){
    	Application = $resource(
    		    "http://localhost:8080/applications/",
    		    {},
    		    {save: {method:'POST',isArray:false}}
    	);
    	
    	var application = {};
		
		application.id = $scope.applicationForm.id;
		application.name = $scope.applicationForm.name;
		application.description = $scope.applicationForm.description;
		application.languagesKnown = $scope.applicationForm.languagesknown;
		application.phoneNumber = $scope.applicationForm.phonenumber;
		
		$scope.Message = Application.save(application);
				
		$scope.applicationForm.id = "";
		$scope.applicationForm.name="";
		$scope.applicationForm.description="";
		$scope.applicationForm.languagesknown="";
		$scope.applicationForm.phonenumber="";
    };
    
    $scope.deleteapplication = function(){
    	Application = $resource(
    		    "http://localhost:8080/applications/:id",
    		    {},
    		    {save: {method:'DELETE', params: {id: '@id'}}}
    	);
    	
			
		Application.delete({id: $scope.applicationForm.id}).then(function successCallback(response) {
			$scope.Message = response;
		}, function errorCallback(response) {
		    
		});
				
		$scope.applicationForm.id = "";
		$scope.applicationForm.name="";
		$scope.applicationForm.description="";
		$scope.applicationForm.languagesknown="";
		$scope.applicationForm.phonenumber="";
    };
    
    
    $scope.updateapplication = function(){
    		
    	Application = $resource(
    		    "http://localhost:8080/applications/:id",
    		    {},
    		    {save: {method:'PUT', params: {id: '@id'}}}
    	);
    	
    	var application = {};
		
		application.id = $scope.applicationForm.id;
		application.name = $scope.applicationForm.name;
		application.description = $scope.applicationForm.description;
		application.languagesKnown = $scope.applicationForm.languagesknown;
		application.phoneNumber = $scope.applicationForm.phonenumber;
		
		$scope.Message = Application.save({id: $scope.applicationForm.id}, application);
				
		$scope.applicationForm.id = "";
		$scope.applicationForm.name="";
		$scope.applicationForm.description="";
		$scope.applicationForm.languagesknown="";
		$scope.applicationForm.phonenumber="";
    };
    
}]);

app.controller('PanelController',function(){
    this.tab = 1;
    this.selectTab = function(setTab){
      this.tab = setTab;
    };
    this.isSelected = function(checkTab){
      return this.tab === checkTab;
    };
  });