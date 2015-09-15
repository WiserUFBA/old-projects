#!/bin/bash

TARGET="/opt"
STARTER_SCRIPT="start.sh"
FILE_APACHE="apache-servicemix-5.4.1-SNAPSHOT.zip"
FILE_JAVA="ejre1.7.0_75.tar.gz"
FOLDER_APACHE="apache"
FOLDER_JAVA="ejre"
SEARCH=$(ls | grep $FOLDER_JAVA)
ISROOT="id -u"
SYM_LINK="/opt/servicemix/start.sh servicemix"

if [ !$ISROOT ]; then
	echo 'ERROR! Login with root'
	exit 1
fi

if [ $SEARCH ]; then
	unzip $FILE_APACHE	
	tar -zxvf $FILE_JAVA
	cp -R $FOLDER_JAVA $DEST
	cd /usr/bin
	ln -s "$TARGET/bin/java" java
	echo 'export JAVA_HOME=/opt/java' >> /etc/profile
	cp -R $FOLDER_APACHE $TARGET
	cd $TARGET
	mv $FOLDER_APACHE servicemix
	cp -R $STARTER_SCRIPT $TARGET/servicemix
	chmod +x $TARGET/servicemix/$STARTER_SCRIPT
	cd /usr/bin
	ln -s $SYM_LINK
fi

echo 'Installation completed'

exit 0
