var nIntervId;
var appletHeight;
var appletWidth;

$(window).load(function() {
		
		appletWidth = $('#VideoScreen').width();
		appletHeight = window.innerHeight * 0.9;
		setAppletDimension();
		});


$(window).resize(function() {

		setAppletDimension();

		});


$(document).ready(function() {
		$("#MoveMouseButton").click(function(){
			moveMouse();
			});

		$("#StartScreenCaptureButton").click(function(){
			startScreenCapture();
			});

		$("#StopScreenCaptureButton").click(function(){
			stopScreenCapture();
			});


		$("#test").click(function(){
			test();	
			});


		});

function moveMouse()
{
	document.ControllerApplet.moveMouse(10, 10);
}

function screenCaptureDaemon()
{
	document.ControllerApplet.captureScreen();
}

function setAppletDimension(){

	document.ControllerApplet.height = appletHeight;
	document.ControllerApplet.width = appletWidth;

	$("#VideoScreen").height(window.innerHeight * 0.9);
}

function startScreenCapture() {
	nIntervId = setInterval(function(){screenCaptureDaemon(1)}, 5);
}

function test(){
	screenCaptureDaemon();
}

function stopScreenCapture()
{
	clearInterval(nIntervId);
}
