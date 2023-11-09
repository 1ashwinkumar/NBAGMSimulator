<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"></script>
  <script type="text/javascript" src="/static/js/app.module.js"></script>
  <script type="text/javascript" src="/static/js/controller/signup_controller.controller.js" defer></script>
  <script type="text/javascript" src="/static/js/service/account_service.service.js" defer></script>


    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
 
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="/static/css/styles.css" rel="stylesheet" type="text/css" />
  </head>

  <body ng-app="myApp" class="ng-cloak">
  <header>
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="/">Home</a>
        </div>
        <ul class="nav navbar-nav">
          <li><a href="/player">Player Management</a></li>
          <li><a href="/login">Login</a></li>
          <li><a href="/signup">Sign Up</a></li>
        </ul>
      </div>
    </nav>
  </header>
  <div class="container" ng-controller="SignupController">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">User Sign Up</h3>
      </div>
      <div class="panel-body">
        <form ng-submit="submit()" name="myForm" class="form-horizontal">
          <input type="hidden" ng-model="user.id" />
          <div class="form-group">
            <label class="col-sm-2 control-label" for="uname">Name</label>
            <div class="col-sm-10">
              <input type="text" ng-model="user.username" id="uname" class="form-control" placeholder="Enter your name" required ng-minlength="2"/>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.uname.$error.required">This is a required field</span>
                <span ng-show="myForm.uname.$error.minlength">Minimum length required is 2</span>
                <span ng-show="myForm.uname.$invalid">This field is invalid </span>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label" for="address">Address</label>
            <div class="col-sm-10">
              <input type="text" ng-model="user.address" id="address" class="form-control" placeholder="Enter your Address. [This field is optional]"/>
            </div>
          </div>


          <div class="form-group">
            <label class="col-sm-2 control-label" for="email">Email</label>
            <div class="col-sm-10">

           <input type="email" ng-model="user.email" id="email" class="form-control" placeholder="Enter your Email" required/>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.email.$error.required">This is a required field</span>
                <span ng-show="myForm.email.$invalid">This field is invalid </span>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <input type="submit"  value="{{!user.id ? 'Add' : 'Update'}}" class="btn btn-primary" ng-disabled="myForm.$invalid">
              <button type="button" ng-click="reset()" class="btn btn-warning" ng-disabled="myForm.$pristine">Reset Form</button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">User Accounts</h3>
      </div>
      <div class="panel-body">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>ID.</th>
              <th>Name</th>
              <th>Address</th>
              <th>Email</th>
              <th width="20%"></th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="u in users">
              <td><span ng-bind="u.id"></span></td>
              <td><span ng-bind="u.username"></span></td>
              <td><span ng-bind="u.address"></span></td>
              <td><span ng-bind="u.email"></span></td>
              <td>
                <button type="button" ng-click="edit(u.id)" class="btn btn-success">Edit</button>  
                <button type="button" ng-click="remove(u.id)" class="btn btn-danger">Remove</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>

</html>