<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player Management Page</title>
<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"></script>
	<script src="static/js/app.module.js"></script>
	<script src="/static/js/service/player_service.service.js"></script>
	<script src="/static/js/controller/player_controller.controller.js"></script>
</head>
<body>
	<nav>
		<a href="/">Home</a>
		<a href="/player">Player Management</a>
		<a href="/login">Login</a>
		<a href="/signup">Sign Up</a>
	</nav>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">Sign Player</h5>
	</div>
	<main>
		<section class="container">
			<div class="panel panel-default">
				<div class="formcontainer">
					<spring:form action="/playerDetail" name="playerForm" class="form-horizontal" method="post" model="player">
						<input type="text" name="name" placeholder="Enter Player's Name" minlength="5" required="required"/>
						<input type="text" name="position" placeholder="Enter Player's Position (optional)"/>
						<input type="text" name="team" placeholder="Enter Player's Team" minlength="2" required="required"/>
						<input type="number" name="age" placeholder="Enter Player's Age" minlength="2" required="required"/>
						<input type="text" name="contractLength" placeholder="Enter Player's Contract Length" minlength="2" required="required"/>
						<input type="number" name="salary" placeholder="Enter Player's Annual Salary" minlength="2" required="required"/>
						<input type="number" name="Points" placeholder="Enter Player's Points Per Game" minlength="1" required="required" step=".1"/>
						<input type="number" name="Rebounds" placeholder="Enter Player's Rebounds Per Game" minlength="1" required="required" step=".1"/>
						<input type="number" name="Blocks" placeholder="Enter Player's Blocks Per Game" minlength="1" required="required" step=".1"/>
						<input type="number" name="Steals" placeholder="Enter Player's Steals Per Game" minlength="1" required="required" step=".1"/>
						<input type="number" name="Assists" placeholder="Enter Player's Assists Per Game" minlength="1" required="required" step=".1"/>
						<input type="number" name="Turnovers" placeholder="Enter Player's Turnovers Per Game" minlength="1" required="required" step=".1"/>
						<button type="submit">Sign Player</button>
						
						<div class="row">
							<div class="form-group col-md-12">
								<div class="col-md-7">
									
									<button type="button" ng-click="playerController.reset()"
										class="btn btn-warning btn-sm" ng-disabled="playerForm.$pristine"
										id="resetButton">Reset Form</button>
								</div>
							</div>
						</div>
					</spring:form>
				</div>
			</section>
		  <section ng-app="myApp">
		  <div class="panel panel-default" ng-controller="PlayerController as playerController">
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
								<tr ng-repeat="u in playerController.players track by u.id">
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
	      </section>
	</main>


</body>
</html>