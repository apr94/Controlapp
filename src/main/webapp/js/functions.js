$(window).load(function() {
      setCanvasDimension();
});


$(document).ready(function() {
    $("#MoveMouseButton").click(function(){
        moveMouse();
    });

    $("#StartScreenCaptureButton").click(function(){
        startScreenCapture();
    });


});

function moveMouse()
{
    document.ControllerApplet.moveMouse(10, 10);
}

function startScreenCapture()
{
    var image =  document.ControllerApplet.getScreenShot();
    var canvas = document.getElementById('screen');
    var ctx = canvas.getContext('2d');
    var img = new Image();
    img.src = image;
    img.onload = function(){
        ctx.drawImage(img,0,0,canvas.width, canvas.height);
    };
}

function setCanvasDimension(){
  var canvas = document.getElementById('screen');
  var ctx = canvas.getContext('2d');
  ctx.canvas.width  = $('#container').width();
  ctx.canvas.height = window.innerHeight * 0.8;
}
