<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player Management Page</title>
</head>
<body ng-app="myApp">
	<nav>
		<a href="/">Home</a>
		<a href="/player">Player Management</a>
		<a href="/coach">Coach Management</a>
		<a href="/login">Login</a>
		<a href="/signup">Sign Up</a>
	</nav>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">Sign Player</h5>
	</div>
	<main>
		<div class="container"
			ng-controller="PlayerController as playerController">
			<div class="panel panel-default">
				<div class="formcontainer">
					<form ng-submit="playerController.sign()" name="playerForm"
						class="form-horizontal">
						<input type="hidden" ng-model="playerController.player.id" />
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Player
									Name</label>
								<div class="col-md-7">
									<input type="text" ng-model="playerController.player.name"
										name="name" class="name form-control input-sm"
										placeholder="Enter Player's Name" required ng-minlength="5"
										id="playerNameInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.name.$error.required">This is a
											required field</span> <span ng-show="playerForm.name.$error.minlength">Minimum
											length required is 5</span> <span ng-show="playerForm.name.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Position</label>
								<div class="col-md-7">
									<input type="text" ng-model="playerController.player.position"
										class="form-control input-sm"
										placeholder="Enter the Player's position.  This field is optional."
										id="playerPositionInput" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Team</label>
								<div class="col-md-7">
									<input type="text" ng-model="playerController.player.team"
										name="team" class="team form-control input-sm"
										placeholder="Enter Player's Team" required ng-minlength="5"
										id="playerTeamInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.team.$error.required">This is a
											required field</span> <span ng-show="playerForm.team.$error.minlength">Minimum
											length required is 2</span> <span ng-show="playerForm.team.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Age</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.age"
										name="age" class="age form-control input-sm"
										placeholder="Enter the Player's Age" required
										id="playerAgeInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.age.$error.required">This is
											a required field</span> <span ng-show="playerForm.age.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Contract Length</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.contractLength"
										name="age" class="age form-control input-sm"
										placeholder="Enter the Player's Contract Length" required
										id="playerContractLengthInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.contractLength.$error.required">This is
											a required field</span> <span ng-show="playerForm.contractLength.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Salary</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.salary"
										name="age" class="age form-control input-sm"
										placeholder="Enter the Player's Salary" required
										id="playerSalaryInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.salary.$error.required">This is
											a required field</span> <span ng-show="playerForm.salary.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Points</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.stats.points" step=".01"
										name="points" class="points form-control input-sm"
										placeholder="Enter the Player's Points Per Game" required
										id="playerPointsInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.points.$error.required">This is
											a required field</span> <span ng-show="playerForm.points.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Rebounds</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.stats.rebounds" step=".01"
										name="rebounds" class="rebounds form-control input-sm"
										placeholder="Enter the Player's Rebounds Per Game" required
										id="playerReboundsInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.rebounds.$error.required">This is
											a required field</span> <span ng-show="playerForm.rebounds.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Blocks</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.stats.blocks" step=".01"
										name="blocks" class="blocks form-control input-sm"
										placeholder="Enter the Player's Blocks Per Game" required
										id="playerBlocksInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.blocks.$error.required">This is
											a required field</span> <span ng-show="playerForm.blocks.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Steals</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.stats.steals" step=".01"
										name="steals" class="steals form-control input-sm"
										placeholder="Enter the Player's Steals Per Game" required
										id="playerStealsInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.steals.$error.required">This is
											a required field</span> <span ng-show="playerForm.steals.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Assists</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.stats.assists" step=".01"
										name="assists" class="assists form-control input-sm"
										placeholder="Enter the Player's Assists Per Game" required
										id="playerAssistsInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.assists.$error.required">This is
											a required field</span> <span ng-show="playerForm.assists.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Turnovers</label>
								<div class="col-md-7">
									<input type="number" ng-model="playerController.player.stats.turnovers" step=".01"
										name="turnovers" class="turnovers form-control input-sm"
										placeholder="Enter the Player's Turnovers Per Game" required
										id="playerTurnoversInput" />
									<div class="has-error" ng-show="playerForm.$dirty">
										<span ng-show="playerForm.turnovers.$error.required">This is
											a required field</span> <span ng-show="playerForm.turnovers.$invalid">This
											field is invalid </span>
									</div>
								</div>
							</div>
						</div>	

						<div class="row">
							<div class="form-group col-md-12">
								<div class="col-md-7">
									<input type="submit"
										value="{{!playerController.player.id ? 'Sign New Player' : 'Sign Existing Player'}}"
										class="btn btn-primary btn-sm" ng-disabled="playerForm.$invalid"
										id="addButton">
									<button type="button" ng-click="playerController.reset()"
										class="btn btn-warning btn-sm" ng-disabled="playerForm.$pristine"
										id="resetButton">Reset Form</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="lead">Player Table</span>
				</div>
				<div class="tablecontainer">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Position</th>
								<th>Team</th>
								<th>Age</th>
								<th>Contract Length</th>
								<th>Salary</th>
								<th>Points</th>
								<th>Rebounds</th>
								<th>Blocks</th>
								<th>Steals</th>
								<th>Assists</th>
								<th>Turnovers</th>
								<th width="30%"></th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="u in playerController.players">
								<td><span ng-bind="u.id"></span></td>
								<td><span ng-bind="u.name"></span></td>
								<td><span ng-bind="position"></span></td>
								<td><span ng-bind="u.team"></span></td>
								<td><span ng-bind="u.age"></span></td>
								<td><span ng-bind="u.contractLength"></span></td>
								<td><span ng-bind="u.salary"></span></td>
								<td><span ng-bind="u.stats.points"></span></td>
								<td><span ng-bind="u.stats.rebounds"></span></td>
								<td><span ng-bind="u.stats.blocks"></span></td>
								<td><span ng-bind="u.stats.steals"></span></td>
								<td><span ng-bind="u.stats.assists"></span></td>
								<td><span ng-bind="u.stats.turnovers"></span></td>
								
								<td>
									<button type="button" ng-click="playerController.release(u)"
										class="btn btn-success custom-width" id="releaseButton{{u.id}}">Release Player</button>
									<button type="button" ng-click="playerController.remove(u.id)"
										class="btn btn-danger custom-width" id="removeButton{{u.id}}">Delete Player</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"></script>
	<script src="/static/js/app.js"></script>
	<script src="/static/js/service/player_service.js"></script>
	<script src="/static/js/controller/player_controller.js"></script>


</body>
</html>