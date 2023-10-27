'use strict';

angular.module('myApp').controller('SignupController', ['$scope', 'AccountService', function($scope, AccountService) {

    $scope.user={id:null,username:'',address:'',email:''};
    $scope.users=[];

    $scope.submit = submit;

    fetchAllUsers();

    function fetchAllUsers(){
        AccountService.fetchAllUsers()
            .then(
            function(d) {
                $scope.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createUser(user){
        AccountService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function submit() {
		if ($scope.user.id === null) {
			createUser($scope.user);

		} else {

			console.log('User updated with id ', $scope.user.id);
		}
	}


}]);