<%--

    Cerberus Copyright (C) 2013 - 2017 cerberustesting
    DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.

    This file is part of Cerberus.

    Cerberus is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Cerberus is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="include/global/dependenciesInclusions.html" %>
    <title>Test Battery</title>
    <script type="text/javascript" src="js/pages/TestBattery.js"></script>
</head>
<body>
<%@ include file="include/global/header.html" %>
<div class="container-fluid center" id="page-layout">
    <%@ include file="include/global/messagesArea.html"%>
    <%@ include file="include/utils/modal-confirmation.html"%>
    <%@ include file="include/pages/testbattery/editTestbattery.html"%>

    <h1 class="page-title-line" id="title">Test Battery</h1>
    <div class="panel panel-default">
        <div class="panel-heading" id="testbatteryListLabel">
            <span class="glyphicon glyphicon-list"></span>
            Test Battery
        </div>
        <div class="panel-body" id="testbatteryList">
            <table id="testbatterysTable" class="table table-bordered table-hover display" name="testbatterysTable"></table>
            <div class="marginBottom20"></div>
        </div>
    </div>
    <footer class="footer">
        <div class="container-fluid" id="footer"></div>
    </footer>
</div>
</body>
</html>