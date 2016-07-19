#!/bin/sh -f
classdir=`dirname $1`
if test ! -d $classdir;
then mkdir -p $classdir;
fi
touch $1
