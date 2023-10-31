'use strict';

angular.module('myApp').factory('PlayerService', PlayerServiceFactory)

PlayerServiceFactory.$inject = ['$http']

function PlayerServiceFactory($http) {

    var REST_SERVICE_URI = '/players';

    var factory = {
        fetchAllPlayers: fetchAllPlayers,
        signNewPlayer: signNewPlayer,
        signExistingPlayer: signExistingPlayer,
        releasePlayer: releasePlayer,
        deletePlayer: deletePlayer
    };

    return factory;

    function fetchAllPlayers() {
        return $http.get(REST_SERVICE_URI).then((res) => res.data);
    }

    function signNewPlayer(player) {
        return $http.post(REST_SERVICE_URI, player);
    }
    
    function signExistingPlayer(player) {
        return $http.put(REST_SERVICE_URI, player);
    }

    function releasePlayer(id) {
        return $http.put(REST_SERVICE_URI + id);
    }

    function deletePlayer(id) {
        return $http.delete(REST_SERVICE_URI + id);
    }

}