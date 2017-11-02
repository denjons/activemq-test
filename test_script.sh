count=$(ps aux | grep -c jenkins)
n=1

if [ $count -gt $n ]
then
echo "true" 
else
echo "not true"
fi

ifconfig | grep inet | grep -E '[1-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}'


ps aux | grep zookeeper | grep -o -E 'dennis\s*[0-9]+'

## find processes frpm names

ps aux | grep zookeeper | grep -oh -E $(whoami)'\s*[0-9]+' | grep -oh -E '[0-9]+'
