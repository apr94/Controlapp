<!DOCTYPE HTML>
<html>
<head>

<meta charset="utf-8">
<meta name="Description" CONTENT="A Remote Terminal Controlling Application">
<title>Control App</title>
<meta name="robots" content="noindex,nofollow">

<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/Functions.js"></script>
</head>

<body>
<div id = "container">

<div id = "VideoScreen">
<object id = "ControllerApplet" name = "ControllerApplet" type="application/x-java-applet" codebase = "classes">
<param name="code" value="Controller" />
<param name="archive" value="Controller.jar" />
<param name="permissions" value="all-permissions" />
<param name="mayscript" value="true" />
Applet failed to run.  No Java plug-in was found.
</object>
</div>

<div id = "Controls">
<button id = "MoveMouseButton">Move Mouse</button>
<button id = "StartScreenCaptureButton">Start Screen Sharing</button>
<button id = "StopScreenCaptureButton">End Screen Sharing</button>
<button id = "test">test</button>
</div>

</div>
</body>
</html>

