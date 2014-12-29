pdftest-1.0
===========

use different library to extract text content from pdf files

Example: 

(1)run a test class: mvn exec:java -Dexec.mainClass="kenhu1970.itext.LoadByFileExtractByPage" -Dexec.args="50m.pdf" & jstat -gcutil $! 1000 > gcutil 

execute class: kenhu1970.itext.LoadByFileExtractByPage with an argument: 50m.pdf and use jstat to monitor JVM GC utilization, jstat's 
output will be stored in file: gcutil

(2)draw graph: gnuplot gcutil.plt

this will use "gcutil" file as input and generate a graph named "gcutil.png"
