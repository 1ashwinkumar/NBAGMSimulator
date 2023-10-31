'use strict';

angular.module('myApp').controller('PlayerController', ['$scope', '$log', 'PlayerService', function ($scope, $log, PlayerService) {
    var self = this;
    self.player = {};
    self.players = [];

    self.sign = sign; //submit
    self.release = release; //edit
    self.remove = remove;
    self.reset = reset;


    fetchAllPlayers();

    function fetchAllPlayers() {
        PlayerService.fetchAllPlayers()
            .then(
                function (d) {
                    self.players = d;
                    $log.log('fetchAllPlayers(): self.players ', self.players);
                },
                function (errResponse) {
                    $log.error('Error while fetching players');
                }
            );
    }

    function signNewPlayer(player) {
        PlayerService.signNewPlayer(player)
            .then(
                fetchAllPlayers,
                function (errResponse) {
                    $log.error('Error while signing new Player');
                }
            );
    }
    
    function signExistingPlayer(player) {
        PlayerService.signExistingPlayer(player)
            .then(
                fetchAllPlayers,
                function (errResponse) {
                    $log.error('Error while signing new Player');
                }
            );
    }

    function releasePlayer(id) {
        PlayerService.releasePlayer(id)
            .then(
                fetchAllPlayers,
                function (errResponse) {
                    $log.error('Error while releasing player.');
                }
            );
    }
    
    function deletePlayer(id) {
        PlayerService.deletePlayer(id)
            .then(
                fetchAllPlayers,
                function (errResponse) {
                    $log.error('Error while deleting Player');
                }
            );
    }

    function sign() {
        if (!self.player.id) {
            $log.log('Saving New Player', self.player);
            signNewPlayer(self.player);
        } else {
            signExistingPlayer(self.player);
            $log.log('Player updated with id ', self.player.id);
        }
        reset();
    }

    function release(id) {
        $log.log('player id to be released', id);
        for (var i = 0; i < self.players.length; i++) {
            if (self.players[i].id === id) {
                self.players[i].team=null;
                self.players[i].contractLength=null;
                self.players[i].salary=null;
                self.player=angular.copy(self.players[i]);
                releasePlayer(id);
            	$log.log('Player released with ID: ', id);
                break;
            }
        }
    }

    function remove(id) {
        $log.log('id to be deleted', id);
        if (self.player.id === id) {//clean form if the player to be deleted is shown there.
            reset();
        }
        deletePlayer(id);
    }


    function reset() {
        self.player = { id: null, name: '', position: '', team: '', age: '', contractLength: '',
        salary: '', stats: {} };
        $scope.myForm.$setPristine(); //reset Form
    }

}]);