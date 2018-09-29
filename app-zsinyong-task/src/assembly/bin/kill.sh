 #!/bin/bash
 echo "Start to stop"

 CHECK_STATUE=`ps -ef | grep app-zsingyong-task | grep -v "grep"|wc -l`

 if [ "$CHECK_STATUE" = "0" ]; then

     echo "app-zsingyong-task not found !!!!!"
 elif [ "$CHECK_STATUE" -ge 1 ]; then
         kill -9 $(ps -ef | grep app-zsingyong-task |gawk '$0 !~/grep/ {print $2}' |tr -s '\n' ' ')
         echo "app-zsingyong-task is stopped"
 fi


