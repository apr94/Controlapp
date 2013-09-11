#!/bin/sh


if [ "$1" = "0" ]; then

	rm *.class
	rm *.jar
	javac Controller.java
	jar cvf Controller.jar *.class
	jarsigner Controller.jar key
	rm ../../../controlapp/src/main/webapp/Controller.*
	rm ../../../controlapp/src/main/webapp/*.class
	cp *.* ../../../controlapp/src/main/webapp/
	cd ../../../controlapp/
	git init
	git add .
	git commit -m "Applet"
	git push heroku master

else

	rm *.class
	rm *.jar
	javac Controller.java
	jar cvf Controller.jar *.class
	jarsigner Controller.jar key
	cd ../../../../
	git init
	git add .
	git commit -m "Applet"
	git push heroku master                       
fi
