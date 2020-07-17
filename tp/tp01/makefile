all:

test: FORCE
	cd helloworld && javac src/Application.java && java -classpath src Application
	cd Operations && javac src/Application.java && (echo "sum\n1 2\n" | java -classpath src Application)

FORCE:
