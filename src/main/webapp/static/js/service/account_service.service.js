'use strict';

angular.module('myApp').factory('AccountService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = '/users';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser
    };

    return factory;

    function fetchAllUsers() {

        return $http.get(REST_SERVICE_URI).then(function (res){ return res.data});
    }

    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "/signup", user)
            .then(
            function (response) {
				console.log("Post: ", response);
                deferred.resolve(response.data);
                },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }




}]);